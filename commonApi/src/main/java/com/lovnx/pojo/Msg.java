package com.lovnx.pojo;

import java.util.Date;

/**
 * @Author: yangxiaobo
 * @QQ: 380757072
 * @Date: Craete at 2018/3/12 1:30
 * @Description:
 **/
public class Msg {

    private Integer msgId;
    private Integer userId;
    private String userNick;
    private String title;
    private String body;
    private String read;
    private Date createTime;
    private Date readTime;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public static Msg buildMsg(Integer userId, String title, String body){
        Msg msg = new Msg();
        msg.setUserId(userId);
        msg.setTitle(title);
        msg.setBody(body);
        return msg;
    }
}
