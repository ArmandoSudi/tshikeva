package com.afrisusers.tshikeva;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.afrisusers.tshikeva.data.Article;
import com.afrisusers.tshikeva.data.ArticleAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String LOG_TAG = MainActivity.class.getSimpleName();

    RecyclerView mArticlesRV;
    ArticleAdapter mArticleAdapter;
    List<Article> mArticles = new ArrayList<Article>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initScreen();

        mArticleAdapter = new ArticleAdapter(mArticles, this);
        mArticlesRV.setAdapter(mArticleAdapter);
        mArticlesRV.setHasFixedSize(true);
        mArticlesRV.setLayoutManager(new LinearLayoutManager(this));

        populateWithDemoData(mArticles);
        mArticleAdapter.notifyDataSetChanged();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "universities", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, UniversityActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Initial screen setup
     */
    public void initScreen() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mArticlesRV = (RecyclerView) findViewById(R.id.articles_rv);
    }

    public void populateWithDemoData(List<Article> articles){

        articles.add(new Article(R.drawable.echo, "Twitter takes its turn in the Russian probe spotlight",
                new Date(2017, 9, 1), true, this.getResources().getString(R.string.paragraph_one)));
        articles.add(new Article(R.drawable.bentley, "North Korea again denies Otto Warmbier tortured",
                new Date(2017, 9, 2), true, this.getResources().getString(R.string.paragraph_two)));
        articles.add(new Article(R.drawable.messi, "Man arrested in Colorado may be suspect in unsolved murder of Indiana teens, police say",
                new Date(2017, 9, 3), true, this.getResources().getString(R.string.paragraph_three)));
        articles.add(new Article(R.drawable.trump, "Are there now too many Amazon Echo devices?",
                new Date(2017, 9, 4), true, this.getResources().getString(R.string.paragraph_four)));
        articles.add(new Article(R.drawable.s8, "Arsenal and Real Madrid join Liverpool and Tottenham in chase for Pulisic",
                new Date(2017, 9, 5), true, this.getResources().getString(R.string.paragraph_five)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
