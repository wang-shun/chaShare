package com.holley.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.holley.common.dataobject.ComboxBean;

public class ListUtil {

    public static final String ALL = "all";

    public static List<Short> convertShort(List<Integer> list) {
        List<Short> result = new ArrayList<Short>();
        if (list != null) {
            for (Integer id : list) {
                result.add(id.shortValue());
            }
        }

        return result;

    }

    /**
     * 把list按照指定的大小分成多份
     * 
     * @param list
     * @param count
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<List> subList(List list, int count) {
        if (list == null) {
            return null;
        }

        List<List> returnList = new ArrayList();
        if (list.size() <= count) {
            returnList.add(list);
        } else {
            int comapreCount = 1;

            List tempList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                tempList.add(obj);
                if (comapreCount == count || i == list.size() - 1) {
                    returnList.add(tempList);
                    tempList = new ArrayList();
                    comapreCount = 0;
                }
                comapreCount++;
            }
        }
        return returnList;
    }

    /**
     * 从list取某个字段的数据组成新的list
     * 
     * @param list
     * @param key
     * @param isDistinct true去重复
     * @return
     */
    public static List<String> toStrList(List list, String key, boolean isDistinct) {
        if (list != null) {
            List<String> result = new ArrayList<String>();
            for (Object obj : list) {

                try {
                    String keyStr = BeanUtils.getProperty(obj, key);
                    if (keyStr != null) {
                        result.add(keyStr);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (isDistinct) {
                getDistinctList(result);
            }

            return result;
        }
        return null;

    }

    /**
     * 从list取某个字段的数据组成新的list
     * 
     * @param list
     * @param key
     * @param isDistinct true去重复
     * @return
     */
    public static List<Integer> toIntList(List list, String key, boolean isDistinct) {
        if (list != null) {
            List<Integer> result = new ArrayList<Integer>();
            for (Object obj : list) {

                try {
                    String keyStr = BeanUtils.getProperty(obj, key);
                    if (keyStr != null) {
                        result.add(Integer.valueOf(keyStr));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (isDistinct) {
                getDistinctList(result);
            }

            return result;
        }
        return null;

    }

    /**
     * 从list取某个字段的数据组成新的list
     * 
     * @param list
     * @param key
     * @param isDistinct true去重复
     * @return
     */
    public static List<Short> toShortList(List list, String key, boolean isDistinct) {
        if (list != null) {
            List<Integer> intList = toIntList(list, key, isDistinct);

            return ListUtil.convertShort(intList);
        }
        return null;

    }

    /**
     * 把数据转换为comboxBean
     * 
     * @param list
     * @param key
     * @param value
     * @return
     */
    public static List<ComboxBean> toComboxList(List<?> list, String key, String value) {
        List<ComboxBean> returnList = new ArrayList<ComboxBean>();
        if (list != null) {

            for (Object obj : list) {
                try {
                    String keyStr = BeanUtils.getProperty(obj, key);
                    String valueStr = BeanUtils.getProperty(obj, value);

                    if (keyStr != null && valueStr != null) {
                        returnList.add(new ComboxBean(keyStr, valueStr));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return returnList;
    }

    /**
     * 通过key取value
     * 
     * @param list
     * @param key
     * @return
     */
    public static String getComboxValue(List<ComboxBean> list, String key) {
        if (list != null) {
            for (ComboxBean bean : list) {
                if (StringUtils.equals(bean.getKey(), key)) {
                    return bean.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 通过value取key
     * 
     * @param list
     * @param value
     * @return
     */
    public static String getComboxKey(List<ComboxBean> list, String value) {
        if (list != null) {
            for (ComboxBean bean : list) {
                if (StringUtils.equals(bean.getValue(), value)) {
                    return bean.getKey();
                }
            }
        }
        return null;

    }

    public static List<ComboxBean> addALLNullValueCombox(List<ComboxBean> list) {
        if (list != null) {
            list.add(0, new ComboxBean("全部", ""));
            return list;
        } else {
            return null;
        }
    }

    public static List<ComboxBean> addALLCombox(List<ComboxBean> list) {
        if (list != null) {
            list.add(0, new ComboxBean("全部", ALL));
            return list;
        } else {
            return null;
        }
    }

    /**
     * 分隔字符串为字符串list
     * 
     * @param desc
     * @param sepatator
     * @return
     */
    public static List<String> splitToStringList(String desc, String sepatator) {
        if (StringUtils.isNotEmpty(desc) && StringUtils.isNotEmpty(sepatator)) {
            String[] spliter = StringUtils.split(desc, sepatator);
            if (spliter != null) {
                List<String> list = new ArrayList<String>();
                for (String str : spliter) {
                    list.add(str);
                }

                return list;
            }
        }

        return null;
    }

    public static List<Short> splitToShortList(String desc, String sepatator) {
        if (StringUtils.isNotEmpty(desc) && StringUtils.isNotEmpty(sepatator)) {
            String[] spliter = StringUtils.split(desc, sepatator);
            if (spliter != null) {
                List<Short> list = new ArrayList<Short>();
                for (String str : spliter) {
                    if (StringUtils.isNumeric(str)) list.add(Short.valueOf(str));
                }

                return list;
            }
        }

        return null;
    }

    public static List<Integer> splitToIntList(String desc, String sepatator) {
        if (StringUtils.isNotEmpty(desc) && StringUtils.isNotEmpty(sepatator)) {
            String[] spliter = StringUtils.split(desc, sepatator);
            if (spliter != null) {
                List<Integer> list = new ArrayList<Integer>();
                for (String str : spliter) {
                    if (NumberUtils.isDigits(str)) {
                        list.add(Integer.valueOf(str));
                    }
                }

                return list;
            }
        }

        return null;
    }

    /**
     * for example source list [a,b,c,d,e,f,g,h,i,j,k,l,m] use getColList(source list,3) return [[a,f,k] [b,g,l] [c,h,m]
     * [d,i] [e,j]]
     * 
     * @param sourceList the list to be copy
     * @param colCount the col count of result
     * @return
     */
    public static List<List<Object>> getColList(List<Object> sourceList, int colCount) {
        if ((sourceList == null) || (colCount <= 0) || (sourceList.size() <= 0)) {
            return null;
        }

        int rowCount = getLength(sourceList.size(), colCount);

        return getColListWithRowCount(sourceList, rowCount);
    }

    /**
     * list 中去重复
     * 
     * @param lists
     */
    public static void getDistinctList(List<?> lists) {
        if (lists == null) {
            return;
        }

        Set<Object> objSet = new HashSet<Object>(lists.size());
        for (int i = lists.size() - 1; i >= 0; i--) {
            Object obj = lists.get(i);
            if (objSet.contains(obj)) {
                lists.remove(obj);
            } else {
                objSet.add(obj);
            }
        }
    }

    /**
     * for example source list [a,b,c,d,e,f,g,h,i,j,k,l,m] use getColListWithRowCount(source list,3) return [[a,d,g,j,m]
     * [b,e,h,k] [c,f,i,l]
     * 
     * @param sourceList the list to be copy
     * @param colCount the col count of result
     * @return
     */
    public static List<List<Object>> getColListWithRowCount(List<Object> sourceList, int rowCount) {
        if ((sourceList == null) || (rowCount <= 0) || (sourceList.size() <= 0)) {
            return null;
        }

        List<List<Object>> tagShowList = new ArrayList<List<Object>>();

        for (int index = 0; index < rowCount; index++) {
            List<Object> tagGroup = new ArrayList<Object>();
            tagShowList.add(tagGroup);
        }

        for (int i = 0; i < sourceList.size(); i++) {
            List<Object> tagGroup = tagShowList.get((i + rowCount) % rowCount);
            tagGroup.add(sourceList.get(i));
        }

        return tagShowList;
    }

    /**
     * for example source list [a,b,c,d,e,f,g,h,i,j,k,l,m]<br>
     * use getRowList(source list,3)<br>
     * 
     * <pre>
     * return [[a,b,c,d,e]
     *         [f,g,h,i,j]
     *         [k,l,m]]
     * </pre>
     * 
     * @param sourceList the list to be copy
     * @param colCount the col count of result
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<List<Object>> getRowList(List<Object> tagList, int colCount) {
        if ((tagList == null) || (colCount <= 0) || (tagList.size() <= 0)) {
            return null;
        }

        List tagShowList = new ArrayList();
        List<Object> tagGroup = new ArrayList<Object>();
        int rowCount = getLength(tagList.size(), colCount);

        for (int i = 0; i < tagList.size(); i++) {
            tagGroup.add(tagList.get(i));

            if ((rowCount == 1) || (((i + 1) % rowCount) == 0) || (i == (tagList.size() - 1))) {
                tagShowList.add(tagGroup);
                tagGroup = new ArrayList<Object>();
            }
        }

        return tagShowList;
    }

    /**
     * for example source list [a,b,c,d,e,f,g,h,i,j,k,l,m]<br>
     * use getRowList(source list,5)<br>
     * 
     * <pre>
     * return [[a,b,c,d,e]
     *         [f,g,h,i,j]
     *         [k,l,m]]
     * </pre>
     * 
     * @param sourceList the list to be copy
     * @param colCount the col count of result
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List getRowListWithRowCount(List tagList, int rowCount) {
        if ((tagList == null) || (rowCount <= 0) || (tagList.size() <= 0)) {
            return null;
        }

        List tagShowList = new ArrayList();
        List tagGroup = new ArrayList();
        // int colCount = getLength(tagList.size(), rowCount);

        for (int i = 0; i < tagList.size(); i++) {
            tagGroup.add(tagList.get(i));

            if ((rowCount == 1) || (((i + 1) % rowCount) == 0) || (i == (tagList.size() - 1))) {
                tagShowList.add(tagGroup);
                tagGroup = new ArrayList();
            }
        }

        return tagShowList;
    }

    /**
     * @param tagList
     * @param length
     */
    private static int getLength(int totalLength, int step) {
        int colCount = 1;

        if ((totalLength > 0) && (step > 0)) {
            colCount = totalLength / step;

            if ((totalLength % step) != 0) {
                colCount = colCount + 1;
            }
        }

        return colCount;
    }

    /**
     * 分页
     * 
     * @param keyList
     * @param colCount
     * @return
     */
    public static Object[] getRowList(Object[] keyList, int colCount) {
        if ((keyList == null) || (colCount <= 0) || (keyList.length <= 0)) {
            return null;
        }

        int rowCount = getLength(keyList.length, colCount);

        Object[] resultShowList = new String[colCount][rowCount];

        for (int i = 0, j = 0; i < keyList.length; i++) {
            ((Object[]) resultShowList[j])[i % rowCount] = keyList[i];

            if ((rowCount == 1) || (((i + 1) % rowCount) == 0) || (i == (keyList.length - 1))) {
                j = j + 1;
            }
        }

        return resultShowList;
    }

    /**
     * 字符串数组转化为包含integer类的list
     * 
     * @param <T>
     * @param arr
     * @return
     */
    public static List<Integer> stringArrToIntList(String[] arr) {
        if (arr == null) {
            return null;
        } else {
            List<Integer> ret = new ArrayList<Integer>();
            for (String item : arr) {
                ret.add(Integer.valueOf(item));
            }
            return ret;
        }
    }

    /**
     * 字符串数组转化为包含integer类的list
     * 
     * @param <T>
     * @param arr
     * @return
     */
    public static List<Short> stringArrToShortList(String[] arr) {
        if (arr == null) {
            return null;
        } else {
            List<Short> ret = new ArrayList<Short>();
            for (String item : arr) {
                ret.add(Short.valueOf(item));
            }
            return ret;
        }
    }

    /**
     * 对象数据转换为list<Object>
     * 
     * @param <T>
     * @param objects
     * @return
     */
    public static <T> List<T> objectArrayToList(T[] objects) {
        if (objects == null) {
            return null;
        } else {
            List<T> ret = new ArrayList<T>();
            for (T object : objects) {
                ret.add(object);
            }
            return ret;
        }
    }

    public static String listToStr(List<String> list, String sep) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (String str : list) {
                sb.append(str).append(sep);
            }
        }

        return sb.toString();
    }
}
