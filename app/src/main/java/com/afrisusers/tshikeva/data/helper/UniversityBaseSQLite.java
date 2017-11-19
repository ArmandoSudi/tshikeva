package com.afrisusers.tshikeva.data.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Andymub on 02/11/2017.
 */

public class UniversityBaseSQLite extends SQLiteOpenHelper {
    private static final String Table_Univ="Universities";
    private static final String Col_Id="ID";
    private static final String Col_Name ="Univ_name";
    private static final String Col_UnivImage ="Univ_image";
    private static final String Col_UnivLogo ="Univ_logo";
    private static final String Col_Description ="Univ_description";
    private static final String Col_mFac="Faculty"; /*todo moi je propose que on enregistre les fac mu DB avec un separateur coe ça on va juste recupErE une string qu'on mettra dans notre tableau fac ou Dep */
    private static final String Col_mDepartment="Departement";//
    private static final String Col_FoundingYear="FoundingYear";
    private static final String Col_State="Univ_State";
    private SQLiteDatabase db;

    //allez , creons cette table de m...
    private static final String CreateBDD="CREATE TABLE "+Table_Univ + " ( "
            +Col_Id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +Col_Name + " TEXT NOT NULL,"+Col_UnivImage + " TEXT NOT NULL,"
            +Col_UnivLogo + " TEXT NOT NULL,"
            +Col_Description + " TEXT NOT NULL, "
            +Col_mFac + " TEXT,"
            +Col_mDepartment + " TEXT,"
            +Col_FoundingYear + " TEXT,"
            +Col_State + " TEXT )";


    //    int thumbnail;//image univ
//    String mName;// nom univ
//    String mState;//ville univ
//    String mFoundingYear;//voilA
    public UniversityBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("Z","Create DB");
        try {
            db.execSQL(CreateBDD);
            Log.i("Z","CreatING DB");
        }
        catch (Exception e){
            Log.i("EXCEPTION",e.getMessage());
        }
        Log.i("Z","Create DB done");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //ici armando , on va gérer les montées de version de notre base de données ...
        //donc si tu change la version do
        //db.execSQL("DROP TABLE" + CreateBDD);
        //OonCreate(db)
        //voila

    }
}
