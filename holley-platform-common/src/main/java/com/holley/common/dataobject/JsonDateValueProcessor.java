package com.holley.common.dataobject;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.beanutils.BeanUtils;

import com.holley.common.util.DateUtil;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonDateValueProcessor implements JsonValueProcessor {

    private String datePattern = DateUtil.TIME_LONG;

    public JsonDateValueProcessor() {
        super();
    }

    public JsonDateValueProcessor(String format) {
        super();
        this.datePattern = format;
    }

    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    private Object process(Object value) {
        try {
            if (value instanceof Date) {
                SimpleDateFormat sdf = new SimpleDateFormat(datePattern, Locale.UK);
                return sdf.format((Date) value);
            } else if (value instanceof Enum) {
                return BeanUtils.getProperty(value, "value");
            } else if (value instanceof BigDecimal || value instanceof Double) {
                return value.toString();
            }
            return value == null ? "" : value.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String pDatePattern) {
        datePattern = pDatePattern;
    }
}
