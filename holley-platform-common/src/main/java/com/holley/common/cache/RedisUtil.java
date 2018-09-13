package com.holley.common.cache;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.holley.common.util.StringUtil;

public abstract class RedisUtil {

    protected static Logger  logger         = Logger.getLogger(RedisUtil.class);

    private static String    ADDR_ARRAY     = "localhost";
    private static int       PORT           = 6379;
    private static int       MAX_ACTIVE     = 50;
    private static int       MAX_IDLE       = 5;
    private static int       MAX_WAIT       = 10000;                            // 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int       TIMEOUT        = 2000;                             // 超时时间
    private static boolean   TEST_ON_BORROW = true;                             // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static JedisPool jedisPool      = null;
    private static String    PASS_WORD      = "holley316";
    /**
     * redis过期时间,以秒为单位
     */
    public final static int  EXRP_1M        = 60;                               // 3分钟过期
    public final static int  EXRP_3M        = 60 * 3;                           // 3分钟过期
    public final static int  EXRP_30M       = 30 * 60;                          // 30分钟过期
    public final static int  EXRP_HOUR      = 60 * 60;                          // 一小时
    public final static int  EXRP_DAY       = 60 * 60 * 24;                     // 一天
    public final static int  EXRP_MONTH     = 60 * 60 * 24 * 30;                // 一个月

    /**
     * 初始化Redis连接池
     */
    private static void initialPool() {
        InputStream is = null;
        try {
            is = RedisUtil.class.getClassLoader().getResourceAsStream("redis.properties");
            Properties prop = new Properties();
            prop.load(is);

            ADDR_ARRAY = prop.getProperty("server");
            PORT = Integer.valueOf(prop.getProperty("port"));
            MAX_ACTIVE = Integer.valueOf(prop.getProperty("max_active"));
            MAX_IDLE = Integer.valueOf(prop.getProperty("max_idle"));
            MAX_WAIT = Integer.valueOf(prop.getProperty("max_wait"));
            TIMEOUT = Integer.valueOf(prop.getProperty("timeout"));
            TEST_ON_BORROW = Boolean.valueOf(prop.getProperty("test_on_borrow"));
            PASS_WORD = prop.getProperty("password");
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR_ARRAY, PORT, TIMEOUT, PASS_WORD);
        } catch (Exception e) {
            logger.error("First create JedisPool error : " + e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 在多线程环境同步初始化
     */
    private static synchronized void poolInit() {
        if (jedisPool == null) {
            initialPool();
        }
    }

    /**
     * 查询key的过期时间
     * 
     * @param key
     * @return 0已经过期
     */
    public static Long ttl(String key) {
        Jedis jedis = null;
        Long ttl = null;
        try {
            jedis = getJedis();
            ttl = jedis.ttl(key);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }

        return ttl > 0 ? ttl : 0;
    }

    /**
     * 同步获取Jedis实例
     * 
     * @return Jedis
     */
    public synchronized static Jedis getJedis() {
        if (jedisPool == null) {
            poolInit();
        }
        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
            logger.error("Get jedis error : " + e);
        }
        // finally {
        // returnResource(jedis);
        // }
        // System.out.println("activeNum=======================" + jedisPool.getNumActive());
        // System.out.println("waiter=======================" + jedisPool.getNumWaiters());
        // System.out.println("idle=======================" + jedisPool.getNumIdle());
        return jedis;
    }

    /**
     * 释放jedis资源
     * 
     * @param jedis
     */
    public static void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
            // jedisPool.returnResource(jedis);
            // System.out.println("activeNum=======================" + jedisPool.getNumActive());
            // System.out.println("waiter=======================" + jedisPool.getNumWaiters());
            // System.out.println("idle=======================" + jedisPool.getNumIdle());
        }
    }

    /**
     * 设置 String
     * 
     * @param key
     * @param value
     */
    public static boolean setString(String key, String value) {
        Jedis jedis = null;
        try {
            value = StringUtil.isEmpty(value) ? "" : value;
            jedis = getJedis();
            jedis.set(key, value);
            return true;
        } catch (Exception e) {
            logger.error("Set key error : " + e);
            jedisPool.returnBrokenResource(jedis);
            return false;
        } finally {
            if (jedis != null) {
                jedisPool.returnResource(jedis);
            }
        }

    }

    /**
     * 设置 过期时间的String
     * 
     * @param key
     * @param value
     * @param timeout 以秒为单位
     */
    public static void setString(String key, String value, int timeout) {
        Jedis jedis = null;
        try {
            value = StringUtil.isEmpty(value) ? "" : value;
            jedis = getJedis();
            jedis.setex(key, timeout, value);

        } catch (Exception e) {
            logger.error("Set keyex error : " + e);
            jedisPool.returnBrokenResource(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }

    }

    /**
     * 设置 byte[]
     * 
     * @param key
     * @param value
     */
    public static void setByte(byte[] key, byte[] value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
        } catch (Exception e) {
            logger.error("Set keyex error : " + e);
            jedisPool.returnBrokenResource(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }

    }

    /**
     * 设置 过期时间的String
     * 
     * @param key
     * @param value
     * @param timeout 以秒为单位
     */
    public static void setByteEx(byte[] key, byte[] value, int timeout) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.setex(key, timeout, value);
        } catch (Exception e) {
            logger.error("Set keyex error : " + e);
            jedisPool.returnBrokenResource(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }

    }

    /**
     * 获取String值
     * 
     * @param key
     * @return value
     */
    public static String getString(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = getJedis();
            if (jedis == null || !jedis.exists(key)) {
                return null;
            }
            value = jedis.get(key);
        } catch (Exception e) {
            logger.error("Set keyex error : " + e);
            jedisPool.returnBrokenResource(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return value;
    }

    /**
     * 获取String值
     * 
     * @param key
     * @return value
     */
    public static byte[] getByte(byte[] key) {
        Jedis jedis = null;
        byte[] value = null;
        try {
            jedis = getJedis();
            if (jedis == null || !jedis.exists(key)) {
                return null;
            }
            value = jedis.get(key);
        } catch (Exception e) {
            logger.error("Set keyex error : " + e);
            jedisPool.returnBrokenResource(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return value;
    }

    public static boolean delKey(String key) {
        Jedis jedis = null;
        Long dels = null;
        try {
            jedis = getJedis();
            dels = jedis.del(key);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return dels != null;
    }

    public static boolean delKey(byte[] key) {
        Jedis jedis = null;
        Long dels = null;
        try {
            jedis = getJedis();
            dels = jedis.del(key);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return dels != null;
    }

    /**
     * 存储map
     * 
     * @param key
     * @param map
     */
    public static void setHash(String key, Map<String, String> map) {
        Jedis jedis = null;
        if (map != null) {
            try {
                jedis = getJedis();
                jedis.hmset(key, map);
            } catch (Exception e) {
                jedisPool.returnBrokenResource(jedis);
            } finally {
                jedisPool.returnResource(jedis);
            }

        }
    }

    public static void setHashByte(String key, Map<byte[], byte[]> map) {
        Jedis jedis = null;
        if (map != null) {
            try {
                jedis = getJedis();
                jedis.hmset(key.getBytes(), map);
            } catch (Exception e) {
                jedisPool.returnBrokenResource(jedis);
            } finally {
                jedisPool.returnResource(jedis);
            }

        }
    }

    public static void hdel(String key, byte[]... fields) {
        Jedis jedis = null;
        if (key != null) {
            try {
                jedis = getJedis();
                jedis.hdel(key.getBytes(), fields);
            } catch (Exception e) {
                jedisPool.returnBrokenResource(jedis);
            } finally {
                jedisPool.returnResource(jedis);
            }

        }
    }

    public static Map<byte[], byte[]> getHashByte(String key) {
        Map<byte[], byte[]> value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            value = jedis.hgetAll(key.getBytes());
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }

        return value;
    }

    /**
     * 获取hashmap对象
     * 
     * @param key
     * @return
     */
    public static Map<String, String> getHashAll(String key) {
        Map<String, String> value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            value = jedis.hgetAll(key);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }

        return value;
    }

    /**
     * 通过传入的多个key参数取得value的list
     * 
     * @param key
     * @param fields
     * @return
     */
    public static List<String> hmget(String key, String... fields) {
        Jedis jedis = null;
        List<String> value = null;
        try {
            jedis = getJedis();
            value = jedis.hmget(key, fields);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }

        return value;
    }

    /**
     * 设置key的过期时间，单位秒
     * 
     * @param key
     * @param timeout
     */
    public static void expire(String key, int timeout) {
        Jedis jedis = null;

        try {
            jedis = getJedis();
            jedis.expire(key, timeout);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }

    }

}
