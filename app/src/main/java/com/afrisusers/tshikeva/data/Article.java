package com.afrisusers.tshikeva.data;

import java.util.Date;

/**
 * Created by sugar on 9/28/2017.
 */

public class Article {

    int thumbnail;
    String mTitle;
    Date mPublishedDate;
    Boolean isPublished;
    String mBody;

    public Article() {

    }

    public Article(int thumbnail,String mTitle, Date mPublishedDate, Boolean isPublished, String mBody) {
        this.thumbnail = thumbnail;
        this.mTitle = mTitle;
        this.mPublishedDate = mPublishedDate;
        this.isPublished = isPublished;
        this.mBody = mBody;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmPublishedDate() {
        return mPublishedDate;
    }

    public void setmPublishedDate(Date mPublishedDate) {
        this.mPublishedDate = mPublishedDate;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }

    public String getmBody() {
        return mBody;
    }

    public void setmBody(String mBody) {
        this.mBody = mBody;
    }
}
