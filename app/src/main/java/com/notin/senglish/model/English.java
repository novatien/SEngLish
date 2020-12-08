package com.notin.senglish.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "english")
public class English {
    public English(int ID, String urlSound, String name, String type, String spell, String mean) {
        this.ID = ID;
        this.urlSound = urlSound;
        this.name = name;
        this.type = type;
        this.spell = spell;
        this.mean = mean;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID")
    @SerializedName("ID")
    private int ID;

    @ColumnInfo(name = "Url")
    @SerializedName("Url")
    @Expose
    private String urlSound;

    @ColumnInfo(name = "Word")
    @SerializedName("Word")
    @Expose
    private String name;

    @ColumnInfo(name = "Type")
    @SerializedName("Type")
    @Expose
    private String type;

    @ColumnInfo(name = "Pronounce")
    @SerializedName("Pronounce")
    @Expose
    private String spell;

    @ColumnInfo(name = "Meaning")
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
