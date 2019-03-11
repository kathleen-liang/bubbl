package com.example.bubblr;

public class BubbleTea {

    // instance fields
    private String name;
    private String homestore;
    private String bio;
    private String profilePic;


    // constructors

    public BubbleTea() {
        name = "";
        homestore = "";
        bio = "";
        profilePic = "";
    }

    public BubbleTea(String name, String homestore, String bio, String image) {
        this.name = name;
        this.homestore = homestore;
        this.bio = bio;
        this.profilePic = image;
    }


    // accessors

    public String getName() {
        return this.name;
    }

    public String getHomestore() {
        return this.homestore;
    }

    public String getBio() {
        return this.bio;
    }

    public String getProfilePic() {
        return this.profilePic;
    }

    // modifiers

    public void setName(String name) {
        this.name = name;
    }

    public void setHomestore(String store) {
        this.homestore = store;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setProfilePic(String fileName) {
        this.profilePic = fileName;
    }

}

