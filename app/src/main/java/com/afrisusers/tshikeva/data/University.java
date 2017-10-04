package com.afrisusers.tshikeva.data;

/**
 * Created by sugar on 10/3/2017.
 */

public class University {

    String mName;
    String mState;
    String mFoundingYear;
    int mRating;
    String mMoto;
    String mDescription;

    public University(String mName, String mState, String mFoundingYear, int mRating) {
        this.mName = mName;
        this.mState = mState;
        this.mFoundingYear = mFoundingYear;
        this.mRating = mRating;
    }

    public University(String mName, String mState, String mFoundingYear, int mRating, String mMoto, String mDescription) {
        this.mName = mName;
        this.mState = mState;
        this.mFoundingYear = mFoundingYear;
        this.mRating = mRating;
        this.mMoto = mMoto;
        this.mDescription = mDescription;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public String getmFoundingYear() {
        return mFoundingYear;
    }

    public void setmFoundingYear(String mFoundingYear) {
        this.mFoundingYear = mFoundingYear;
    }

    public int getmRating() {
        return mRating;
    }

    public void setmRating(int mRating) {
        this.mRating = mRating;
    }

    public String getmMoto() {
        return mMoto;
    }

    public void setmMoto(String mMoto) {
        this.mMoto = mMoto;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
