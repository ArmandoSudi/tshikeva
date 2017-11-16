package com.afrisusers.tshikeva.data;

/**
 * Created by sugar on 10/3/2017.
 */

public class University {



    public int getmLogo() {
        return mLogo;
    }

    public void setmLogo(int mLogo) {
        this.mLogo = mLogo;
    }
    int thumbnail;//image univ
    int mLogo;//image univ  /// TODO: 06/11/2017  implementer logo dans l'objet Univ
    String mName;// nom univ
    String mState;//ville univ
    String mFoundingYear;//voilA
    int mRating;//
    String mMoto; //wtf
    String mDescription,myDescription;
    String [] mFac,mDepartment;//fac et departement
    //on aura besoin d'une variable contenant la liste de dEPARTEMENT ET une autre pr la liste des facultes --COMPRENDE?
    //le but est de pouvoir PERMETTRE A l'utilisateur de faire de recherche su la fac voulue dans l'activitE Univ et de pouvoir avoir la liste de univ ayant
    //la fac ou le dep voulu

    public University(int thumbnail,int mLogo, String mName, String mState , String mFoundingYear, int mRating,String [] mFac,String[] mDepartment, String myDescription) {
        this.thumbnail = thumbnail;
        this.mLogo=mLogo;
        this.mName = mName;
        this.mState = mState;
        this.mFoundingYear = mFoundingYear;
        this.mRating = mRating;
        this.mFac = mFac;
        this.mDepartment = mDepartment;
        this.myDescription=myDescription;

    }

    public University() {

    }

    public String getMyDescription() {
        return myDescription;
    }

    public void setMyDescription(String myDescription) {
        this.myDescription = myDescription;
    }

    public String[] getmFac() {
        return mFac;
    }

    public void setmFac(String[] mFac) {
        this.mFac = mFac;
    }

    public String[] getmDepartment() {
        return mDepartment;
    }

    public void setmDepartment(String[] mDepartment) {
        this.mDepartment = mDepartment;
    }

    public University(String mName, String mState, String mFoundingYear, int mRating, String mMoto, String mDescription) {
        this.mName = mName;
        this.mState = mState;
        this.mFoundingYear = mFoundingYear;
        this.mRating = mRating;
        this.mMoto = mMoto;
        this.mDescription = mDescription;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
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
