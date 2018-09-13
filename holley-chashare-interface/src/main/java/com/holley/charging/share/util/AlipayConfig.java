package com.holley.charging.share.util;

import com.holley.charging.model.def.ChargingConfig;

public class AlipayConfig {

    private static String domainUrl         = ChargingConfig.getDomainUrl();
    // static {
    // InputStream inStream = HttpRequestUtil.class.getClassLoader().getResourceAsStream("openActive.properties");
    // Properties prop = new Properties();
    // try {
    // prop.load(inStream);
    // domainUrl = prop.getProperty("domainUrl");
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    //
    // }
    // 沙箱appid
    // public static String APPID = "2016091200493323";
    // 商户appid
    // public static String APPID = "2017072607907708";
    // 北京商户appid
    public static String  APPID             = "2018010501616416";

    // 私钥 pkcs8格式的
    // public static String RSA_PRIVATE_KEY =
    // "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC3uMci1YOJz10Xw/EWB9Uie1990YPNkbKfBdC0rPYy2U0Dvi/SIALr0jHD5SOfH+t7kqkdOoQ3kVVpYK9eaG+TxRwl0yemtZOfCH9uRcY2eJ2V3APNMy2119l+fO4v2NRV7c/HX5Q0uZiUTytuifvlM7TG4RBhHkxv7eKAjKr9YZE0363Pc8vaJvEBSNh7p7+OUxmTj13t3njdZKMNqNzAoXidt1l1AIC0w9ur1/ompS4ZMeU1KA9eaSmSP5LDxowIdj0PAB8fQazqo1WHSJF9rWoP0dAC6Nwn0tqehT0iG8NwIQ7qjTxbZGgt1xMUrfi9SKoH94jtSopVWR4rDvlfAgMBAAECggEAaaKSzVKa6TgTvMBq9FHYmJT7WOqIsEAfxhOf5uK0RJRxFb/a2ySQyWr4Njyf+LRvv4OaPTYSI6kqxQZUjyHZVcu13YHFgLNSh9RpAMyZpWRAp5Pzk57jn3TWl0XZ5iT0Idw05dvs6Uv1kQDcZhhsf2L1hIyP0GeNZ6YN4AABqOHejiwv6+GTEvFucPa2WvHB2rpeQx6FJKNVq+f7PSnxNQm1ft9PBHXLLQhBlm3K22MB/YaVFLtSnxFohup3j9m0J+I1gzZt2jq9KiNIKXw6fvXT8QL9TgRRSndHK3fnBVHv7jtiSqN4lMwkSqlxJukwTkwoJKS5r13YapIcKPow4QKBgQD6kWmK771MaYNTkkasfqpdgyIJQ6md6zGv7ArZsIhHgLEK19nu0n3EC6icGpa95sZbcMYbM9F+ALC951SEoQvzVHbyYF5W+ma8KECg4O6jXTfIe+O1m8I6XkI/elT6le1kc80fNGA+hiFsUyTMXTMsCo5tWkLaBo4p2/HhGRj4qQKBgQC7tGLlVgyDWYKMJdUiXuZVVhH7jdZJKtKKzJllG7Wl0dkRhjBeSRKvKaWhtFd4G4Zp+h494hWcZXqE6Ss5p2axv1qTbtbtrnNhqiEJKH0YL247xoJ2MUeLm3/v0Bo7QaXWId/ejPQGYLDGrm40ZgVefox8PCLxUNtGq0B4AT7+xwKBgAs8mCoV5DxYAv6tcaPsrkExT0ZxFVsyn/DOuhHXG9VxDP96fJh8Mg2npDET9Cyh+8VAAnJX2Y44A7UQebbU7g9Ee20VK0XlRtQrTfKpA6qp1IWWILkVOhmZ/oiQON1f+dxmYQ2EMMi9BSSxedX8W/4enxKCWLskTh3MckVw9bC5AoGAITznCj87hgLSqCiG3kg5t0C/fHD4UgqAL83dF9dZShynuH+vjvKXmWbhionZt04AdkGxGzouo3wgvupfGh13hOAilNraukna6p9qrCl8RU0Y0wLq1S0Swzjs5bVO/9E3IXzsHIePKpXyl6wJncO3Da2RCOrJMTwlKBVpHBb0Zb8CgYEA53irrzZp7Zg8Xm4dSKbursNP7PoD8wMPHnOHbVbLi/8FC7Xvt1gOqeSDVv7b4XYXYXqfyDp2y8XuOYR1AAINSm2z2wDKaQ/AvzjqarVcpf2uP8AHQ7lRpvmEsTuxfHB3LZO1ewUs3c+33Pil3HRV4ymqUzChFyjw6bqjY5pbA4Y=";
    // 北京私钥
    public static String  RSA_PRIVATE_KEY   = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDIzcnHYU663nkBRQsyoOjHLLF4ffuUeHhf6QVDfIlYhwj9aNdAx6jJTEQCnEeYQHC+LpDoKvNWPivyWMOURK0RJ/wFLnW0jHKBl1dIn9vysFg9GQxXfpOryGzRkghHKWkUPVryEoa6fTthrRowcRpWI5Hnd8V0ImEuYnfEozdr8D5bEgs7n+BAxNehpw04rHWGXeyKEw0xiaIfIdzghI4hczczdB4RYvf04SBxxWaYmSMmgmIChuqIc3EHIl7Zb24+iH9zR3vzRf83pirR7S8JS6a7tnT1RqOwGeakg6PuOxDp8T1TMoKNhXGiMaWEBceSZQbNVBEkppN7Y1emddXBAgMBAAECggEAXhExPkqSZC4GB5c9iKkigvOn66cw7LuGwH9brOKxQJx5lKTBeaJOqoYksghd7a/6YM1Vqr08IyGa2rvEWzfUz12ozRCXqU3F8nlgNTBWDBmaLH0IcBBmwylv+LjtUdDPXeDkMtSE8uXppHc/9oN1b/bXydQs1puoZN9R9fbz5obe4N1aaqbhcd8xWgdwMs9kkd8ZGmAWsiQFcDLUQq1aIbEOfm0mUjWZwQ1IP28ta/OLAl0RvVjTJAVwfUvgpGuuXwKAPJBBgMBvZBD1iT/QvWa6amTVk8NqJGjny6HSvRvgSCENcOtVZcDWZFPwiNuKZGxelgzrwIjCAZGY77bgdQKBgQDz6RJMoYYeUe0oKaOy0cGb/VM9l1xQeEzrlBVI/S2UoU4MM2MWKe5dsH0k1vtgL37nanjMhBUXs0H8IDP8BAh9/8rDfe99vak6lxxBGwS7U0hctM0vG7l7V2scVMyVYTscbo57MB/spTaXakX/vPNhvXuuuoA7ulKiNLqGFHvY9wKBgQDSwb8Tw06UwdFUYrflb5nlgdcNOjtAfIssZcYa82C9lpDZhVXTVdUt5yyc3XXOt3nq9/tw5rIxUUgiEdiqMSGSgaAQVcQTco8VWy9AeYimsvUBwZuiJuQWT81ITS7vrIXEkae0XtHcDNQiNiqppfvuiqJbv1AyD34ShvX6k4mRBwKBgQCVchoXP+SoUTRJJnI5j5HcHPRSyZnzaDJhKWN9TDsQVWE30oiEvP5jA086MkrlXVSZQEBxtwAhfGEStTyEzofRg9fdvhzuYzX8Qzg5n+9fQ6ETxGfv1EHqk956Bm8vm9qXChpc2ljFK1luntvy3PgWy/2rSnRlpD0bS8l5e7WCcwKBgQC7NDeqsVAKmIJ851cbqF7V2tgPusrIxBfHLvuiEs66eJRfcq1ClDpQlMgu6hPrs1PLH8yrg2+CmQVupdWDjzKX9SYdfGE3OQnZWW6GYa29DLbOgY/hn5P4MZhRgaWQZPlJGmwRrivQv2BqpxyMJpC6WVBQGIZ+gP5mLJUvp3+JXwKBgQCuhwmaGYVor+pEzskYmv7270htsvh7oRrlqaLMva2aCX1r2zwhENF7cJCtFDtxMG6Ppq1Huu4squxDoJUEGBaJI0ehsNvle2tLGcil3xWGXIvm0YkQmAfic8UmHM6MMV9bKK/NY1A2wADhpmOZXSrgdJXVjsCu3mWCZSy3VmmrYQ==";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String  notify_url        = domainUrl + "/evcs/pay/pay_alipayNotify";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String  return_url        = domainUrl + "/evcs/pay/alipayReturn";
    // 请求网关地址
    public static String  URL               = "https://openapi.alipay.com/gateway.do";
    // 沙箱地址
    // public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String  CHARSET           = "UTF-8";
    // 返回格式
    public static String  FORMAT            = "json";
    // 支付宝公钥
    // public static String ALIPAY_PUBLIC_KEY =
    // "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoBf/pfqfqD25MPb3jtH4q8Tfi6vUvNdRVe+mcOfPhN5CU8pyTBZzaD02UKuhAlwRhVw95XvdK0A1YkPaEWG7qBpOVtU/FjvIP/Muf1QKe9Lahf3AIQsfiY4YV8p0UGZwjbi5JkrN1iCbiyfghjQ3ysB7pfwSuzDOhOj8J4hvbujvayDUa8kf+RKVpf4RHQ9apCEr8SfrQxoz785QxBfZf9iwkGjcD3YQBcKAE2nNGTm3hrVJlCJuB6UGkPSeluFjwPowS5aqWkcEdcOO5HDgcBZtS9Yk6HRI+b34OipDc8d8wfHCLSgsVCtdQRgmOIAOPi9DOy9xtM5RMIQyRUWxHwIDAQAB";
    // 北京支付宝公钥
    public static String  ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAht/XZuxw5ZYpTGS5Jn0DANIgEvOjPs/Ydwiv3eVrZ9YXz4vpF2LBQe/YlI3ubNXa4REY7C0Zk4akpFLSbEMQ4hEVXHjsParG+0J/CnvwXZPydxov5CTVRhI6O7hhhkcl8hng8d2d9xAIBVROTegLTCNuCqrU2EM5oI1pFKc3erV6se7mxsQgtaxVTnwkCM1UB3k6LUNC0+Qymro1ic6CU0TBAWlN1t/z4xyKHgFzDeZZdKpROsD7uszN79XNJXNJyauQzhCbCb9GdH/71tsGqJAUft8sKUkkiap7D0ZGuvWEqpDctMIg3fBKJxhljJp6um2R8Lf3G/zd4pEl7IaV5QIDAQAB";
    // 沙箱环境
    // public static String ALIPAY_PUBLIC_KEY =
    // "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5aw5rbAihYzyMvgW66NPIQL20HTQN1RWnpH3SzRvV/zsN+d2zBXW2kC6JEQIEGtIv9zobsC0QLo3Xuu9NIEHQVFwVqJunYCw5m27qNmO0i/+G7qyBTAHqfR6SXELuwls0m0xGJc3rjTxgU33WGM94/LtMlZfNI+Q43Lc/1bLNNsJWHBs24ldSAQ9uw1oYoVTUSkR+Vt0pKN1k5WEwnqKEJyILO3vo0Gdd5qH74jZibjcb8+Lr5kC45MN1mznBDa0knSYmO1PoNSgX7cex2/bthuNIPqTVzdY+HSD+lt8ril9Jjk3gyq0eKaqH5WhUR1deeamYGdT762yj1Mr7ruW+wIDAQAB";
    // 日志记录目录
    public static String  log_path          = "/log";
    // RSA2
    public static String  SIGNTYPE          = "RSA2";

}
