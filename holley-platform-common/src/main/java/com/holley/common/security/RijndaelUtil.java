package com.holley.common.security;

import java.security.InvalidKeyException;

/**
 * 这个类用于方便对数据使用AES算法对数据进行加密。AES算法只能一块一块对数据进行加密。
 * 
 * @author szuJobs
 */
public class RijndaelUtil {

    private static final int DEFAULT_BLOCK_SIZE = 16;

    /**
     * 将4个byte组装成一个整数
     * 
     * @param bytes
     * @param offSet
     * @return
     */
    public final static int getInt(byte[] bytes, int offSet) {
        return ((((bytes[offSet + 0] & 0xff) << 24) | ((bytes[offSet + 1]) << 16) | ((bytes[offSet + 2] & 0xff) << 8) | ((bytes[offSet + 3] & 0xff) << 0)));
    }

    /**
     * 将一个整数拆为4个byte
     * 
     * @param val
     * @param bytes
     * @param offSet
     */
    public final static void putInt(int val, byte[] bytes, int offSet) {
        bytes[offSet] = (byte) (val >> 24);
        bytes[offSet + 1] = (byte) (val >> 16);
        bytes[offSet + 2] = (byte) (val >> 8);
        bytes[offSet + 3] = (byte) val;
    }

    public static String byte2String(byte[] bytes) {
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < bytes.length; ++i) {
            if (i != 0) {
                buff.append(", ");
            }
            buff.append(bytes[i]);
        }
        return buff.toString();
    }

    public static byte[] makeKb16(String strKey) {
        return makeKb(strKey, 16);
    }

    public static byte[] makeKb24(String strKey) {
        return makeKb(strKey, 24);
    }

    public static byte[] makeKb32(String strKey) {
        return makeKb(strKey, 32);
    }

    private static byte[] makeKb(String strKey, int size) {
        byte[] kb = new byte[size];
        byte[] bytes = strKey.getBytes();
        System.arraycopy(bytes, 0, kb, 0, bytes.length > size ? size : bytes.length);
        return kb;
    }

    public static String encode(String key, String strData) throws InvalidKeyException {
        byte[] kb = makeKb32(key);
        byte[] pt = strData.getBytes();
        byte[] ct = encode(kb, pt, DEFAULT_BLOCK_SIZE);
        return Base64.encode(ct);
    }

    public static String encode(String key, String strData, int blockSize) throws InvalidKeyException {
        byte[] kb = makeKb32(key);
        byte[] pt = strData.getBytes();
        byte[] ct = encode(kb, pt, blockSize);
        return Base64.encode(ct);
    }

    public static String decode(String key, String strData) throws InvalidKeyException {
        byte[] kb = makeKb32(key);
        byte[] ct = Base64.decode(strData);
        byte[] cpt = decode(kb, ct, DEFAULT_BLOCK_SIZE);
        return new String(cpt);
    }

    public static String decode(String key, String strData, int blockSize) throws InvalidKeyException {
        byte[] kb = makeKb32(key);
        byte[] ct = Base64.decode(strData);
        byte[] cpt = decode(kb, ct, blockSize);
        return new String(cpt);
    }

    public static byte[] encode(byte[] kb, byte[] pt, int blockSize) throws InvalidKeyException {
        Object key = RijndaelAlgorithm.makeKey(kb, blockSize);

        int dataLength = pt.length;

        int mode = dataLength % blockSize;

        byte[] ct = new byte[mode == 0 ? pt.length : 8 + dataLength + blockSize - mode];

        for (int i = 0; i < dataLength; i += blockSize) {
            int restDataLength = dataLength - i;

            if (restDataLength >= blockSize) {
                byte[] blockct = RijndaelAlgorithm.blockEncrypt(pt, i, key, blockSize);
                System.arraycopy(blockct, 0, ct, i, blockSize);
            } else {
                if (blockSize == 16 || blockSize == 24) {
                    Object lastblockkey = RijndaelAlgorithm.makeKey(kb, blockSize + 8);
                    byte[] blockpt = new byte[blockSize + 8];
                    System.arraycopy(pt, i, blockpt, 0, restDataLength);
                    putInt(dataLength, blockpt, blockSize);

                    byte[] blockct = RijndaelAlgorithm.blockEncrypt(blockpt, 0, lastblockkey, blockSize + 8);

                    System.arraycopy(blockct, 0, ct, i, blockSize + 8);
                } else { // 32
                    Object key16 = RijndaelAlgorithm.makeKey(kb, 16);
                    byte[] block24pt = new byte[24];
                    if (restDataLength > 16) {
                        byte[] block16ct = RijndaelAlgorithm.blockEncrypt(pt, i, key16, 16);
                        restDataLength -= 16;
                        System.arraycopy(block16ct, 0, ct, i, 16);

                        System.arraycopy(pt, i + 16, block24pt, 0, restDataLength);
                    } else {
                        byte[] blockpt = new byte[16];
                        System.arraycopy(pt, i, blockpt, 0, restDataLength);

                        byte[] block16ct = RijndaelAlgorithm.blockEncrypt(blockpt, 0, key16, 16);
                        System.arraycopy(block16ct, 0, ct, i, 16);
                    }

                    Object key24 = RijndaelAlgorithm.makeKey(kb, 24);

                    putInt(dataLength, block24pt, 16);

                    byte[] block24ct = RijndaelAlgorithm.blockEncrypt(block24pt, 0, key24, 24);
                    System.arraycopy(block24ct, 0, ct, i + 16, 24);
                }
            }
        }

        return ct;
    }

    public static byte[] decode(byte[] kb, byte[] ct, int blockSize) throws InvalidKeyException {

        int mode = ct.length % blockSize;

        Object key = RijndaelAlgorithm.makeKey(kb, blockSize);

        byte[] pt;
        if (mode == 0) {
            pt = new byte[ct.length];

            for (int i = 0; i < ct.length; i += blockSize) {
                byte[] blockpt = RijndaelAlgorithm.blockDecrypt(ct, i, key, blockSize);

                System.arraycopy(blockpt, 0, pt, i, blockSize);
            }
        } else {
            if (blockSize == 16 || blockSize == 24) {
                Object firstKey = RijndaelAlgorithm.makeKey(kb, blockSize + 8);
                byte[] lastblockpt = RijndaelAlgorithm.blockDecrypt(ct, ct.length - blockSize - 8, firstKey, blockSize + 8);

                int dataLength = getInt(lastblockpt, blockSize);

                pt = new byte[dataLength];
                System.arraycopy(lastblockpt, 0, pt, ct.length - blockSize - 8, dataLength % blockSize);
            } else { // 32
                Object key24 = RijndaelAlgorithm.makeKey(kb, 24);
                byte[] lastblock24pt = RijndaelAlgorithm.blockDecrypt(ct, ct.length - 24, key24, 24);

                int dataLength = getInt(lastblock24pt, 16);
                pt = new byte[dataLength];

                if (dataLength > ct.length - 24) {
                    System.arraycopy(lastblock24pt, 0, pt, ct.length - 24, dataLength - (ct.length - 24));
                }

                Object key16 = RijndaelAlgorithm.makeKey(kb, 16);
                byte[] lastblock16pt = RijndaelAlgorithm.blockDecrypt(ct, ct.length - 24 - 16, key16, 16);
                if (pt.length > ct.length - 24) {
                    System.arraycopy(lastblock16pt, 0, pt, ct.length - 24 - 16, 16);
                } else {
                    System.arraycopy(lastblock16pt, 0, pt, ct.length - 24 - 16, pt.length - (ct.length - 24 - 16));
                }
            }

            for (int i = 0; i < ct.length - blockSize - 8; i += blockSize) {
                byte[] blockpt = RijndaelAlgorithm.blockDecrypt(ct, i, key, blockSize);
                System.arraycopy(blockpt, 0, pt, i, blockSize);
            }
        }

        return pt;
    }

    /**
     * 加密密码
     * 
     * @throws InvalidKeyException
     */
    public static String encodePassword(String mm) throws InvalidKeyException {
        if (mm == "" || mm == null) {
            return mm;
        } else {
            String strKey = "@$DcS*&DB09^%12!Efw";
            int blockSize = 32;
            String jmmm = encode(strKey, mm, blockSize);
            return jmmm;
        }
    }

    /**
     * 解密密码
     * 
     * @throws InvalidKeyException
     */
    public static String decodePassword(String mm) throws InvalidKeyException {
        if (mm == "" || mm == null) {
            return mm;
        } else {
            String strKey = "@$DcS*&DB09^%12!Efw";
            int blockSize = 32;
            String jmmm = decode(strKey, mm, blockSize);
            return jmmm;
        }
    }

    public static void main(String[] args) {

        String data = "root";

        String de;
        try {
            de = encodePassword(data);
            System.out.println(de);
            System.out.println(decodePassword(de));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

    }

}
