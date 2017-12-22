package com.afrisusers.tshikeva.UI;

import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.afrisusers.tshikeva.R;
import com.afrisusers.tshikeva.data.Article;
import com.afrisusers.tshikeva.data.ArticleAdapter;
import com.afrisusers.tshikeva.data.University;
import com.afrisusers.tshikeva.data.UniversityAdapter;
import com.afrisusers.tshikeva.data.UniversityDB;

import java.util.ArrayList;
import java.util.List;

public class UniversityActivity extends AppCompatActivity {
    Cursor cursor;
    UniversityDB universityDB;

    // Search EditText
    EditText inputSearch;
    private static final String TAG = "UniversityActivity";

    RecyclerView mUniversityRV;
    UniversityAdapter mUniversityAdapter;
    DividerItemDecoration mDividerItemDecoration;
    LinearLayoutManager mLinearLayout;
    List<University> mUniversities = new ArrayList<University>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        inputSearch = (EditText) findViewById(R.id.inputSearch);

        //TEST TO INSERT DATA IN db
        University university=new University(14,12,"UCB","BKV","1969",4, new String[]{"DCP", "DUP", "DKP"},
                new String[]{"DCP", "UCK", "UPL"},"bonne univ");



        //// TODO: 06/11/2017  imma create the dblite over here but soon it shoulb be created when the application run for the first time

        //GET UNIV
        ArrayList <University> ArrayUniversity1 =new ArrayList<>();

        UniversityDB universityDB=new UniversityDB(this);
        universityDB.openForWrite();
    universityDB.insertUniv(university);
        UniversityDB universityDB1=new UniversityDB(this);
        universityDB1.openForRead();
        //universityDB1.getAllUniversity("--");
        initScreen();

        loadDemoData();

        mUniversityAdapter = new UniversityAdapter(this, mUniversities);
        mUniversityRV.setAdapter(mUniversityAdapter);
        mUniversityRV.setHasFixedSize(true);
        mUniversityRV.setLayoutManager(mLinearLayout);
        mUniversityRV.addItemDecoration(mDividerItemDecoration);

        mUniversityAdapter.notifyDataSetChanged();

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                //
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void initScreen() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mUniversityRV = (RecyclerView) findViewById(R.id.university_rv);

        mLinearLayout = new LinearLayoutManager(this);
        mDividerItemDecoration = new DividerItemDecoration(this,
                mLinearLayout.getOrientation());
    }



    public void loadDemoData() {


        /*
        * 1.retrieve data from sqlliteDB from univesity fields
        * 2.put each in a object University
        * 3.add that class to my list "mUniversities" each time it's full of dada
        * */
        /* just for testing
        fac and dep
        */
        String []Fac = new String[] {"Droit","Econmie","Médecine"};
        String []Dep = new String[] {"Doit Eco","ECO RURAL","Méd"};
        String mDescription ="God UNiv";

        mUniversities.add(new University(R.drawable.unikin,R.mipmap.ic_launcher,"UNIKIN", "Kinshasa", "1910", 3434,Fac,Dep,mDescription));
        mUniversities.add(new University(R.drawable.unilu, R.mipmap.ic_launcher,"UNILU", "Lubumbashi", "1945", 3434,Fac,Dep,mDescription));
        mUniversities.add(new University(R.drawable.unikis, R.mipmap.ic_launcher,"UNIKIS", "Kisangani", "1944",3434,Fac,Dep,mDescription));
        mUniversities.add(new University(R.drawable.unikin, R.mipmap.ic_launcher,"UCB", "Bukavu", "1975", 3434,Fac,Dep,mDescription));
        mUniversities.add(new University(R.drawable.unilu, R.mipmap.ic_launcher,"ULPGL", "Goma", "1977", 3434,Fac,Dep,mDescription));
        mUniversities.add(new University(R.drawable.unikis, R.mipmap.ic_launcher,"UPC", "Kinshasa", "1966", 3434,Fac,Dep,mDescription));


    }
    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_search_university, menu);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();
            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String s) {
                    universityDB =new UniversityDB();
                    Log.d(TAG, "onQueryTextSubmit ");
                    cursor=universityDB.getUnivList();
                    if (cursor==null){
                        Toast.makeText(UniversityActivity.this,"Aucune Université trouvée!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(UniversityActivity.this, cursor.getCount() + "  Université(s) trouvée(s)!",Toast.LENGTH_LONG).show();
                    }
                   // customAdapter.swapCursor(cursor);
                        int u=0;
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    Log.d(TAG, "onQueryTextChange ");
                    //cursor=studentRepo.getStudentListByKeyword(s);
                    if (cursor!=null){
                      //  customAdapter.swapCursor(cursor);
                    }
                    return false;
                }

            });

        }

        return true;

    }

}
