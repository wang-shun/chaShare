package com.holley.common.i18n;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * trubing里面的一些代码
 */
public class CharsetMap {

    /**
     * 默然的字符集
     */
    public static final String             DEFAULT_CHARSET  = "utf-8";

    /** The name for charset mapper resources. */
    public static final String             CHARSET_RESOURCE = "charset.properties";

    /** Priorities of available mappers. */
    private static final int               MAP_CACHE        = 0;
    private static final int               MAP_PROG         = 1;
    private static final int               MAP_HOME         = 2;
    private static final int               MAP_SYS          = 3;
    private static final int               MAP_JAR          = 4;
    private static final int               MAP_COM          = 5;

    /** 可用的charset mappers数组. */
    @SuppressWarnings("unchecked")
    private Map[]                          mappers          = new Map[6];

    /** 各个语言的通用的数据 */
    private static HashMap<String, String> charsetMapper    = new HashMap<String, String>();

    static {
        charsetMapper.put("ar", "ISO-8859-6");
        charsetMapper.put("be", "ISO-8859-5");
        charsetMapper.put("bg", "ISO-8859-5");
        charsetMapper.put("ca", "ISO-8859-1");
        charsetMapper.put("cs", "ISO-8859-2");
        charsetMapper.put("da", "ISO-8859-1");
        charsetMapper.put("de", "ISO-8859-1");
        charsetMapper.put("el", "ISO-8859-7");
        charsetMapper.put("en", "ISO-8859-1");
        charsetMapper.put("es", "ISO-8859-1");
        charsetMapper.put("et", "ISO-8859-1");
        charsetMapper.put("fi", "ISO-8859-1");
        charsetMapper.put("fr", "ISO-8859-1");
        charsetMapper.put("hr", "ISO-8859-2");
        charsetMapper.put("hu", "ISO-8859-2");
        charsetMapper.put("is", "ISO-8859-1");
        charsetMapper.put("it", "ISO-8859-1");
        charsetMapper.put("iw", "ISO-8859-8");
        charsetMapper.put("ja", "Shift_JIS");
        charsetMapper.put("ko", "EUC-KR");
        charsetMapper.put("lt", "ISO-8859-2");
        charsetMapper.put("lv", "ISO-8859-2");
        charsetMapper.put("mk", "ISO-8859-5");
        charsetMapper.put("nl", "ISO-8859-1");
        charsetMapper.put("no", "ISO-8859-1");
        charsetMapper.put("pl", "ISO-8859-2");
        charsetMapper.put("pt", "ISO-8859-1");
        charsetMapper.put("ro", "ISO-8859-2");
        charsetMapper.put("ru", "ISO-8859-5");
        charsetMapper.put("sh", "ISO-8859-5");
        charsetMapper.put("sk", "ISO-8859-2");
        charsetMapper.put("sl", "ISO-8859-2");
        charsetMapper.put("sq", "ISO-8859-2");
        charsetMapper.put("sr", "ISO-8859-5");
        charsetMapper.put("sv", "ISO-8859-1");
        charsetMapper.put("tr", "ISO-8859-9");
        charsetMapper.put("uk", "ISO-8859-5");
        charsetMapper.put("zh", "GB18030");
        charsetMapper.put("zh_TW", "Big5");
    }

    /**
     * Constructs a new charset map with default mappers.
     */
    @SuppressWarnings("unchecked")
    public CharsetMap() {
        String path;

        try {
            // Check whether the user directory contains mappings.
            path = System.getProperty("user.home");

            if (path != null) {
                path = path + File.separator + CHARSET_RESOURCE;
                mappers[MAP_HOME] = loadPath(path);
            }
        } catch (Exception x) {
        }

        try {
            // Check whether the system directory contains mappings.
            path = System.getProperty("java.home") + File.separator + "lib" + File.separator + CHARSET_RESOURCE;
            mappers[MAP_SYS] = loadPath(path);
        } catch (Exception x) {
        }

        // Check whether the current class jar contains mappings.
        mappers[MAP_JAR] = loadResource("/META-INF/" + CHARSET_RESOURCE);

        // Set the common mapper to have the lowest priority.
        mappers[MAP_COM] = charsetMapper;

        // Set the cache mapper to have the highest priority.
        mappers[MAP_CACHE] = new Hashtable();
    }

    /**
     * Contructs a charset map from properties.
     * 
     * @param props charset mapping propeties.
     */
    @SuppressWarnings("unchecked")
    public CharsetMap(Properties props) {
        this();
        mappers[MAP_PROG] = new HashMap(props);
    }

    /**
     * Contructs a charset map read from a stream.
     * 
     * @param input an input stream.
     * @throws IOException for an incorrect stream.
     */
    public CharsetMap(InputStream input) throws IOException {
        this();
        mappers[MAP_PROG] = loadStream(input);
    }

    /**
     * Contructs a charset map read from a property file.
     * 
     * @param file a property file.
     * @throws IOException for an incorrect property file.
     */
    public CharsetMap(File file) throws IOException {
        this();
        mappers[MAP_PROG] = loadFile(file);
    }

    /**
     * Contructs a charset map read from a property file path.
     * 
     * @param path a property file path.
     * @throws IOException for an incorrect property file.
     */
    public CharsetMap(String path) throws IOException {
        this();
        mappers[MAP_PROG] = loadPath(path);
    }

    /**
     * 从流加载map
     * 
     * @param input
     * @return
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    protected static Map<String, String> loadStream(InputStream input) throws IOException {
        Properties props = new Properties();

        props.load(input);
        return new HashMap(props);
    }

    /**
     * 从文件加载
     * 
     * @param file a file.
     * @return the mappings.
     * @throws IOException for an incorrect file.
     */
    protected static Map<String, String> loadFile(File file) throws IOException {
        return loadStream(new FileInputStream(file));
    }

    /**
     * 从文件路径加载
     * 
     * @param path a file path.
     * @return the mappings.
     * @throws IOException for an incorrect file.
     */
    protected static Map<String, String> loadPath(String path) throws IOException {
        return loadFile(new File(path));
    }

    /**
     * 从resource加载.
     * 
     * @param name a resource name.
     * @return the mappings.
     */
    protected static Map<String, String> loadResource(String name) {
        InputStream input = CharsetMap.class.getResourceAsStream(name);
        if (input != null) {
            try {
                return loadStream(input);
            } catch (IOException x) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Sets a locale-charset mapping.
     * 
     * @param key the key for the charset.
     * @param charset the corresponding charset.
     */
    @SuppressWarnings("unchecked")
    public synchronized void setCharSet(String key, String charset) {
        HashMap mapper = (HashMap) mappers[MAP_PROG];

        mapper = (mapper != null) ? (HashMap) mapper.clone() : new HashMap();
        mapper.put(key, charset);
        mappers[MAP_PROG] = mapper;
        mappers[MAP_CACHE].clear();
    }

    /**
     * Gets the charset for a locale. First a locale specific charset is searched for, then a country specific one and
     * lastly a language specific one. If none is found, the default charset is returned.
     * 
     * @param locale the locale.
     * @return the charset.
     */
    @SuppressWarnings("unchecked")
    public String getCharSet(Locale locale) {
        // Check the cache first.
        String key = locale.toString();

        if (key.length() == 0) {
            key = "__" + locale.getVariant();

            if (key.length() == 2) {
                return DEFAULT_CHARSET;
            }
        }

        String charset = searchCharSet(key);

        if (charset.length() == 0) {
            // Not found, perform a full search and update the cache.
            String[] items = new String[3];

            items[2] = locale.getVariant();
            items[1] = locale.getCountry();
            items[0] = locale.getLanguage();
            charset = searchCharSet(items);

            if (charset.length() == 0) {
                charset = DEFAULT_CHARSET;
            }

            mappers[MAP_CACHE].put(key, charset);
        }

        return charset;
    }

    /**
     * Gets the charset for a locale with a variant. The search is performed in the following order:
     * "lang"_"country"_"variant"="charset", _"counry"_"variant"="charset", "lang"__"variant"="charset",
     * __"variant"="charset", "lang"_"country"="charset", _"country"="charset", "lang"="charset". If nothing of the
     * above is found, the default charset is returned.
     * 
     * @param locale the locale.
     * @param variant a variant field.
     * @return the charset.
     */
    @SuppressWarnings("unchecked")
    public String getCharSet(Locale locale, String variant) {
        // Check the cache first.
        if ((variant != null) && (variant.length() > 0)) {
            String key = locale.toString();

            if (key.length() == 0) {
                key = "__" + locale.getVariant();

                if (key.length() > 2) {
                    key += ('_' + variant);
                } else {
                    key += variant;
                }
            } else if (locale.getCountry().length() == 0) {
                key += ("__" + variant);
            } else {
                key += ('_' + variant);
            }

            String charset = searchCharSet(key);

            if (charset.length() == 0) {
                // Not found, perform a full search and update the cache.
                String[] items = new String[4];

                items[3] = variant;
                items[2] = locale.getVariant();
                items[1] = locale.getCountry();
                items[0] = locale.getLanguage();
                charset = searchCharSet(items);

                if (charset.length() == 0) {
                    charset = DEFAULT_CHARSET;
                }

                mappers[MAP_CACHE].put(key, charset);
            }

            return charset;
        } else {
            return getCharSet(locale);
        }
    }

    /**
     * Gets the charset for a specified key.
     * 
     * @param key the key for the charset.
     * @return the found charset or the default one.
     */
    public String getCharSet(String key) {
        String charset = searchCharSet(key);

        return (charset.length() > 0) ? charset : DEFAULT_CHARSET;
    }

    /**
     * Gets the charset for a specified key.
     * 
     * @param key the key for the charset.
     * @param def the default charset if none is found.
     * @return the found charset or the given default.
     */
    public String getCharSet(String key, String def) {
        String charset = searchCharSet(key);

        return (charset.length() > 0) ? charset : def;
    }

    /**
     * Searches for a charset for a specified locale.
     * 
     * @param items an array of locale items.
     * @return the found charset or an empty string.
     */
    private String searchCharSet(String[] items) {
        String charset;
        StringBuffer sb = new StringBuffer();

        for (int i = items.length; i > 0; i--) {
            charset = searchCharSet(items, sb, i);

            if (charset.length() > 0) {
                return charset;
            }

            sb.setLength(0);
        }

        return "";
    }

    /**
     * Searches recursively for a charset for a specified locale.
     * 
     * @param items an array of locale items.
     * @param base a buffer of base items.
     * @param count the number of items to go through.
     * @return the found charset or an empty string.
     */
    private String searchCharSet(String[] items, StringBuffer base, int count) {
        if ((--count >= 0) && (items[count] != null) && (items[count].length() > 0)) {
            String charset;

            base.insert(0, items[count]);

            int length = base.length();

            for (int i = count; i > 0; i--) {
                if ((i == count) || (i <= 1)) {
                    base.insert(0, '_');
                    length++;
                }

                charset = searchCharSet(items, base, i);

                if (charset.length() > 0) {
                    return charset;
                }

                base.delete(0, base.length() - length);
            }

            return searchCharSet(base.toString());
        } else {
            return "";
        }
    }

    /**
     * Searches for a charset for a specified key.
     * 
     * @param key the key for the charset.
     * @return the found charset or an empty string.
     */
    @SuppressWarnings("unchecked")
    private String searchCharSet(String key) {
        if ((key != null) && (key.length() > 0)) {
            // Go through mappers.
            Map mapper;
            String charset;

            for (int i = 0; i < mappers.length; i++) {
                mapper = mappers[i];

                if (mapper != null) {
                    charset = (String) mapper.get(key);

                    if (charset != null) {
                        // Update the cache.
                        if (i > MAP_CACHE) {
                            mappers[MAP_CACHE].put(key, charset);
                        }

                        return charset;
                    }
                }
            }

            // Not found, add an empty string to the cache.
            mappers[MAP_CACHE].put(key, "");
        }

        return "";
    }

    /**
     * Sets a common locale-charset mapping.
     * 
     * @param key the key for the charset.
     * @param charset the corresponding charset.
     */
    @SuppressWarnings("unchecked")
    protected synchronized void setCommonCharSet(String key, String charset) {
        HashMap mapper = (HashMap) ((HashMap) mappers[MAP_COM]).clone();

        mapper.put(key, charset);
        mappers[MAP_COM] = mapper;
        mappers[MAP_CACHE].clear();
    }
}
