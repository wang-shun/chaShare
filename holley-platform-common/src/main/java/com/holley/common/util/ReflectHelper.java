package com.holley.common.util;

import java.lang.reflect.Field;

/**
 * @author Administrator 反射工具
 */
public class ReflectHelper {

    /**
     * 得到对象的所有属性值 key = value ;分割的字符串
     * 
     * @param obj
     * @return
     */
    public static String getObjAllValue(Object obj) {
        if (obj != null) {
            StringBuilder sb = new StringBuilder();
            Field[] fields = obj.getClass().getDeclaredFields();
            if (fields != null) {

                for (Field field : fields) {
                    sb.append(field.getName()).append("=");
                    Object value = null;
                    try {
                        if (field.isAccessible()) {
                            value = field.get(obj);
                        } else {
                            field.setAccessible(true);
                            value = field.get(obj);
                            field.setAccessible(false);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    sb.append(value).append(";");
                }

                return sb.toString();
            }
        }

        return null;
    }

    /**
     * 获取obj对象fieldName的Field
     * 
     * @param obj
     * @param fieldName
     * @return
     */
    public static Field getFieldByFieldName(Object obj, String fieldName) {
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
            }
        }
        return null;
    }

    /**
     * 获取obj对象fieldName的属性值
     * 
     * @param obj
     * @param fieldName
     * @return
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object getValueByFieldName(Object obj, String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field field = getFieldByFieldName(obj, fieldName);
        Object value = null;
        if (field != null) {
            if (field.isAccessible()) {
                value = field.get(obj);
            } else {
                field.setAccessible(true);
                value = field.get(obj);
                field.setAccessible(false);
            }
        }
        return value;
    }

    /**
     * 设置obj对象fieldName的属性值
     * 
     * @param obj
     * @param fieldName
     * @param value
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setValueByFieldName(Object obj, String fieldName, Object value) throws SecurityException, NoSuchFieldException, IllegalArgumentException,
                                                                                       IllegalAccessException {
        Field field = getFieldByFieldName(obj, fieldName);
        if (field.isAccessible()) {
            field.set(obj, value);
        } else {
            field.setAccessible(true);
            field.set(obj, value);
            field.setAccessible(false);
        }
    }

    /**
     * 获取属性名数组
     */
    public static String[] getFiledName(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getType());
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

}
