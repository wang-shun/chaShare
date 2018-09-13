package com.holley.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    /**
     * Description of the Method
     * 
     *@param zipData Description of Parameter
     *@param entryName Description of Parameter
     *@return Description of the Returned Value
     */
    // private static String ENCODING = "UTF8";
    static public byte[] unZipEntry(byte[] zipData, String entryName) {
        try {
            // the zip entry as it will appear in the zip file

            // wrap streams to get desired functionality
            ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(zipData));

            // find the zip entry corresponding to the requested class
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            if (entryName != null) {
                while ((zipEntry != null) && !(zipEntry.getName().equals(entryName))) {
                    zipEntry = zipInputStream.getNextEntry();
                }
            }
            if (zipEntry == null) {
                // the requested class was not found
                return null;
            }

            // read from the stream until the end of the entry, loading the
            // class bytes into the buffer
            int totalBytesRead = 0;
            int bytesReadThisTime = 0;
            byte[] classByteBuffer = new byte[4096];
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            while (bytesReadThisTime != -1) {
                bytesReadThisTime = zipInputStream.read(classByteBuffer, 0, classByteBuffer.length);
                if (bytesReadThisTime != -1) {
                    bos.write(classByteBuffer, 0, bytesReadThisTime);
                    totalBytesRead += bytesReadThisTime;
                }

            }
            zipInputStream.closeEntry();
            zipInputStream.close();

            byte[] classBytes = bos.toByteArray();

            bos.close();

            return classBytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Description of the Method
     * 
     *@param zipData Description of Parameter
     *@return Description of the Returned Value
     */
    static public byte[] unZipData(byte[] zipData) {
        return unZipEntry(zipData, (String) null);
    }

    /**
     * Description of the Method
     * 
     *@param data Description of Parameter
     *@return Description of the Returned Value
     */
    static public byte[] zipData(byte[] data) {
        try {
            // buffer do zip
            ByteArrayOutputStream f = new ByteArrayOutputStream();
            ZipOutputStream zout = new ZipOutputStream(f);

            zout.putNextEntry(new ZipEntry("data.dat"));
            zout.write(data);
            zout.close();

            byte[] zipdatax = f.toByteArray();

            f.close();
            return zipdatax;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static public String zipString(String s) {
        byte[] zip = null;
        try {
            zip = zipData(s.getBytes("UTF8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StringUtil.encodeBase64(zip);
    }

    static public String unZipString(String s) {
        try {
            byte[] bs = StringUtil.decodeBase64(s);
            byte[] unzip = unZipData(bs);
            return new String(unzip, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
     * static public void main(String [] args){ try { FileInputStream f = new FileInputStream("c:/winzip.log"); byte []
     * bs= new byte [f.available()]; f.read(bs); f.close(); byte [] zip=zipData(bs); byte [] unzip = unZipData(zip);
     * System.out.println("size="+bs.length + "  afterzip="+zip.length +" after unzip="+ unzip.length); String s= new
     * String(unzip,"GBK"); s= zipString(s); System.out.println(unZipString(s)); System.out.println("size="+s.length());
     * } catch(Exception e){ e.printStackTrace(); } }
     */
}
