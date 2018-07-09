package com.k.initial.english.mvp.model.entity;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 10:45
 */
public class MusicEntity {

    private String id;
    private String title;
    private String description;
    private String img;
    private String query;
    private String speakUrl;
    private String translation;
    // kz
    private boolean isExpanded;

    public MusicEntity(
            String id,
            String title,
            String description,
            String img,
            String query,
            String speakUrl,
            String translation
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.img = img;
        this.query = query;
        this.speakUrl = speakUrl;
        this.translation = translation;
    }

    // 获取属性值

    public String getID() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImg() {
        return this.img;
    }

    public String getQuery() {
        return this.query;
    }

    public String getSpeakUrl() {
        return this.speakUrl;
    }

    public String getTranslation() {
        return this.translation;
    }

    public boolean getIsExpanded() {
        return this.isExpanded;
    }

    public void setIsExpanded(boolean isExpanded) {
        this.isExpanded = isExpanded;
    }
}
