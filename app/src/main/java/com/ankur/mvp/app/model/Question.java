package com.ankur.mvp.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Ankur Jain (ankurjainips@gmail.com)
 */
public class Question {

    @SerializedName("question_id")
    private long id;

    @SerializedName("owner")
    private User user;

    @SerializedName("creation_date")
    private long creationDate;

    @SerializedName("title")
    private String title;

    @SerializedName("link")
    private String link;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }
}
