package com.k.initial.english.mvp.model.entity;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 21/05/2018
 * Time: 21:52
 */
public class TranslateEntity {

    private String id;
    private String query;
    private String speakUrl;
    private String tSpeakUrl;
    private String translation;
    private String phonetic;
    private String ukPhonetic;
    private String usPhonetic;
    private String explains;

    public TranslateEntity(
            String id,
            String query,
            String speakUrl,
            String tSpeakUrl,
            String translation,
            String phonetic,
            String ukPhonetic,
            String usPhonetic,
            String explains
    ) {
        this.id = id;
        this.query = query;
        this.speakUrl = speakUrl;
        this.tSpeakUrl = tSpeakUrl;
        this.translation = translation;
        this.phonetic = phonetic;
        this.ukPhonetic = ukPhonetic;
        this.usPhonetic = usPhonetic;
        this.explains = explains;
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

    public String getTSpeakUrl() {
        return this.tSpeakUrl;
    }

    public String getTranslation() {
        return this.translation;
    }

    public String getPhonetic() {
        return this.phonetic;
    }

    public String getUkPhonetic() {
        return this.ukPhonetic;
    }

    public String getUsPhonetic() {
        return this.usPhonetic;
    }

    public String getExplains() {
        return this.explains;
    }
}
