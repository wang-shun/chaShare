package com.holley.common.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertiesUtil {

    public final static int BY_PROPERTIES             = 1;
    public final static int BY_RESOURCEBUNDLE         = 2;
    public final static int BY_PROPERTYRESOURCEBUNDLE = 3;
    public final static int BY_CLASS                  = 4;
    public final static int BY_CLASSLOADER            = 5;
    public final static int BY_SYSTEM_CLASSLOADER     = 6;

    public final static InputStream getInputStream(final String name, final int type) throws IOException {
        InputStream in = null;
        if (type == BY_PROPERTIES) {
            in = new BufferedInputStream(new FileInputStream(name));
            assert (in != null);
        } else if (type == BY_PROPERTYRESOURCEBUNDLE) {
            in = new BufferedInputStream(new FileInputStream(name));
            assert (in != null);
        } else if (type == BY_CLASS) {
            assert (PropertiesUtil.class.equals(new PropertiesUtil().getClass()));
            in = PropertiesUtil.class.getResourceAsStream(name);
            assert (in != null);
        } else if (type == BY_CLASSLOADER) {
            assert (PropertiesUtil.class.getClassLoader().equals(new PropertiesUtil().getClass().getClassLoader()));
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream(name);
            assert (in != null);
        } else if (type == BY_SYSTEM_CLASSLOADER) {
            in = ClassLoader.getSystemResourceAsStream(name);
            assert (in != null);
        }
        return in;

    }

    public final static void closeInputStream(InputStream in) throws IOException {

        if (in != null) {
            in.close();
        }
    }

    public final static Properties loadProperties(final String name, final int type) throws IOException {
        Properties p = new Properties();
        InputStream in = null;
        if (type == BY_PROPERTIES) {
            in = new BufferedInputStream(new FileInputStream(name));
            assert (in != null);
            p.load(in);
        } else if (type == BY_RESOURCEBUNDLE) {
            ResourceBundle rb = ResourceBundle.getBundle(name, Locale.getDefault());
            assert (rb != null);
            p = new ResourceBundleAdapter(rb);
        } else if (type == BY_PROPERTYRESOURCEBUNDLE) {
            in = new BufferedInputStream(new FileInputStream(name));
            assert (in != null);
            ResourceBundle rb = new PropertyResourceBundle(in);
            p = new ResourceBundleAdapter(rb);
        } else if (type == BY_CLASS) {
            assert (PropertiesUtil.class.equals(new PropertiesUtil().getClass()));
            in = PropertiesUtil.class.getResourceAsStream(name);
            assert (in != null);
            p.load(in);
        } else if (type == BY_CLASSLOADER) {
            assert (PropertiesUtil.class.getClassLoader().equals(new PropertiesUtil().getClass().getClassLoader()));
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream(name);
            assert (in != null);
            p.load(in);
        } else if (type == BY_SYSTEM_CLASSLOADER) {
            in = ClassLoader.getSystemResourceAsStream(name);
            assert (in != null);
            p.load(in);
        }

        if (in != null) {
            in.close();
        }
        return p;

    }

    public final static Properties loadFromXML(final String name, final int type) throws IOException {
        Properties p = new Properties();
        InputStream in = null;
        if (type == BY_PROPERTIES) {
            in = new BufferedInputStream(new FileInputStream(name));
            assert (in != null);
            p.loadFromXML(in);
        } else if (type == BY_CLASS) {
            assert (PropertiesUtil.class.equals(new PropertiesUtil().getClass()));
            in = PropertiesUtil.class.getResourceAsStream(name);
            assert (in != null);
            p.loadFromXML(in);
        } else if (type == BY_CLASSLOADER) {
            assert (PropertiesUtil.class.getClassLoader().equals(new PropertiesUtil().getClass().getClassLoader()));
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream(name);
            assert (in != null);
            p.loadFromXML(in);
        } else if (type == BY_SYSTEM_CLASSLOADER) {
            in = ClassLoader.getSystemResourceAsStream(name);
            assert (in != null);
            p.loadFromXML(in);
        }

        if (in != null) {
            in.close();
        }
        return p;

    }

    @SuppressWarnings("serial")
    public static class ResourceBundleAdapter extends Properties {

        @SuppressWarnings("rawtypes")
        public ResourceBundleAdapter(ResourceBundle rb) {
            assert (rb instanceof java.util.PropertyResourceBundle);
            this.rb = rb;
            java.util.Enumeration e = rb.getKeys();
            while (e.hasMoreElements()) {
                Object o = e.nextElement();
                this.put(o, rb.getObject((String) o));
            }
        }

        private ResourceBundle rb = null;

        public ResourceBundle getBundle(String baseName) {
            return ResourceBundle.getBundle(baseName);
        }

        public ResourceBundle getBundle(String baseName, Locale locale) {
            return ResourceBundle.getBundle(baseName, locale);
        }

        public ResourceBundle getBundle(String baseName, Locale locale, ClassLoader loader) {
            return ResourceBundle.getBundle(baseName, locale, loader);
        }

        @SuppressWarnings("rawtypes")
        public Enumeration getKeys() {
            return rb.getKeys();
        }

        public Locale getLocale() {
            return rb.getLocale();
        }

        public Object getObject(String key) {
            return rb.getObject(key);
        }

        public String getString(String key) {
            return rb.getString(key);
        }

        public String[] getStringArray(String key) {
            return rb.getStringArray(key);
        }

        protected Object handleGetObject(String key) {
            return ((PropertyResourceBundle) rb).handleGetObject(key);
        }

    }

    public static void main(String[] args) throws IOException {
        String key = "jdbc.driverClassName";
        String name = null;
        Properties p = new Properties();

        // name = "C:\\IDEAP\\Properties4Methods\\src\\com\\kindani\\test\\LocalStrings.properties";
        // p = JProperties.loadProperties(name, JProperties.BY_PROPERTIES);
        // System.out.println(p.getProperty(key));
        //
        // name = "com.kindani.test.LocalStrings";
        // p = JProperties.loadProperties(name, JProperties.BY_RESOURCEBUNDLE);
        // System.out.println(p.getProperty(key));
        // System.out.println(((JProperties.ResourceBundleAdapter) p).getString(key));

        URL url = PropertiesUtil.class.getClassLoader().getResource("");
        name = url.toString().substring(6, (url.toString().indexOf("classes")));
        name += "config/cip.properties";
        p = PropertiesUtil.loadProperties(name, PropertiesUtil.BY_PROPERTYRESOURCEBUNDLE);
        System.out.println(p.getProperty(key));
        System.out.println(((PropertiesUtil.ResourceBundleAdapter) p).getString(key));
        //
        // p = JProperties.loadProperties(name, JProperties.BY_SYSTEM_CLASSLOADER);
        // System.out.println(p.getProperty(key));
        //
        // name = "\\com\\kindani\\test\\LocalStrings.properties";
        // p = JProperties.loadProperties(name, JProperties.BY_CLASSLOADER);
        // System.out.println(p.getProperty(key));

    }
}
