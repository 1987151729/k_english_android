package com.k.initial.english.mvp.model.entity;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 10:48
 */
public class SentenceEntity {

    private String id;
    private String query;
    private String speakUrl;
    private String translation;

    public SentenceEntity(
            String id,
            String query,
            String speakUrl,
            String translation
    ) {
        this.id = id;
        this.query = query;
        this.speakUrl = speakUrl;
        this.translation = translation;
    }

    // 获取属性值

    public String getID() {
        return this.id;
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
}
