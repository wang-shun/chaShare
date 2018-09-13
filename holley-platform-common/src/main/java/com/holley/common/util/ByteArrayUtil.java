package com.holley.common.util;

/**
 * 二进制数组管理工具
 */
public class ByteArrayUtil {

    /**
     * 比较二进制数据大小
     * 
     *@param source 第一个数组
     *@param dest 弟二个数组
     *@param length 比较最大长度
     *@return >0 第一个大 <0 第二个大 =0 一样大
     */
    public static int compare(byte[] source, byte[] dest, int length) {
        for (int i = 0; i < length; i++) {
            if (source[i] != dest[i]) {
                return dest[i] - source[i];
            }
        }
        return 0;
    }

    /**
     * 返回
     * 
     *@param source Description of Parameter
     *@param target Description of Parameter
     *@return Description of the Returned Value
     */
    public static int indexOf(byte[] source, byte[] target) {
        return indexOf(source, 0, source.length, target, 0, target.length, 0);
    }

    /**
     * Description of the Method
     * 
     *@param source Description of Parameter
     *@param target Description of Parameter
     *@param fromIndex Description of Parameter
     *@return Description of the Returned Value
     */
    public static int indexOf(byte[] source, byte[] target, int fromIndex) {
        return indexOf(source, 0, source.length, target, 0, target.length, fromIndex);
    }

    /**
     * target 在 source 中的序号
     * 
     *@param source Description of Parameter
     *@param sourceOffset Description of Parameter
     *@param sourceCount Description of Parameter
     *@param target Description of Parameter
     *@param targetOffset Description of Parameter
     *@param targetCount Description of Parameter
     *@param fromIndex Description of Parameter
     *@return Description of the Returned Value
     */
    static int indexOf(byte[] source, int sourceOffset, int sourceCount, byte[] target, int targetOffset,
                       int targetCount, int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        byte first = target[targetOffset];
        int i = sourceOffset + fromIndex;
        int max = sourceOffset + (sourceCount - targetCount);

        startSearchForFirstChar: while (true) {
            while (i <= max && source[i] != first) {
                i++;
            }
            if (i > max) {
                return -1;
            }
            int j = i + 1;
            int end = j + targetCount - 1;
            int k = targetOffset + 1;
            while (j < end) {
                if (source[j++] != target[k++]) {
                    i++;
                    continue startSearchForFirstChar;
                }
            }
            return i - sourceOffset;
        }
    }

}
