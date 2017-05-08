package com.example.tommorow.entity;

/**
 * Video Entity
 */

public class Video {
    private String aName;
    private String aDesc;
    private int aIcon;

    public Video() {
    }

    public Video(String aName, String aDesc, int aIcon) {
        this.aName = aName;
        this.aDesc = aDesc;
        this.aIcon = aIcon;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaDesc() {
        return aDesc;
    }

    public void setaDesc(String aDesc) {
        this.aDesc = aDesc;
    }

    public int getaIcon() {
        return aIcon;
    }

    public void setaIcon(int aIcon) {
        this.aIcon = aIcon;
    }
}
