package com.holley.charging.share.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.util.Properties;

import org.springframework.util.DefaultPropertiesPersister;

import com.holley.common.security.RijndaelUtil;

public class PropertiesPersist extends DefaultPropertiesPersister {

    public void load(Properties props, InputStream is) throws IOException {

        Properties properties = new Properties();
        properties.load(is);

        if ((properties.get("jdbc.password") != null)) {

            String password = "";
            try {
                password = RijndaelUtil.decodePassword(properties.getProperty("jdbc.password"));
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
            properties.setProperty("jdbc.password", password);
        }
        if ((properties.get("jdbc.username") != null)) {

            String user = "";
            try {
                user = RijndaelUtil.decodePassword(properties.getProperty("jdbc.username"));
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
            properties.setProperty("jdbc.username", user);
        }
        OutputStream outputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            properties.store(outputStream, "");
            is = outStream2InputStream(outputStream);
            super.load(props, is);
        } catch (IOException e) {
            throw e;
        } finally {
            outputStream.close();
        }
    }

    private InputStream outStream2InputStream(OutputStream out) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos = (ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(bos.toByteArray());
        return swapStream;
    }
}
