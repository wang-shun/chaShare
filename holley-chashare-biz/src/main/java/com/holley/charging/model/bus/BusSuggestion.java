package com.holley.charging.model.bus;

import com.holley.common.constants.charge.SuggestionStatusEnum;
import com.holley.common.constants.charge.UserTypeEnum;
import com.holley.common.util.DateUtil;

public class BusSuggestion extends BusSuggestionKey {

    private String content;

    private String pic;

    private Short  status;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }


}
