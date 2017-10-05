package com.afrisusers.tshikeva.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by sugar on 9/28/2017.
 */

public class Article implements Parcelable{

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

    protected Article(Parcel in) {
        thumbnail = in.readInt();
        mTitle = in.readString();
        mBody = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(thumbnail);
        dest.writeString(mTitle);
        dest.writeString(mBody);
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
