package com.afrisusers.tshikeva;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.afrisusers.tshikeva.data.Article;
import com.afrisusers.tshikeva.data.ArticleAdapter;
import com.afrisusers.tshikeva.data.University;
import com.afrisusers.tshikeva.data.UniversityAdapter;

import java.util.ArrayList;
import java.util.List;

public class UniversityActivity extends AppCompatActivity {

    private static final String TAG = "UniversityActivity";

    RecyclerView mUniversityRV;
    UniversityAdapter mUniversityAdapter;
    List<University> mUniversities = new ArrayList<University>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        initScreen();

        loadDemoData();

        mUniversityAdapter = new UniversityAdapter(this, mUniversities);
        mUniversityRV.setAdapter(mUniversityAdapter);
        mUniversityRV.setHasFixedSize(true);
        mUniversityRV.setLayoutManager(new LinearLayoutManager(this));

        mUniversityAdapter.notifyDataSetChanged();
    }

    public void initScreen() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUniversityRV = (RecyclerView) findViewById(R.id.university_rv);
    }

    public void loadDemoData() {

        mUniversities.add(new University(R.drawable.unikin, "UNIKIN", "Kinshasa", "1910", 3434));
        mUniversities.add(new University(R.drawable.unilu, "UNILU", "Lubumbashi", "1945", 3434));
        mUniversities.add(new University(R.drawable.unikis, "UNIKIS", "Kisangani", "1944", 3434));
        mUniversities.add(new University(R.drawable.unikin, "UCB", "Bukavu", "1975", 3434));
        mUniversities.add(new University(R.drawable.unilu, "ULPGL", "Goma", "1977", 3434));
        mUniversities.add(new University(R.drawable.unikis, "UPC", "Kinshasa", "1966", 3434));


    }
}
