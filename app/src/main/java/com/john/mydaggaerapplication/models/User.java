package com.john.mydaggaerapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private int id;


    @SerializedName("username")
    @Expose
    private String username;


    @SerializedName("website")
    @Expose
    private String website;


    @SerializedName("email")
    @Expose
    private String email;

    public User(int id, String username, String email, String website) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.website = website;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


}
