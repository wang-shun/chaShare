package com.holley.common.i18n;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.holley.common.util.ObjectUtil;

/**
 * 代表一个locale信息。
 */
public final class LocaleInfo implements Cloneable, Serializable {

    private static final long       serialVersionUID = 1L;
    private static final CharsetMap CHARSET_MAP      = new CharsetMap();
    private Locale                  locale;
    private String                  charset;

    /**
     * 创建系统locale信息。
     */
    LocaleInfo() {
        this.locale = Locale.getDefault();
        this.charset = LocaleUtil.getStandardCharset(new OutputStreamWriter(new ByteArrayOutputStream()).getEncoding(), "ISO-8859-1");
    }

    /**
     * 创建locale信息。
     * 
     * @param locale 区域信息
     */
    public LocaleInfo(Locale locale) {
        this(locale, null);
    }

    /**
     * 创建locale信息。
     * 
     * @param locale 区域信息
     * @param charset 编码字符集
     */
    public LocaleInfo(Locale locale, String charset) {
        this(locale, charset, LocaleUtil.getDefault());
    }

    /**
     * 创建locale信息。
     * 
     * @param locale 区域信息
     * @param charset 编码字符集
     * @param defaultLocaleInfo 默认的locale信息
     */
    LocaleInfo(Locale locale, String charset, LocaleInfo defaultLocaleInfo) {
        if (locale == null) {
            locale = defaultLocaleInfo.getLocale();

            if (StringUtils.isEmpty(charset)) {
                charset = defaultLocaleInfo.getCharset();
            }
        }

        if (StringUtils.isEmpty(charset)) {
            charset = CHARSET_MAP.getCharSet(locale);
        }

        this.locale = locale;
        this.charset = LocaleUtil.getStandardCharset(charset, defaultLocaleInfo.getCharset());
    }

    /**
     * 取得区域。
     * 
     * @return 区域
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * 取得编码字符集。
     * 
     * @return 编码字符集
     */
    public String getCharset() {
        return charset;
    }

    /**
     * 比较对象。
     * 
     * @param o 被比较的对象
     * @return 如果对象等效，则返回<code>true</code>
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (!(o instanceof LocaleInfo)) {
            return false;
        }

        LocaleInfo otherLocaleInfo = (LocaleInfo) o;

        return ObjectUtil.equals(locale, otherLocaleInfo.locale) && ObjectUtil.equals(charset, otherLocaleInfo.charset);
    }

    /**
     * 取得locale信息的hash值。
     * 
     * @return hash值
     */
    @Override
    public int hashCode() {
        return ObjectUtil.hashCode(locale) ^ ObjectUtil.hashCode(charset);
    }

    /**
     * 复制对象。
     * 
     * @return 复制品
     */
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    /**
     * 取得字符串表示。
     * 
     * @return 字符串表示
     */
    @Override
    public String toString() {
        return locale + ":" + charset;
    }
}
