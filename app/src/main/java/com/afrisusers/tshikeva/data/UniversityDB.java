package com.afrisusers.tshikeva.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.afrisusers.tshikeva.data.helper.UniversityBaseSQLite;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Created by Andymub on 02/11/2017.
 */

public class UniversityDB {

    /*
    * la classe qui servira à gérer les dnnées (insertion, récupération,uppression ..)de la table
    * */
    private static final int Version =1;
    private static final String  Name_DB= "Tchikeva.db";
    private static final String Table_Univ="Universities";
    private static final String Col_Id="ID";
    private static final String Col_Name ="Univ_name";
    private static final String Col_UnivImage ="Univ_image";
    private static final String Col_UnivLogo ="Univ_logo";
    private static final String Col_Description ="Univ_description";
    private static final String Col_mFac="Faculty"; /*todo moi je propose que on enregistre les fac mu DB avec un separateur coe ça on va juste recupErE une string qu'on mettra dans notre tableau fac ou Dep */
    private static final String  Col_mDepartment="Department";//
    private static final String Col_FoundingYear="FoundingYear";
    private static final String Col_State="Univ_State";

    private SQLiteDatabase db;
    private UniversityBaseSQLite universityBaseSQLite;

    public UniversityDB (Context context){
        universityBaseSQLite=new UniversityBaseSQLite(context,Name_DB,null,Version);
        Log.i("Z","universityBaseSQLite");

    }

    public UniversityDB() {
    }


    public void openForWrite(){
        db = universityBaseSQLite.getWritableDatabase();
        //dans le cas oU on a besoin  d'Ecrire dans la bd umu njo
    }
    public void openForRead (){
         db = universityBaseSQLite.getReadableDatabase();
        //dans le cas oU on a besoin  de lire dans la bd umu njo
    }
    public void close()
    {
        db.close();
    }
    public SQLiteDatabase getDb(){
        return db;
    }

    //si on veut inserer des donnEes muDB
    public void insertUniv(University university)
    {

//        /*TO BE DELETED*/
//
//
//        //Open connection to write data
//        db = universityBaseSQLite.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("Age", "78");
//        values.put("eMAIL","msdlmldsfkmdsf");
//        values.put("Name", "andy");
//
//        // Inserting Row
//        long student_Id = db.insert("student", null, values);
//        Log.i("TEST","Test insert");
//        db.close(); // Closing database connection
//        //return (int) student_Id;
//
//
//        /**/
        db = universityBaseSQLite.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_Name,university.getmName());
        contentValues.put(Col_UnivImage,university.getThumbnail());
        contentValues.put(Col_UnivLogo,university.getmLogo());
        contentValues.put(Col_Description,university.getMyDescription());
        contentValues.put(Col_mFac, String.valueOf(university.getmFac()));
       // contentValues.put(Col_mDepartment, String.valueOf(university.getmDepartment()));
        contentValues.put(Col_FoundingYear, university.getmFoundingYear());
       // contentValues.put(Col_State, university.getmState());
        db.insert(Table_Univ,null,contentValues);
        db.close();
        Log.i("z","Insersion");
    }
    public void delete (String sqlTable){
       // db.de
    }
//    public University university(University university)
//    {
//          A bosser
//    }
    public ArrayList <University> getAllUniversity (String nameKey) {
        Cursor cursor = db.query(Table_Univ, new String[]{Col_Name, Col_UnivImage, Col_UnivLogo, Col_Description,Col_mFac,Col_mDepartment,Col_FoundingYear,Col_State}, null, null, null, null, Col_Name);
        int i;
        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        }
        String [] facTable =getListOfFacOrDep(cursor.getString(4));
        String [] DepTable=getListOfFacOrDep(cursor.getString(5));
        ArrayList<University> universitiesList =new ArrayList<>();
        while (cursor.moveToNext()){
            University university =new University();
            university.setmName(cursor.getString(0));
            //university.setThumbnail  todo get image from the BDLITE
            university.setThumbnail(1010101);

            //university.IMAGE  todo get LOGO from the BDLITE
            university.setmLogo(10101010);


            university.setmDescription(cursor.getString(3));
            university.setmFac(facTable);
            university.setmDepartment(DepTable);
            university.setmFoundingYear(cursor.getString(6));
            university.setmState(cursor.getString(7));
        }
        cursor.close();
        return  universitiesList;
    }
    public String [] getListOfFacOrDep (String myStringWithSeparator)
    {
        return  myStringWithSeparator.split("-",-1);//todo ne pas oublier que les dep ou fac sont stockés ss formet une seule String et donc y'a un separateur

    }

    public Cursor  getUnivList() {
        //Open connection to read only
        University university=new University();
        SQLiteDatabase db = universityBaseSQLite.getReadableDatabase();
        String selectQuery =  "SELECT * FROM Universities";


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;


    }

}

