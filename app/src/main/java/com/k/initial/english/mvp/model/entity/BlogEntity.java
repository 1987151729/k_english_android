package com.k.initial.english.mvp.model.entity;

import com.k.initial.english.mvp.model.bean.UserInfo0;

import java.util.Date;

/**
 * Created by Android Studio.
 * User: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 23/06/2018
 * Time: 21:14
 */
public class BlogEntity {

    private UserInfo0 user;
    private String id;
    private String userID;
    private String content;
    private String imgs;
    private long checkNum;
    private long likeNum;
    private long commentNum;
    private Date createdAt;
    // kz
    private boolean isExpanded;

    public BlogEntity(
            UserInfo0 user,
            String id,
            String userID,
            String content,
            String imgs,
            long checkNum,
            long likeNum,
            long commentNum,
            Date createdAt
    ) {
        this.user = user;
        this.id = id;
        this.userID = userID;
        this.content = content;
        this.imgs = imgs;
        this.checkNum = checkNum;
        this.likeNum = likeNum;
        this.commentNum = commentNum;
        this.createdAt = createdAt;
    }

    public UserInfo0 getUser() {
        return this.user;
    }

    public String getID() {
        return this.id;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getContent() {
        return this.content;
    }

    public String getImgs() {
        return this.imgs;
    }

    public long getCheckNum() {
        return this.checkNum;
    }

    public long getLikeNum() {
        return this.likeNum;
    }

    public long getCommentNum() {
        return this.commentNum;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setLikeNum(long likeNum) {
        this.likeNum = likeNum;
    }

    public void setCommentNum(long commentNum) {
        this.commentNum = commentNum;
    }

    public boolean getIsExpanded() {
        return this.isExpanded;
    }

    public void setIsExpanded(boolean isExpanded) {
        this.isExpanded = isExpanded;
    }
}
