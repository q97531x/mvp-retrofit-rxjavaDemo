package com.example.mvpdraggerretrofit.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 松鼠 on 16/4/20.
 */
public class BasNewsListBean implements Serializable {
    private String nid;
    private String title;
    private String author;
    private String oldUrl;
    private String areaId;
    private String content;
    private List<String> picList;
    private List<String> coverList;
    private String createTime;
    private int visitNum;
    private int hasPraise;
    private int praiseNum;
    private int commentNum;
    private int shareNum;
    private int hasCollect;
    private String isGeneral;
    private String nnid;
    private String state;
    private String showTime;
    private String shareUrl;
    private String uid;
    private String nick;
    private String avatar;
    private int age;
    private int gender;
    private int clickable = 0;

    public BasNewsListBean(){
        super();
        this.clickable = 0;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(int visitNum) {
        this.visitNum = visitNum;
    }

    public String getNnid() {
        return nnid;
    }

    public void setNnid(String nnid) {
        this.nnid = nnid;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }

    public String getOldUrl() {
        return oldUrl;
    }

    public void setOldUrl(String oldUrl) {
        this.oldUrl = oldUrl;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHasPraise() {
        return hasPraise;
    }

    public void setHasPraise(int hasPraise) {
        this.hasPraise = hasPraise;
    }

    public int getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(int praiseNum) {
        this.praiseNum = praiseNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getHasCollect() {
        return hasCollect;
    }

    public void setHasCollect(int hasCollect) {
        this.hasCollect = hasCollect;
    }

    public String getIsGeneral() {
        return isGeneral;
    }

    public void setIsGeneral(String isGeneral) {
        this.isGeneral = isGeneral;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public List<String> getCoverList() {
        return coverList;
    }

    public void setCoverList(List<String> coverList) {
        this.coverList = coverList;
    }

    public int getShareNum() {
        return shareNum;
    }

    public void setShareNum(int shareNum) {
        this.shareNum = shareNum;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getClickable() {
        return clickable;
    }

    public void setClickable(int clickable) {
        this.clickable = clickable;
    }

    @Override
    public String toString() {
        return "BasNewsListBean{" +
                "nid='" + nid + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", oldUrl='" + oldUrl + '\'' +
                ", areaId='" + areaId + '\'' +
                ", content='" + content + '\'' +
                ", picList=" + picList +
                ", coverList=" + coverList +
                ", createTime='" + createTime + '\'' +
                ", visitNum=" + visitNum +
                ", hasPraise=" + hasPraise +
                ", praiseNum=" + praiseNum +
                ", commentNum=" + commentNum +
                ", shareNum=" + shareNum +
                ", hasCollect=" + hasCollect +
                ", isGeneral='" + isGeneral + '\'' +
                ", nnid='" + nnid + '\'' +
                ", state='" + state + '\'' +
                ", showTime='" + showTime + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", uid='" + uid + '\'' +
                ", nick='" + nick + '\'' +
                ", avatar='" + avatar + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", clickable=" + clickable +
                '}';
    }
}
