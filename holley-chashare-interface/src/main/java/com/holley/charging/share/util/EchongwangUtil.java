package com.holley.charging.share.util;

import org.apache.commons.lang3.math.NumberUtils;

public class EchongwangUtil {

    private final static String PREFIX_WM   = "110115097"; // 万马新能源站点
    private final static String PREFIX_XYHY = "XY201701"; // 新源恒源站点

    public static String wrapStationId(Integer stationId) {// 284，285，286万马充电站
        String str = "";
        if (284 == stationId || 285 == stationId || 286 == stationId) {
            str = PREFIX_WM + stationId;
        } else {
            str = PREFIX_XYHY + String.format("%08d", stationId);
        }

        return str;
    }

    public static Integer crateStationId(String stationId) {
        String str = stationId;
        if (stationId.contains(PREFIX_XYHY)) {
            str = stationId.replace(PREFIX_XYHY, "");
        } else if (stationId.contains(PREFIX_WM)) {
            str = stationId.replace(PREFIX_WM, "");
        }
        return NumberUtils.toInt(str);
    }

}
