package com.holley.common.security;

// $Id: RijndaelAlgorithm.java,v 1.1 2008/08/26 02:10:35 zfh Exp $
//
// $Log: RijndaelAlgorithm.java,v $
// Revision 1.1 2008/08/26 02:10:35 zfh
// *** empty log message ***
//
// Revision 1.1 2007/12/05 09:33:09 ww
// *** empty log message ***
//
// Revision 1.1 2001/05/21 02:24:30 jis
// First version
//
// Revision 1.1 1998/04/12 Paulo
// + optimized methods for the default 128-bit block size.
//
// Revision 1.0 1998/03/11 Raif
// + original version.
//
// $Endlog$
/*
 * Copyright (c) 1997, 1998 Systemics Ltd on behalf of the Cryptix Development Team. All rights reserved.
 */

import java.io.PrintWriter;
import java.security.InvalidKeyException;

// ...........................................................................
/**
 * Rijndael --pronounced Reindaal-- is a variable block-size (128-, 192- and 256-bit), variable key-size (128-, 192- and
 * 256-bit) symmetric cipher.
 * <p>
 * Rijndael was written by <a href="mailto:rijmen@esat.kuleuven.ac.be">Vincent Rijmen</a> and <a
 * href="mailto:Joan.Daemen@village.uunet.be">Joan Daemen</a>.
 * <p>
 * Portions of this code are <b>Copyright</b> &copy; 1997, 1998 <a href="http://www.systemics.com/">Systemics Ltd</a> on
 * behalf of the <a href="http://www.systemics.com/docs/cryptix/">Cryptix Development Team</a>. <br>
 * All rights reserved.
 * <p>
 * <b>$Revision: 1.1 $</b>
 * 
 * @author Raif S. Naffah
 * @author Paulo S. L. M. Barreto
 */
public final class RijndaelAlgorithm {// implicit no-argument constructor

    // Debugging methods and variables
    // ...........................................................................

    static final String      NAME       = "Rijndael_Algorithm";

    static final boolean     IN         = true, OUT = false;

    static final boolean     DEBUG      = RijndaelProperties.GLOBAL_DEBUG;

    static final int         DEBUGLEVEL = DEBUG ? RijndaelProperties.getLevel(NAME) : 0;

    static final PrintWriter ERR        = DEBUG ? RijndaelProperties.getOutput() : null;

    static final boolean     TRACE      = RijndaelProperties.isTraceable(NAME);

    static void debug(String s) {
        ERR.println(">>> " + NAME + ": " + s);
    }

    static void trace(boolean in, String s) {
        if (TRACE) ERR.println((in ? "==> " : "<== ") + NAME + "." + s);
    }

    static void trace(String s) {
        if (TRACE) ERR.println("<=> " + NAME + "." + s);
    }

    // Constants and variables
    // ...........................................................................

    static final int            BLOCK_SIZE = 16;                                                     // default block
    // size in bytes

    static final int[]          ALOG       = new int[256];

    static final int[]          LOG        = new int[256];

    static final byte[]         S          = new byte[256];

    static final byte[]         SI         = new byte[256];

    static final int[]          T1         = new int[256];

    static final int[]          T2         = new int[256];

    static final int[]          T3         = new int[256];

    static final int[]          T4         = new int[256];

    static final int[]          T5         = new int[256];

    static final int[]          T6         = new int[256];

    static final int[]          T7         = new int[256];

    static final int[]          T8         = new int[256];

    static final int[]          U1         = new int[256];

    static final int[]          U2         = new int[256];

    static final int[]          U3         = new int[256];

    static final int[]          U4         = new int[256];

    static final byte[]         RCON       = new byte[30];

    static final int[][][]      SHIFTS     = new int[][][] { { { 0, 0 }, { 1, 3 }, { 2, 2 }, { 3, 1 } },
            { { 0, 0 }, { 1, 5 }, { 2, 4 }, { 3, 3 } }, { { 0, 0 }, { 1, 7 }, { 3, 5 }, { 4, 4 } } };

    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F'                      };

    // Static code - to intialise S-boxes and T-boxes
    // ...........................................................................

    static {
        long time = System.currentTimeMillis();

        if (DEBUG && DEBUGLEVEL > 6) {
            System.out.println("Algorithm Name: " + RijndaelProperties.FULL_NAME);
            System.out.println("Electronic Codebook (ECB) Mode");
            System.out.println();
        }
        int root = 0x11B;
        int i, j = 0;

        //
        // produce log and alog tables, needed for multiplying in the
        // field GF(2^m) (generator = 3)
        //
        ALOG[0] = 1;
        for (i = 1; i < 256; i++) {
            j = (ALOG[i - 1] << 1) ^ ALOG[i - 1];
            if ((j & 0x100) != 0) j ^= root;
            ALOG[i] = j;
        }
        for (i = 1; i < 255; i++)
            LOG[ALOG[i]] = i;
        byte[][] a = new byte[][] { { 1, 1, 1, 1, 1, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1, 1, 1, 0 },
            { 0, 0, 0, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1 }, { 1, 1, 0, 0, 0, 1, 1, 1 },
            { 1, 1, 1, 0, 0, 0, 1, 1 }, { 1, 1, 1, 1, 0, 0, 0, 1 } };
        byte[] b = new byte[] { 0, 1, 1, 0, 0, 0, 1, 1 };

        //
        // substitution box based on F^{-1}(x)
        //
        int t;
        byte[][] box = new byte[256][8];
        box[1][7] = 1;
        for (i = 2; i < 256; i++) {
            j = ALOG[255 - LOG[i]];
            for (t = 0; t < 8; t++)
                box[i][t] = (byte) ((j >>> (7 - t)) & 0x01);
        }
        //
        // affine transform: box[i] <- B + A*box[i]
        //
        byte[][] cox = new byte[256][8];
        for (i = 0; i < 256; i++)
            for (t = 0; t < 8; t++) {
                cox[i][t] = b[t];
                for (j = 0; j < 8; j++)
                    cox[i][t] ^= a[t][j] * box[i][j];
            }
        //
        // S-boxes and inverse S-boxes
        //
        for (i = 0; i < 256; i++) {
            S[i] = (byte) (cox[i][0] << 7);
            for (t = 1; t < 8; t++)
                S[i] ^= cox[i][t] << (7 - t);
            SI[S[i] & 0xFF] = (byte) i;
        }
        //
        // T-boxes
        //
        byte[][] g = new byte[][] { { 2, 1, 1, 3 }, { 3, 2, 1, 1 }, { 1, 3, 2, 1 }, { 1, 1, 3, 2 } };
        byte[][] aa = new byte[4][8];
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++)
                aa[i][j] = g[i][j];
            aa[i][i + 4] = 1;
        }
        byte pivot, tmp;
        byte[][] iG = new byte[4][4];
        for (i = 0; i < 4; i++) {
            pivot = aa[i][i];
            if (pivot == 0) {
                t = i + 1;
                while ((aa[t][i] == 0) && (t < 4))
                    t++;
                if (t == 4) throw new RuntimeException("G matrix is not invertible");
                else {
                    for (j = 0; j < 8; j++) {
                        tmp = aa[i][j];
                        aa[i][j] = aa[t][j];
                        aa[t][j] = (byte) tmp;
                    }
                    pivot = aa[i][i];
                }
            }
            for (j = 0; j < 8; j++)
                if (aa[i][j] != 0) aa[i][j] = (byte) ALOG[(255 + LOG[aa[i][j] & 0xFF] - LOG[pivot & 0xFF]) % 255];
            for (t = 0; t < 4; t++)
                if (i != t) {
                    for (j = i + 1; j < 8; j++)
                        aa[t][j] ^= mul(aa[i][j], aa[t][i]);
                    aa[t][i] = 0;
                }
        }
        for (i = 0; i < 4; i++)
            for (j = 0; j < 4; j++)
                iG[i][j] = aa[i][j + 4];

        int s;
        for (t = 0; t < 256; t++) {
            s = S[t];
            T1[t] = mul4(s, g[0]);
            T2[t] = mul4(s, g[1]);
            T3[t] = mul4(s, g[2]);
            T4[t] = mul4(s, g[3]);

            s = SI[t];
            T5[t] = mul4(s, iG[0]);
            T6[t] = mul4(s, iG[1]);
            T7[t] = mul4(s, iG[2]);
            T8[t] = mul4(s, iG[3]);

            U1[t] = mul4(t, iG[0]);
            U2[t] = mul4(t, iG[1]);
            U3[t] = mul4(t, iG[2]);
            U4[t] = mul4(t, iG[3]);
        }
        //
        // round constants
        //
        RCON[0] = 1;
        int r = 1;
        for (t = 1; t < 30;) {
            r = mul(2, r);
            RCON[t++] = (byte) (r);
        }

        time = System.currentTimeMillis() - time;

        if (DEBUG && DEBUGLEVEL > 8) {
            System.out.println("==========");
            System.out.println();
            System.out.println("Static Data");
            System.out.println();
            System.out.println("S[]:");
            for (i = 0; i < 16; i++) {
                for (j = 0; j < 16; j++)
                    System.out.print("0x" + byteToString(S[i * 16 + j]) + ", ");
                System.out.println();
            }
            System.out.println();
            System.out.println("SI[]:");
            for (i = 0; i < 16; i++) {
                for (j = 0; j < 16; j++)
                    System.out.print("0x" + byteToString(SI[i * 16 + j]) + ", ");
                System.out.println();
            }

            System.out.println();
            System.out.println("iG[]:");
            for (i = 0; i < 4; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + byteToString(iG[i][j]) + ", ");
                System.out.println();
            }

            System.out.println();
            System.out.println("T1[]:");
            for (i = 0; i < 64; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + intToString(T1[i * 4 + j]) + ", ");
                System.out.println();
            }
            System.out.println();
            System.out.println("T2[]:");
            for (i = 0; i < 64; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + intToString(T2[i * 4 + j]) + ", ");
                System.out.println();
            }
            System.out.println();
            System.out.println("T3[]:");
            for (i = 0; i < 64; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + intToString(T3[i * 4 + j]) + ", ");
                System.out.println();
            }
            System.out.println();
            System.out.println("T4[]:");
            for (i = 0; i < 64; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + intToString(T4[i * 4 + j]) + ", ");
                System.out.println();
            }
            System.out.println();
            System.out.println("T5[]:");
            for (i = 0; i < 64; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + intToString(T5[i * 4 + j]) + ", ");
                System.out.println();
            }
            System.out.println();
            System.out.println("T6[]:");
            for (i = 0; i < 64; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + intToString(T6[i * 4 + j]) + ", ");
                System.out.println();
            }
            System.out.println();
            System.out.println("T7[]:");
            for (i = 0; i < 64; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + intToString(T7[i * 4 + j]) + ", ");
                System.out.println();
            }
            System.out.println();
            System.out.println("T8[]:");
            for (i = 0; i < 64; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + intToString(T8[i * 4 + j]) + ", ");
                System.out.println();
            }

            System.out.println();
            System.out.println("U1[]:");
            for (i = 0; i < 64; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + intToString(U1[i * 4 + j]) + ", ");
                System.out.println();
            }
            System.out.println();
            System.out.println("U2[]:");
            for (i = 0; i < 64; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + intToString(U2[i * 4 + j]) + ", ");
                System.out.println();
            }
            System.out.println();
            System.out.println("U3[]:");
            for (i = 0; i < 64; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + intToString(U3[i * 4 + j]) + ", ");
                System.out.println();
            }
            System.out.println();
            System.out.println("U4[]:");
            for (i = 0; i < 64; i++) {
                for (j = 0; j < 4; j++)
                    System.out.print("0x" + intToString(U4[i * 4 + j]) + ", ");
                System.out.println();
            }

            System.out.println();
            System.out.println("rcon[]:");
            for (i = 0; i < 5; i++) {
                for (j = 0; j < 6; j++)
                    System.out.print("0x" + byteToString(RCON[i * 6 + j]) + ", ");
                System.out.println();
            }

            System.out.println();
            System.out.println("Total initialization time: " + time + " ms.");
            System.out.println();
        }
    }

    // multiply two elements of GF(2^m)
    static final int mul(int a, int b) {
        return (a != 0 && b != 0) ? ALOG[(LOG[a & 0xFF] + LOG[b & 0xFF]) % 255] : 0;
    }

    // convenience method used in generating Transposition boxes
    static final int mul4(int a, byte[] b) {
        if (a == 0) return 0;
        a = LOG[a & 0xFF];
        int a0 = (b[0] != 0) ? ALOG[(a + LOG[b[0] & 0xFF]) % 255] & 0xFF : 0;
        int a1 = (b[1] != 0) ? ALOG[(a + LOG[b[1] & 0xFF]) % 255] & 0xFF : 0;
        int a2 = (b[2] != 0) ? ALOG[(a + LOG[b[2] & 0xFF]) % 255] & 0xFF : 0;
        int a3 = (b[3] != 0) ? ALOG[(a + LOG[b[3] & 0xFF]) % 255] & 0xFF : 0;
        return a0 << 24 | a1 << 16 | a2 << 8 | a3;
    }

    // Basic API methods
    // ...........................................................................

    /**
     * Convenience method to expand a user-supplied key material into a session key, assuming Rijndael's default block
     * size (128-bit).
     * 
     * @param key The 128/192/256-bit user-key to use.
     * @exception InvalidKeyException If the key is invalid.
     */
    public static Object makeKey(byte[] k) throws InvalidKeyException {
        return makeKey(k, BLOCK_SIZE);
    }

    /**
     * Convenience method to encrypt exactly one block of plaintext, assuming Rijndael's default block size (128-bit).
     * 
     * @param in The plaintext.
     * @param inOffset Index of in from which to start considering data.
     * @param sessionKey The session key to use for encryption.
     * @return The ciphertext generated from a plaintext using the session key.
     */
    public static byte[] blockEncrypt(byte[] in, int inOffset, Object sessionKey) {
        if (DEBUG) trace(IN, "blockEncrypt(" + in + ", " + inOffset + ", " + sessionKey + ")");
        int[][] ke = (int[][]) ((Object[]) sessionKey)[0]; // extract
        // encryption round
        // keys
        int rounds = ke.length - 1;
        int[] ker = ke[0];

        // plaintext to ints + key
        int t0 = ((in[inOffset++] & 0xFF) << 24 | (in[inOffset++] & 0xFF) << 16 | (in[inOffset++] & 0xFF) << 8 | (in[inOffset++] & 0xFF))
                 ^ ker[0];
        int t1 = ((in[inOffset++] & 0xFF) << 24 | (in[inOffset++] & 0xFF) << 16 | (in[inOffset++] & 0xFF) << 8 | (in[inOffset++] & 0xFF))
                 ^ ker[1];
        int t2 = ((in[inOffset++] & 0xFF) << 24 | (in[inOffset++] & 0xFF) << 16 | (in[inOffset++] & 0xFF) << 8 | (in[inOffset++] & 0xFF))
                 ^ ker[2];
        int t3 = ((in[inOffset++] & 0xFF) << 24 | (in[inOffset++] & 0xFF) << 16 | (in[inOffset++] & 0xFF) << 8 | (in[inOffset++] & 0xFF))
                 ^ ker[3];

        int a0, a1, a2, a3;
        for (int r = 1; r < rounds; r++) { // apply round transforms
            ker = ke[r];
            a0 = (T1[(t0 >>> 24) & 0xFF] ^ T2[(t1 >>> 16) & 0xFF] ^ T3[(t2 >>> 8) & 0xFF] ^ T4[t3 & 0xFF]) ^ ker[0];
            a1 = (T1[(t1 >>> 24) & 0xFF] ^ T2[(t2 >>> 16) & 0xFF] ^ T3[(t3 >>> 8) & 0xFF] ^ T4[t0 & 0xFF]) ^ ker[1];
            a2 = (T1[(t2 >>> 24) & 0xFF] ^ T2[(t3 >>> 16) & 0xFF] ^ T3[(t0 >>> 8) & 0xFF] ^ T4[t1 & 0xFF]) ^ ker[2];
            a3 = (T1[(t3 >>> 24) & 0xFF] ^ T2[(t0 >>> 16) & 0xFF] ^ T3[(t1 >>> 8) & 0xFF] ^ T4[t2 & 0xFF]) ^ ker[3];
            t0 = a0;
            t1 = a1;
            t2 = a2;
            t3 = a3;
            if (DEBUG && DEBUGLEVEL > 6) System.out.println("CT" + r + "=" + intToString(t0) + intToString(t1)
                                                            + intToString(t2) + intToString(t3));
        }

        // last round is special
        byte[] result = new byte[BLOCK_SIZE]; // the resulting ciphertext
        ker = ke[rounds];
        int tt = ker[0];
        result[0] = (byte) (S[(t0 >>> 24) & 0xFF] ^ (tt >>> 24));
        result[1] = (byte) (S[(t1 >>> 16) & 0xFF] ^ (tt >>> 16));
        result[2] = (byte) (S[(t2 >>> 8) & 0xFF] ^ (tt >>> 8));
        result[3] = (byte) (S[t3 & 0xFF] ^ tt);
        tt = ker[1];
        result[4] = (byte) (S[(t1 >>> 24) & 0xFF] ^ (tt >>> 24));
        result[5] = (byte) (S[(t2 >>> 16) & 0xFF] ^ (tt >>> 16));
        result[6] = (byte) (S[(t3 >>> 8) & 0xFF] ^ (tt >>> 8));
        result[7] = (byte) (S[t0 & 0xFF] ^ tt);
        tt = ker[2];
        result[8] = (byte) (S[(t2 >>> 24) & 0xFF] ^ (tt >>> 24));
        result[9] = (byte) (S[(t3 >>> 16) & 0xFF] ^ (tt >>> 16));
        result[10] = (byte) (S[(t0 >>> 8) & 0xFF] ^ (tt >>> 8));
        result[11] = (byte) (S[t1 & 0xFF] ^ tt);
        tt = ker[3];
        result[12] = (byte) (S[(t3 >>> 24) & 0xFF] ^ (tt >>> 24));
        result[13] = (byte) (S[(t0 >>> 16) & 0xFF] ^ (tt >>> 16));
        result[14] = (byte) (S[(t1 >>> 8) & 0xFF] ^ (tt >>> 8));
        result[15] = (byte) (S[t2 & 0xFF] ^ tt);
        if (DEBUG && DEBUGLEVEL > 6) {
            System.out.println("CT=" + toString(result));
            System.out.println();
        }
        if (DEBUG) trace(OUT, "blockEncrypt()");
        return result;
    }

    /**
     * Convenience method to decrypt exactly one block of plaintext, assuming Rijndael's default block size (128-bit).
     * 
     * @param in The ciphertext.
     * @param inOffset Index of in from which to start considering data.
     * @param sessionKey The session key to use for decryption.
     * @return The plaintext generated from a ciphertext using the session key.
     */
    public static byte[] blockDecrypt(byte[] in, int inOffset, Object sessionKey) {
        if (DEBUG) trace(IN, "blockDecrypt(" + in + ", " + inOffset + ", " + sessionKey + ")");
        int[][] kd = (int[][]) ((Object[]) sessionKey)[1]; // extract
        // decryption round
        // keys
        int rounds = kd.length - 1;
        int[] kdr = kd[0];

        // ciphertext to ints + key
        int t0 = ((in[inOffset++] & 0xFF) << 24 | (in[inOffset++] & 0xFF) << 16 | (in[inOffset++] & 0xFF) << 8 | (in[inOffset++] & 0xFF))
                 ^ kdr[0];
        int t1 = ((in[inOffset++] & 0xFF) << 24 | (in[inOffset++] & 0xFF) << 16 | (in[inOffset++] & 0xFF) << 8 | (in[inOffset++] & 0xFF))
                 ^ kdr[1];
        int t2 = ((in[inOffset++] & 0xFF) << 24 | (in[inOffset++] & 0xFF) << 16 | (in[inOffset++] & 0xFF) << 8 | (in[inOffset++] & 0xFF))
                 ^ kdr[2];
        int t3 = ((in[inOffset++] & 0xFF) << 24 | (in[inOffset++] & 0xFF) << 16 | (in[inOffset++] & 0xFF) << 8 | (in[inOffset++] & 0xFF))
                 ^ kdr[3];

        int a0, a1, a2, a3;
        for (int r = 1; r < rounds; r++) { // apply round transforms
            kdr = kd[r];
            a0 = (T5[(t0 >>> 24) & 0xFF] ^ T6[(t3 >>> 16) & 0xFF] ^ T7[(t2 >>> 8) & 0xFF] ^ T8[t1 & 0xFF]) ^ kdr[0];
            a1 = (T5[(t1 >>> 24) & 0xFF] ^ T6[(t0 >>> 16) & 0xFF] ^ T7[(t3 >>> 8) & 0xFF] ^ T8[t2 & 0xFF]) ^ kdr[1];
            a2 = (T5[(t2 >>> 24) & 0xFF] ^ T6[(t1 >>> 16) & 0xFF] ^ T7[(t0 >>> 8) & 0xFF] ^ T8[t3 & 0xFF]) ^ kdr[2];
            a3 = (T5[(t3 >>> 24) & 0xFF] ^ T6[(t2 >>> 16) & 0xFF] ^ T7[(t1 >>> 8) & 0xFF] ^ T8[t0 & 0xFF]) ^ kdr[3];
            t0 = a0;
            t1 = a1;
            t2 = a2;
            t3 = a3;
            if (DEBUG && DEBUGLEVEL > 6) System.out.println("PT" + r + "=" + intToString(t0) + intToString(t1)
                                                            + intToString(t2) + intToString(t3));
        }

        // last round is special
        byte[] result = new byte[16]; // the resulting plaintext
        kdr = kd[rounds];
        int tt = kdr[0];
        result[0] = (byte) (SI[(t0 >>> 24) & 0xFF] ^ (tt >>> 24));
        result[1] = (byte) (SI[(t3 >>> 16) & 0xFF] ^ (tt >>> 16));
        result[2] = (byte) (SI[(t2 >>> 8) & 0xFF] ^ (tt >>> 8));
        result[3] = (byte) (SI[t1 & 0xFF] ^ tt);
        tt = kdr[1];
        result[4] = (byte) (SI[(t1 >>> 24) & 0xFF] ^ (tt >>> 24));
        result[5] = (byte) (SI[(t0 >>> 16) & 0xFF] ^ (tt >>> 16));
        result[6] = (byte) (SI[(t3 >>> 8) & 0xFF] ^ (tt >>> 8));
        result[7] = (byte) (SI[t2 & 0xFF] ^ tt);
        tt = kdr[2];
        result[8] = (byte) (SI[(t2 >>> 24) & 0xFF] ^ (tt >>> 24));
        result[9] = (byte) (SI[(t1 >>> 16) & 0xFF] ^ (tt >>> 16));
        result[10] = (byte) (SI[(t0 >>> 8) & 0xFF] ^ (tt >>> 8));
        result[11] = (byte) (SI[t3 & 0xFF] ^ tt);
        tt = kdr[3];
        result[12] = (byte) (SI[(t3 >>> 24) & 0xFF] ^ (tt >>> 24));
        result[13] = (byte) (SI[(t2 >>> 16) & 0xFF] ^ (tt >>> 16));
        result[14] = (byte) (SI[(t1 >>> 8) & 0xFF] ^ (tt >>> 8));
        result[15] = (byte) (SI[t0 & 0xFF] ^ tt);
        if (DEBUG && DEBUGLEVEL > 6) {
            System.out.println("PT=" + toString(result));
            System.out.println();
        }
        if (DEBUG) trace(OUT, "blockDecrypt()");
        return result;
    }

    /** A basic symmetric encryption/decryption test. */
    public static boolean selfTest() {
        return selfTest(BLOCK_SIZE);
    }

    // Rijndael own methods
    // ...........................................................................

    /** @return The default length in bytes of the Algorithm input block. */
    public static int blockSize() {
        return BLOCK_SIZE;
    }

    /**
     * Expand a user-supplied key material into a session key.
     * 
     * @param key The 128/192/256-bit user-key to use.
     * @param blockSIze The block size in bytes of this Rijndael.
     * @exception InvalidKeyException If the key is invalid.
     */
    public static synchronized Object makeKey(byte[] k, int blockSize) throws InvalidKeyException {
        if (DEBUG) trace(IN, "makeKey(" + k + ", " + blockSize + ")");
        if (k == null) throw new InvalidKeyException("Empty key");
        if (!(k.length == 16 || k.length == 24 || k.length == 32)) throw new InvalidKeyException("Incorrect key length");
        int rounds = getRounds(k.length, blockSize);
        int bc = blockSize / 4;
        int[][] ke = new int[rounds + 1][bc]; // encryption round keys
        int[][] kd = new int[rounds + 1][bc]; // decryption round keys
        int roundKeyCount = (rounds + 1) * bc;
        int kc = k.length / 4;
        int[] tk = new int[kc];
        int i, j;

        // copy user material bytes into temporary ints
        for (i = 0, j = 0; i < kc;)
            tk[i++] = (k[j++] & 0xFF) << 24 | (k[j++] & 0xFF) << 16 | (k[j++] & 0xFF) << 8 | (k[j++] & 0xFF);
        // copy values into round key arrays
        int t = 0;
        for (j = 0; (j < kc) && (t < roundKeyCount); j++, t++) {
            ke[t / bc][t % bc] = tk[j];
            kd[rounds - (t / bc)][t % bc] = tk[j];
        }
        int tt, rconpointer = 0;
        while (t < roundKeyCount) {
            // extrapolate using phi (the round key evolution function)
            tt = tk[kc - 1];
            tk[0] ^= (S[(tt >>> 16) & 0xFF] & 0xFF) << 24 ^ (S[(tt >>> 8) & 0xFF] & 0xFF) << 16
                     ^ (S[tt & 0xFF] & 0xFF) << 8 ^ (S[(tt >>> 24) & 0xFF] & 0xFF) ^ (RCON[rconpointer++] & 0xFF) << 24;
            if (kc != 8) for (i = 1, j = 0; i < kc;)
                tk[i++] ^= tk[j++];
            else {
                for (i = 1, j = 0; i < kc / 2;)
                    tk[i++] ^= tk[j++];
                tt = tk[kc / 2 - 1];
                tk[kc / 2] ^= (S[tt & 0xFF] & 0xFF) ^ (S[(tt >>> 8) & 0xFF] & 0xFF) << 8
                              ^ (S[(tt >>> 16) & 0xFF] & 0xFF) << 16 ^ (S[(tt >>> 24) & 0xFF] & 0xFF) << 24;
                for (j = kc / 2, i = j + 1; i < kc;)
                    tk[i++] ^= tk[j++];
            }
            // copy values into round key arrays
            for (j = 0; (j < kc) && (t < roundKeyCount); j++, t++) {
                ke[t / bc][t % bc] = tk[j];
                kd[rounds - (t / bc)][t % bc] = tk[j];
            }
        }
        for (int r = 1; r < rounds; r++)
            // inverse MixColumn where needed
            for (j = 0; j < bc; j++) {
                tt = kd[r][j];
                kd[r][j] = U1[(tt >>> 24) & 0xFF] ^ U2[(tt >>> 16) & 0xFF] ^ U3[(tt >>> 8) & 0xFF] ^ U4[tt & 0xFF];
            }
        // assemble the encryption (ke) and decryption (kd) round keys into
        // one sessionKey object
        Object[] sessionKey = new Object[] { ke, kd };
        if (DEBUG) trace(OUT, "makeKey()");
        return sessionKey;
    }

    /**
     * Encrypt exactly one block of plaintext.
     * 
     * @param in The plaintext.
     * @param inOffset Index of in from which to start considering data.
     * @param sessionKey The session key to use for encryption.
     * @param blockSize The block size in bytes of this Rijndael.
     * @return The ciphertext generated from a plaintext using the session key.
     */
    public static byte[] blockEncrypt(byte[] in, int inOffset, Object sessionKey, int blockSize) {
        if (blockSize == BLOCK_SIZE) return blockEncrypt(in, inOffset, sessionKey);
        if (DEBUG) trace(IN, "blockEncrypt(" + in + ", " + inOffset + ", " + sessionKey + ", " + blockSize + ")");
        Object[] sKey = (Object[]) sessionKey; // extract encryption round keys
        int[][] ke = (int[][]) sKey[0];

        int bc = blockSize / 4;
        int rounds = ke.length - 1;
        int sc = bc == 4 ? 0 : (bc == 6 ? 1 : 2);
        int s1 = SHIFTS[sc][1][0];
        int s2 = SHIFTS[sc][2][0];
        int s3 = SHIFTS[sc][3][0];
        int[] a = new int[bc];
        int[] t = new int[bc]; // temporary work array
        int i;
        byte[] result = new byte[blockSize]; // the resulting ciphertext
        int j = 0, tt;

        for (i = 0; i < bc; i++)
            // plaintext to ints + key
            t[i] = ((in[inOffset++] & 0xFF) << 24 | (in[inOffset++] & 0xFF) << 16 | (in[inOffset++] & 0xFF) << 8 | (in[inOffset++] & 0xFF))
                   ^ ke[0][i];
        for (int r = 1; r < rounds; r++) { // apply round transforms
            for (i = 0; i < bc; i++)
                a[i] = (T1[(t[i] >>> 24) & 0xFF] ^ T2[(t[(i + s1) % bc] >>> 16) & 0xFF]
                        ^ T3[(t[(i + s2) % bc] >>> 8) & 0xFF] ^ T4[t[(i + s3) % bc] & 0xFF])
                       ^ ke[r][i];
            System.arraycopy(a, 0, t, 0, bc);
            if (DEBUG && DEBUGLEVEL > 6) System.out.println("CT" + r + "=" + toString(t));
        }
        for (i = 0; i < bc; i++) { // last round is special
            tt = ke[rounds][i];
            result[j++] = (byte) (S[(t[i] >>> 24) & 0xFF] ^ (tt >>> 24));
            result[j++] = (byte) (S[(t[(i + s1) % bc] >>> 16) & 0xFF] ^ (tt >>> 16));
            result[j++] = (byte) (S[(t[(i + s2) % bc] >>> 8) & 0xFF] ^ (tt >>> 8));
            result[j++] = (byte) (S[t[(i + s3) % bc] & 0xFF] ^ tt);
        }
        if (DEBUG && DEBUGLEVEL > 6) {
            System.out.println("CT=" + toString(result));
            System.out.println();
        }
        if (DEBUG) trace(OUT, "blockEncrypt()");
        return result;
    }

    /**
     * Decrypt exactly one block of ciphertext.
     * 
     * @param in The ciphertext.
     * @param inOffset Index of in from which to start considering data.
     * @param sessionKey The session key to use for decryption.
     * @param blockSize The block size in bytes of this Rijndael.
     * @return The plaintext generated from a ciphertext using the session key.
     */
    public static byte[] blockDecrypt(byte[] in, int inOffset, Object sessionKey, int blockSize) {
        if (blockSize == BLOCK_SIZE) return blockDecrypt(in, inOffset, sessionKey);
        if (DEBUG) trace(IN, "blockDecrypt(" + in + ", " + inOffset + ", " + sessionKey + ", " + blockSize + ")");
        Object[] sKey = (Object[]) sessionKey; // extract decryption round keys
        int[][] kd = (int[][]) sKey[1];

        int bc = blockSize / 4;
        int rounds = kd.length - 1;
        int sc = bc == 4 ? 0 : (bc == 6 ? 1 : 2);
        int s1 = SHIFTS[sc][1][1];
        int s2 = SHIFTS[sc][2][1];
        int s3 = SHIFTS[sc][3][1];
        int[] a = new int[bc];
        int[] t = new int[bc]; // temporary work array
        int i;
        byte[] result = new byte[blockSize]; // the resulting plaintext
        int j = 0, tt;

        for (i = 0; i < bc; i++)
            // ciphertext to ints + key
            t[i] = ((in[inOffset++] & 0xFF) << 24 | (in[inOffset++] & 0xFF) << 16 | (in[inOffset++] & 0xFF) << 8 | (in[inOffset++] & 0xFF))
                   ^ kd[0][i];
        for (int r = 1; r < rounds; r++) { // apply round transforms
            for (i = 0; i < bc; i++)
                a[i] = (T5[(t[i] >>> 24) & 0xFF] ^ T6[(t[(i + s1) % bc] >>> 16) & 0xFF]
                        ^ T7[(t[(i + s2) % bc] >>> 8) & 0xFF] ^ T8[t[(i + s3) % bc] & 0xFF])
                       ^ kd[r][i];
            System.arraycopy(a, 0, t, 0, bc);
            if (DEBUG && DEBUGLEVEL > 6) System.out.println("PT" + r + "=" + toString(t));
        }
        for (i = 0; i < bc; i++) { // last round is special
            tt = kd[rounds][i];
            result[j++] = (byte) (SI[(t[i] >>> 24) & 0xFF] ^ (tt >>> 24));
            result[j++] = (byte) (SI[(t[(i + s1) % bc] >>> 16) & 0xFF] ^ (tt >>> 16));
            result[j++] = (byte) (SI[(t[(i + s2) % bc] >>> 8) & 0xFF] ^ (tt >>> 8));
            result[j++] = (byte) (SI[t[(i + s3) % bc] & 0xFF] ^ tt);
        }
        if (DEBUG && DEBUGLEVEL > 6) {
            System.out.println("PT=" + toString(result));
            System.out.println();
        }
        if (DEBUG) trace(OUT, "blockDecrypt()");
        return result;
    }

    /** A basic symmetric encryption/decryption test for a given key size. */
    private static boolean selfTest(int keysize) {
        if (DEBUG) trace(IN, "self_test(" + keysize + ")");
        boolean ok = false;
        try {
            byte[] kb = new byte[keysize];
            byte[] pt = new byte[BLOCK_SIZE];
            int i;

            for (i = 0; i < keysize; i++)
                kb[i] = (byte) i;
            for (i = 0; i < BLOCK_SIZE; i++)
                pt[i] = (byte) i;

            if (DEBUG && DEBUGLEVEL > 6) {
                System.out.println("==========");
                System.out.println();
                System.out.println("KEYSIZE=" + (8 * keysize));
                System.out.println("KEY=" + toString(kb));
                System.out.println();
            }
            Object key = makeKey(kb, BLOCK_SIZE);

            if (DEBUG && DEBUGLEVEL > 6) {
                System.out.println("Intermediate Ciphertext Values (Encryption)");
                System.out.println();
                System.out.println("PT=" + toString(pt));
            }
            byte[] ct = blockEncrypt(pt, 0, key, BLOCK_SIZE);

            if (DEBUG && DEBUGLEVEL > 6) {
                System.out.println("Intermediate Plaintext Values (Decryption)");
                System.out.println();
                System.out.println("CT=" + toString(ct));
            }
            byte[] cpt = blockDecrypt(ct, 0, key, BLOCK_SIZE);

            ok = areEqual(pt, cpt);
            if (!ok) throw new RuntimeException("Symmetric operation failed");
        } catch (Exception x) {
            if (DEBUG && DEBUGLEVEL > 0) {
                debug("Exception encountered during self-test: " + x.getMessage());
                x.printStackTrace();
            }
        }
        if (DEBUG && DEBUGLEVEL > 0) debug("Self-test OK? " + ok);
        if (DEBUG) trace(OUT, "self_test()");
        return ok;
    }

    /**
     * Return The number of rounds for a given Rijndael's key and block sizes.
     * 
     * @param keySize The size of the user key material in bytes.
     * @param blockSize The desired block size in bytes.
     * @return The number of rounds for a given Rijndael's key and block sizes.
     */
    public static int getRounds(int keySize, int blockSize) {
        switch (keySize) {
            case 16:
                return blockSize == 16 ? 10 : (blockSize == 24 ? 12 : 14);
            case 24:
                return blockSize != 32 ? 12 : 14;
            default: // 32 bytes = 256 bits
                return 14;
        }
    }

    // utility static methods (from cryptix.util.core ArrayUtil and Hex classes)
    // ...........................................................................

    /**
     * Compares two byte arrays for equality.
     * 
     * @return true if the arrays have identical contents
     */
    private static boolean areEqual(byte[] a, byte[] b) {
        int aLength = a.length;
        if (aLength != b.length) return false;
        for (int i = 0; i < aLength; i++)
            if (a[i] != b[i]) return false;
        return true;
    }

    /**
     * Returns a string of 2 hexadecimal digits (most significant digit first) corresponding to the lowest 8 bits of
     * <i>n</i>.
     */
    private static String byteToString(int n) {
        char[] buf = { HEX_DIGITS[(n >>> 4) & 0x0F], HEX_DIGITS[n & 0x0F] };
        return new String(buf);
    }

    /**
     * Returns a string of 8 hexadecimal digits (most significant digit first) corresponding to the integer <i>n</i>,
     * which is treated as unsigned.
     */
    private static String intToString(int n) {
        char[] buf = new char[8];
        for (int i = 7; i >= 0; i--) {
            buf[i] = HEX_DIGITS[n & 0x0F];
            n >>>= 4;
        }
        return new String(buf);
    }

    /**
     * Returns a string of hexadecimal digits from a byte array. Each byte is converted to 2 hex symbols.
     */
    private static String toString(byte[] ba) {
        int length = ba.length;
        char[] buf = new char[length * 2];
        for (int i = 0, j = 0, k; i < length;) {
            k = ba[i++];
            buf[j++] = HEX_DIGITS[(k >>> 4) & 0x0F];
            buf[j++] = HEX_DIGITS[k & 0x0F];
        }
        return new String(buf);
    }

    /**
     * Returns a string of hexadecimal digits from an integer array. Each int is converted to 4 hex symbols.
     */
    private static String toString(int[] ia) {
        int length = ia.length;
        char[] buf = new char[length * 8];
        for (int i = 0, j = 0, k; i < length; i++) {
            k = ia[i];
            buf[j++] = HEX_DIGITS[(k >>> 28) & 0x0F];
            buf[j++] = HEX_DIGITS[(k >>> 24) & 0x0F];
            buf[j++] = HEX_DIGITS[(k >>> 20) & 0x0F];
            buf[j++] = HEX_DIGITS[(k >>> 16) & 0x0F];
            buf[j++] = HEX_DIGITS[(k >>> 12) & 0x0F];
            buf[j++] = HEX_DIGITS[(k >>> 8) & 0x0F];
            buf[j++] = HEX_DIGITS[(k >>> 4) & 0x0F];
            buf[j++] = HEX_DIGITS[k & 0x0F];
        }
        return new String(buf);
    }

    // main(): use to generate the Intermediate Values KAT
    // ...........................................................................

    public static void main(String[] args) {
        selfTest(16);
        selfTest(24);
        selfTest(32);
    }
}
