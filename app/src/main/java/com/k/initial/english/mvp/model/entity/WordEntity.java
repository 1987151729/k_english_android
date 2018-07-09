package com.k.initial.english.mvp.model.entity;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 10:49
 */
public class WordEntity {

    private String id;
    private String query;
    private String speakUrl;
    private String translation;
    private String phonetic;
    private String ukPhonetic;
    private String usPhonetic;

    public WordEntity(
            String id,
            String query,
            String speakUrl,
            String translation,
            String phonetic,
            String ukPhonetic,
            String usPhonetic
    ) {
        this.id = id;
        this.query = query;
        this.speakUrl = speakUrl;
        this.translation = translation;
        this.phonetic = phonetic;
        this.ukPhonetic = ukPhonetic;
        this.usPhonetic = usPhonetic;
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

    public String getPhonetic() {
        return this.phonetic;
    }

    public String getUkPhonetic() {
        return this.ukPhonetic;
    }

    public String getUsPhonetic() {
        return this.usPhonetic;
    }
}
