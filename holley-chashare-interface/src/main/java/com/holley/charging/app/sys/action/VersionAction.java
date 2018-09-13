package com.holley.charging.app.sys.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.holley.charging.action.BaseAction;
import com.holley.common.constants.ResultBean;
import com.holley.common.constants.charge.LinkTypeEnum;
import com.holley.platform.model.sys.SysLink;
import com.holley.platform.util.CacheSysHolder;
import com.holley.platform.util.RoleUtil;

public class VersionAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private ResultBean        resultBean       = new ResultBean();

    /**
     * app版本查询
     * 
     * @return
     */
    public String version() {
        List<SysLink> list = CacheSysHolder.getLinkListBytypeId(LinkTypeEnum.ANDROID_VERSION.getValue());
        Map<String, Object> data = new HashMap<String, Object>();
        // 得到最新版本
        int vercode = 0;
        String vername = "0.0.0";
        if (list != null && list.size() > 0) {
            String[] temparray;
            String tempcode;
            for (SysLink record : list) {
                temparray = record.getId().split("_");
                if (temparray != null && temparray.length > 0) {
                    tempcode = temparray[temparray.length - 1];
                    if (NumberUtils.isNumber(tempcode) && Integer.parseInt(tempcode) > vercode) {
                        vercode = Integer.parseInt(tempcode);
                        vername = record.getValue();
                    }
                }
            }
            data.put("appversion", vername);
            data.put("apkupdateurl", RoleUtil.selectRuleByPrimaryKey(RoleUtil.APK_UPDATE_URL));
            resultBean.setData(data);
        }
        return SUCCESS;
    }

    public ResultBean getResultBean() {
        return resultBean;
    }

}
