package com.holley.common.dataobject;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class WebUserList {

    private static final WebUserList webUserList = new WebUserList();

    private Vector<WebUser> v;

    public WebUserList() {
        v = new Vector<WebUser>();
    }

    public static WebUserList getInstance() {
        return webUserList;
    }

    public void addUser(WebUser webuser) {
        int incount = 0;
        if (webuser != null) {
            if (v.size() > 0) {
                for (int i = 0; i < v.size(); i++) {
                    WebUser wu = v.get(i);
                    if (wu.getUserName().equals(webuser.getUserName()) && wu.getIp().equals(webuser.getIp())) {
                        incount = 0;
                        break;
                    } else {
                        incount = incount + 1;
                    }
                }
                if (incount == v.size()) {
                    v.addElement(webuser);
                }
            } else {
                v.addElement(webuser);
            }
        }
    }

    public void removeUser(WebUser webuser) {
        if (webuser != null) {
            for (int i = 0; i < v.size(); i++) {
                WebUser wu = v.get(i);
                if (wu.getUserName().equals(webuser.getUserName()) && wu.getIp().equals(webuser.getIp())) {
                    v.remove(i);
                }
            }
        }
    }

    public Enumeration<WebUser> getUserList(Long intime, String inusername, String inip) {
        // updateLongDate(v, intime, inusername, inip);
        return v.elements();
    }

    public int getUserCount(Long intime, String inusername, String inip) {
        // updateLongDate(v, intime, inusername, inip);
        return v.size();
    }

    @SuppressWarnings("rawtypes")
    public void updateLongDate(Vector<WebUser> vector, Long intime, String inusername, String inip) {
        if (intime != null && inusername != null && inip != null) {

            Enumeration enumeration = v.elements();
            for (Enumeration e = enumeration; enumeration.hasMoreElements();) {
                WebUser webUser = (WebUser) e.nextElement();
                String webip = webUser.getIp();
                String webusername = webUser.getUserName();
                if (inusername.equals(webusername) && inip.equals(webip)) {
                    webUser.setLongDate(intime);
                }
            }
            isremove(vector);
        }
    }

    @SuppressWarnings("rawtypes")
    public void isremove(Vector<WebUser> vector) {
        Enumeration enumeration = v.elements();
        Long time = new Date().getTime();
        for (Enumeration e = enumeration; enumeration.hasMoreElements();) {
            WebUser webUser = (WebUser) e.nextElement();
            Long longtime = webUser.getLongDate();
            if (time - longtime > 60 * 1000) {// 延时1分00秒的删除
                removeUser(webUser);
            }
        }
    }
}
