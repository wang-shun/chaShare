package com.holley.common.rocketmq;

import java.io.Serializable;

public class MsgBase implements Serializable {

    private static final long serialVersionUID = 1L;
    protected String          id;
    protected String          topic;
    protected String          tag;
    protected String          key;
    protected byte[]          body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

}
