package com.k.initial.english.mvp.model.entity;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 10:50
 */
public class WordTypeEntity {

    private String name;
    private String description;
    private int type;
    private String img;

    public WordTypeEntity(
            String name,
            String description,
            int type,
            String img
    ) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.img = img;
    }

    // 获取属性值
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getType() {
        return this.type;
    }

    public String getImg() {
        return this.img;
    }
}
