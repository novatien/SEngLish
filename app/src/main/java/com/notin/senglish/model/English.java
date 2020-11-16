package com.notin.senglish.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class English {

    @SerializedName("Url")
    @Expose
    private String urlSound;

    @SerializedName("Word")
    @Expose
    private String name;

    @SerializedName("Type")
    @Expose
    private String type;

    @SerializedName("Pronounce")
    @Expose
    private String spell;

    @SerializedName("Meaning")
    @Expose
    private String mean;

    public String getUrlSound() {
        return urlSound;
    }

    public void setUrlSound(String urlSound) {
        this.urlSound = urlSound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
}
