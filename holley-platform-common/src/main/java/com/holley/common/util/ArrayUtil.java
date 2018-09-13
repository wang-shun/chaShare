package com.holley.common.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 有关数组处理的工具类
 */
public class ArrayUtil extends ArrayUtils {

    public static boolean isInArray(Integer[] array, Integer key) {
        if (array != null) {
            for (Integer keyArr : array) {
                if (keyArr == key) {
                    return true;
                }
            }
        }

        return false;
    }

    /* ============================================================================ */
    /* 默认值函数。 */
    /*                                                                              */
    /* 当数组为null或empty时，将数组转换成指定的默认数组。 */
    /* ============================================================================ */

    /**
     * 如果数组是null，则返回空数组[]，否则返回数组本身。 <br>
     * ArrayUtil.defaultIfNull(null) = [] ArrayUtil.defaultIfNull(new String[0]) = 数组本身 ArrayUtil.defaultIfNull(new
     * String[10]) = 数组本身
     * 
     * @param array 要转换的数组
     * @return 数组本身或空数组[]
     */
    public static Object[] defaultIfNull(Object[] array) {
        return (array == null) ? EMPTY_OBJECT_ARRAY : array;
    }

    /**
     * 如果数组是null，则返回指定默认数组，否则返回数组本身。 <br>
     * ArrayUtil.defaultIfNull(null, defaultArray) = defaultArray ArrayUtil.defaultIfNull(new String[0], defaultArray) =
     * 数组本身 ArrayUtil.defaultIfNull(new String[10], defaultArray) = 数组本身
     * 
     * @param array 要转换的数组
     * @param defaultArray 默认数组
     * @return 数组本身或指定的默认数组
     */
    public static Object[] defaultIfNull(Object[] array, Object[] defaultArray) {
        return (array == null) ? defaultArray : array;
    }

    /**
     * 如果数组是null或空数组[]，则返回空数组[]，否则返回数组本身。
     * <p>
     * 此方法实际上和defaultIfNull(Object[])等效。 <br>
     * ArrayUtil.defaultIfEmpty(null) = [] ArrayUtil.defaultIfEmpty(new String[0]) = 数组本身 ArrayUtil.defaultIfEmpty(new
     * String[10]) = 数组本身
     * </p>
     * 
     * @param array 要转换的数组
     * @return 数组本身或空数组[]
     */
    public static Object[] defaultIfEmpty(Object[] array) {
        return (array == null) ? EMPTY_OBJECT_ARRAY : array;
    }

    /**
     * 如果数组是null或空数组[]，则返回指定默认数组，否则返回数组本身。 <br>
     * ArrayUtil.defaultIfEmpty(null, defaultArray) = defaultArray ArrayUtil.defaultIfEmpty(new String[0], defaultArray)
     * = defaultArray ArrayUtil.defaultIfEmpty(new String[10], defaultArray) = 数组本身
     * 
     * @param array 要转换的数组
     * @param defaultArray 默认数组
     * @return 数组本身或指定的默认数组
     */
    public static Object[] defaultIfEmpty(Object[] array, Object[] defaultArray) {
        return ((array == null) || (array.length == 0)) ? defaultArray : array;
    }

    /**
     * 如果数组是null或空数组[]，则返回指定元素类型的空数组，否则返回数组本身。 <br>
     * ArrayUtil.defaultIfNull(null, String.class) = new String[0] ArrayUtil.defaultIfNull(new String[0], String.class)
     * = new String[0] ArrayUtil.defaultIfNull(new String[10], String.class) = 数组本身
     * 
     * @param array 要转换的数组
     * @param defaultComponentType 默认数组的元素类型
     * @return 数组本身或指定类型的空数组
     */
    @SuppressWarnings("unchecked")
    public static Object[] defaultIfEmpty(Object[] array, Class defaultComponentType) {
        return ((array == null) || (array.length == 0)) ? (Object[]) Array.newInstance(ClassUtil.getNonPrimitiveType(defaultComponentType), 0) : array;
    }

    /* ============================================================================ */
    /* 比较函数。 */
    /*                                                                              */
    /* 以下方法用来比较两个数组是否完全相同，支持多维数组。 */
    /* ============================================================================ */

    /**
     * 递归地比较两个数组是否相同，支持多维数组。
     * <p>
     * 如果比较的对象不是数组，则此方法的结果同ObjectUtil.equals。
     * </p>
     * 
     * @param array1 数组1
     * @param array2 数组2
     * @return 如果相等, 则返回true
     */
    @SuppressWarnings("unchecked")
    public static boolean equals(Object array1, Object array2) {
        if (array1 == array2) {
            return true;
        }

        if ((array1 == null) || (array2 == null)) {
            return false;
        }

        Class clazz = array1.getClass();

        if (!clazz.equals(array2.getClass())) {
            return false;
        }

        if (!clazz.isArray()) {
            return array1.equals(array2);
        }

        // array1和array2为同类型的数组
        if (array1 instanceof long[]) {
            long[] longArray1 = (long[]) array1;
            long[] longArray2 = (long[]) array2;

            if (longArray1.length != longArray2.length) {
                return false;
            }

            for (int i = 0; i < longArray1.length; i++) {
                if (longArray1[i] != longArray2[i]) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof int[]) {
            int[] intArray1 = (int[]) array1;
            int[] intArray2 = (int[]) array2;

            if (intArray1.length != intArray2.length) {
                return false;
            }

            for (int i = 0; i < intArray1.length; i++) {
                if (intArray1[i] != intArray2[i]) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof short[]) {
            short[] shortArray1 = (short[]) array1;
            short[] shortArray2 = (short[]) array2;

            if (shortArray1.length != shortArray2.length) {
                return false;
            }

            for (int i = 0; i < shortArray1.length; i++) {
                if (shortArray1[i] != shortArray2[i]) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof byte[]) {
            byte[] byteArray1 = (byte[]) array1;
            byte[] byteArray2 = (byte[]) array2;

            if (byteArray1.length != byteArray2.length) {
                return false;
            }

            for (int i = 0; i < byteArray1.length; i++) {
                if (byteArray1[i] != byteArray2[i]) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof double[]) {
            double[] doubleArray1 = (double[]) array1;
            double[] doubleArray2 = (double[]) array2;

            if (doubleArray1.length != doubleArray2.length) {
                return false;
            }

            for (int i = 0; i < doubleArray1.length; i++) {
                if (Double.doubleToLongBits(doubleArray1[i]) != Double.doubleToLongBits(doubleArray2[i])) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof float[]) {
            float[] floatArray1 = (float[]) array1;
            float[] floatArray2 = (float[]) array2;

            if (floatArray1.length != floatArray2.length) {
                return false;
            }

            for (int i = 0; i < floatArray1.length; i++) {
                if (Float.floatToIntBits(floatArray1[i]) != Float.floatToIntBits(floatArray2[i])) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof boolean[]) {
            boolean[] booleanArray1 = (boolean[]) array1;
            boolean[] booleanArray2 = (boolean[]) array2;

            if (booleanArray1.length != booleanArray2.length) {
                return false;
            }

            for (int i = 0; i < booleanArray1.length; i++) {
                if (booleanArray1[i] != booleanArray2[i]) {
                    return false;
                }
            }

            return true;
        } else if (array1 instanceof char[]) {
            char[] charArray1 = (char[]) array1;
            char[] charArray2 = (char[]) array2;

            if (charArray1.length != charArray2.length) {
                return false;
            }

            for (int i = 0; i < charArray1.length; i++) {
                if (charArray1[i] != charArray2[i]) {
                    return false;
                }
            }

            return true;
        } else {
            Object[] objectArray1 = (Object[]) array1;
            Object[] objectArray2 = (Object[]) array2;

            if (objectArray1.length != objectArray2.length) {
                return false;
            }

            for (int i = 0; i < objectArray1.length; i++) {
                if (!equals(objectArray1[i], objectArray2[i])) {
                    return false;
                }
            }

            return true;
        }
    }

    /* ============================================================================ */
    /* 将数组转换成集合类。 */
    /* ============================================================================ */

    /**
     * 将数组映射成固定长度的List，当改变这个List中的值时。数组中的相应值也被改变。
     * <p>
     * 该方法内部调用java.util.Arrays.asList方法所返回的列表为指定数组的映像（固定长度），因此性能和内存占用上比toList方法更优。
     * </p>
     * <p>
     * 这个方法常被用于初始化，例如：<br>
     * List myList = ArrayUtil.toFixedList(new String[] { &quot;aaa&quot;, &quot;bbb&quot;, &quot;ccc&quot; });
     * </p>
     * 
     * @param array 要转换的数组
     * @return 以数组本身为映射的list
     */
    @SuppressWarnings("unchecked")
    public static List toFixedList(Object[] array) {
        if (array == null) {
            return null;
        }

        return Arrays.asList(array);
    }

    /**
     * 将数组转换成List
     * 
     * @param array 要转换的数组
     * @return 被创建的list
     */
    @SuppressWarnings("unchecked")
    public static List toList(Object array) {
        return toList(array, null);
    }

    /**
     * 将数组转换成List,该方法返回的列表为指定数组的复本,<br>
     * 而java.util.Arrays.asList方法所返回的列表为指定数组的映像（固定长度） 例如：<br>
     * List myList = ArrayUtil.toList(new String[] { &quot;aaa&quot;, &quot;bbb&quot;, &quot;ccc&quot; }, new
     * ArrayList()); List singleList = ArrayUtil.toList( &quot;hello&quot;, new ArrayList()); //
     * 返回单个元素的列表[&quot;hello&quot;] </p>
     * 
     * @param array 要转换的数组
     * @param list 要填充的列表，如果是null，则创建之
     * @return 被创建或填充的list
     */
    @SuppressWarnings("unchecked")
    public static List toList(Object array, List list) {
        if (array == null) {
            return list;
        }

        // 非array，创建一个只有一个元素的列表
        if (!array.getClass().isArray()) {
            if (list == null) {
                list = new ArrayList(1);
            }

            list.add(array);
        } else if (array instanceof long[]) {
            long[] longArray = (long[]) array;

            if (list == null) {
                list = new ArrayList(longArray.length);
            }

            for (int i = 0; i < longArray.length; i++) {
                list.add(new Long(longArray[i]));
            }
        } else if (array instanceof int[]) {
            int[] intArray = (int[]) array;

            if (list == null) {
                list = new ArrayList(intArray.length);
            }

            for (int i = 0; i < intArray.length; i++) {
                list.add(new Integer(intArray[i]));
            }
        } else if (array instanceof short[]) {
            short[] shortArray = (short[]) array;

            if (list == null) {
                list = new ArrayList(shortArray.length);
            }

            for (int i = 0; i < shortArray.length; i++) {
                list.add(new Short(shortArray[i]));
            }
        } else if (array instanceof byte[]) {
            byte[] byteArray = (byte[]) array;

            if (list == null) {
                list = new ArrayList(byteArray.length);
            }

            for (int i = 0; i < byteArray.length; i++) {
                list.add(new Byte(byteArray[i]));
            }
        } else if (array instanceof double[]) {
            double[] doubleArray = (double[]) array;

            if (list == null) {
                list = new ArrayList(doubleArray.length);
            }

            for (int i = 0; i < doubleArray.length; i++) {
                list.add(new Double(doubleArray[i]));
            }
        } else if (array instanceof float[]) {
            float[] floatArray = (float[]) array;

            if (list == null) {
                list = new ArrayList(floatArray.length);
            }

            for (int i = 0; i < floatArray.length; i++) {
                list.add(new Float(floatArray[i]));
            }
        } else if (array instanceof boolean[]) {
            boolean[] booleanArray = (boolean[]) array;

            if (list == null) {
                list = new ArrayList(booleanArray.length);
            }

            for (int i = 0; i < booleanArray.length; i++) {
                list.add(booleanArray[i] ? Boolean.TRUE : Boolean.FALSE);
            }
        } else if (array instanceof char[]) {
            char[] charArray = (char[]) array;

            if (list == null) {
                list = new ArrayList(charArray.length);
            }

            for (int i = 0; i < charArray.length; i++) {
                list.add(new Character(charArray[i]));
            }
        } else {
            Object[] objectArray = (Object[]) array;

            if (list == null) {
                list = new ArrayList(objectArray.length);
            }

            for (int i = 0; i < objectArray.length; i++) {
                list.add(objectArray[i]);
            }
        }

        return list;
    }

    /**
     * 将数组转换成Map。数组的元素必须是Map.Entry或元素个数多于2的子数组。
     * <p>
     * 例如： <br>
     * Map colorMap = ArrayUtil.toMap(new String[][] { { &quot;RED&quot;, &quot;#FF0000&quot; }, { &quot;GREEN&quot;,
     * &quot;#00FF00&quot; }, { &quot;BLUE&quot;, &quot;#0000FF&quot; } });
     * </p>
     * 
     * @param array 要转换的数组
     * @return 被创建的map
     * @throws IllegalArgumentException 如果有一个子数组元素个数小于2或不是Map.Entry实例
     */
    @SuppressWarnings("unchecked")
    public static Map toMap(Object[] array) {
        return toMap(array, null);
    }

    /**
     * 将数组转换成Map。数组的元素必须是Map.Entry或元素个数多于2的子数组。
     * <p>
     * 这个方法常被用于初始化，例如： <br>
     * Map colorMap = ArrayUtil.toMap(new String[][] {{ {&quot;RED&quot;, &quot;#FF0000&quot;}, {&quot;GREEN&quot;,
     * &quot;#00FF00&quot;}, {&quot;BLUE&quot;, &quot;#0000FF&quot;}}, new HashMap());
     * </p>
     * 
     * @param array 要转换的数组
     * @param map 要填充的map，如果为null则自动创建之
     * @return 被创建或填充的map
     * @throws IllegalArgumentException 如果有一个子数组元素个数小于2或不是Map.Entry实例
     */
    @SuppressWarnings("unchecked")
    public static Map toMap(Object[] array, Map map) {
        if (array == null) {
            return map;
        }

        if (map == null) {
            map = new HashMap((int) (array.length * 1.5));
        }

        for (int i = 0; i < array.length; i++) {
            Object object = array[i];

            if (object instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) object;

                map.put(entry.getKey(), entry.getValue());
            } else if (object instanceof Object[]) {
                Object[] entry = (Object[]) object;

                if (entry.length < 2) {
                    throw new IllegalArgumentException("Array element " + i + ", '" + object + "', has a length less than 2");
                }

                map.put(entry[0], entry[1]);
            } else {
                throw new IllegalArgumentException("Array element " + i + ", '" + object + "', is neither of type Map.Entry nor an Array");
            }
        }

        return map;
    }

    /**
     * 数组按照长度分割为List
     * 
     * @param arr
     * @param length
     * @param offset 从哪一位开始
     * @return
     */
    public static List<List<String>> toSplitList(String[] arr, int length, int offset) {
        if (arr == null || arr.length < (length + offset)) {
            return null;
        }

        List<List<String>> result = new ArrayList<List<String>>();
        List<String> subList = null;
        int curr = 0;

        for (int i = offset; i < arr.length; i++) {
            if (curr > length - 1) {
                curr = 0;
            }

            if (curr == 0) {
                subList = new ArrayList<String>();
                result.add(subList);
            }

            subList.add(arr[i]);
            curr++;
        }

        return result;
    }

}
