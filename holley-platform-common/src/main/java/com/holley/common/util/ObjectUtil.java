package com.holley.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ObjectUtils;

/**
 * 有关<code>Object</code>处理的工具类。
 */
public class ObjectUtil extends ObjectUtils {

    public static void copyProperty(Object orig, Object desc) {
        if (orig != null && desc != null) {
            try {
                BeanUtils.copyProperties(desc, orig);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 取对象的toString()方法，如果对象为空返回defaultValue
     * 
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String getObjectValue(Object obj, String defaultValue) {
        if (obj != null) {
            return obj.toString();
        }
        return defaultValue;
    }

    /**
     * 转换对象为int型，如果对象为空取默认值
     * 
     * @param obj
     * @param defaultValue
     * @return
     */
    public static Integer getObjIntValue(Object obj, Integer defaultValue) {
        if (obj != null) {
            return Integer.valueOf(obj.toString());
        } else {
            return defaultValue;
        }
    }

    public static Integer getObjIntValue(Object obj) {
        if (obj != null) {
            return Integer.valueOf(obj.toString());
        } else {
            return null;
        }
    }

    /**
     * 得到对象的属性值
     * 
     * @param bean
     * @param name
     * @return
     */
    public static String getProperty(Object bean, String name) {
        if (bean == null) {
            return null;
        }
        if (name == null) {
            return null;
        }
        try {
            return BeanUtils.getProperty(bean, name);
        } catch (IllegalAccessException e) {
            return null;
        } catch (InvocationTargetException e) {
            return null;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /**
     * 取得对象的原始的hash值, 如果对象为<code>null</code>, 则返回<code>0</code>。
     * <p>
     * 该方法使用<code>System.identityHashCode</code>来取得hash值，该值不受对象本身的<code>hashCode</code>方法的影响。
     * </p>
     * 
     * @param object 对象
     * @return hash值
     */
    public static int identityHashCode(Object object) {
        return (object == null) ? 0 : System.identityHashCode(object);
    }

    /* ============================================================================ */
    /* Clone函数。 */
    /*                                                                              */
    /* 以下方法调用Object.clone方法，默认是“浅复制”（shallow copy）。 */
    /* ============================================================================ */

    /**
     * 复制一个对象。如果对象为<code>null</code>，则返回<code>null</code>。
     * <p>
     * 此方法调用<code>Object.clone</code>方法，默认只进行“浅复制”。 对于数组，调用<code>ArrayUtil.clone</code>方法更高效。
     * </p>
     * 
     * @param array 要复制的数组
     * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
     */
    public static Object clone(Object array) {
        if (array == null) {
            return null;
        }

        // 对数组特殊处理
        if (array instanceof Object[]) {
            return ArrayUtil.clone((Object[]) array);
        }

        if (array instanceof long[]) {
            return ArrayUtil.clone((long[]) array);
        }

        if (array instanceof int[]) {
            return ArrayUtil.clone((int[]) array);
        }

        if (array instanceof short[]) {
            return ArrayUtil.clone((short[]) array);
        }

        if (array instanceof byte[]) {
            return ArrayUtil.clone((byte[]) array);
        }

        if (array instanceof double[]) {
            return ArrayUtil.clone((double[]) array);
        }

        if (array instanceof float[]) {
            return ArrayUtil.clone((float[]) array);
        }

        if (array instanceof boolean[]) {
            return ArrayUtil.clone((boolean[]) array);
        }

        if (array instanceof char[]) {
            return ArrayUtil.clone((char[]) array);
        }

        // Not cloneable
        if (!(array instanceof Cloneable)) {
            // throw new CloneNotSupportedException("Object of class " + array.getClass().getName() +
            // " is not Cloneable");
        }

        // 用reflection调用clone方法
        Class<?> clazz = array.getClass();

        try {
            Method cloneMethod = clazz.getMethod("clone", ArrayUtil.EMPTY_CLASS_ARRAY);

            return cloneMethod.invoke(array, ArrayUtil.EMPTY_OBJECT_ARRAY);
        } catch (Exception e) {
            return null;
        }

    }

    /* ============================================================================ */
    /* 比较对象的类型。 */
    /* ============================================================================ */

    /**
     * 检查两个对象是否属于相同类型。<code>null</code>将被看作任意类型。
     * 
     * @param object1 对象1
     * @param object2 对象2
     * @return 如果两个对象有相同的类型，则返回<code>true</code>
     */
    public static boolean isSameType(Object object1, Object object2) {
        if ((object1 == null) || (object2 == null)) {
            return true;
        }

        return object1.getClass().equals(object2.getClass());
    }

}
