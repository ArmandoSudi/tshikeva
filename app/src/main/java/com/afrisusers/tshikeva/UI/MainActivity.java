package com.afrisusers.tshikeva.UI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.afrisusers.tshikeva.R;
import com.afrisusers.tshikeva.data.Article;
import com.afrisusers.tshikeva.data.ArticleAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String LOG_TAG = MainActivity.class.getSimpleName();

    RecyclerView mArticlesRV;
    LinearLayoutManager mLinearLayout;
    ArticleAdapter mArticleAdapter;
    List<Article> mArticles = new ArrayList<Article>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initScreen();

        mArticleAdapter = new ArticleAdapter(mArticles, this);
        mArticlesRV.setAdapter(mArticleAdapter);
        mArticlesRV.setHasFixedSize(true);
        mArticlesRV.setLayoutManager(mLinearLayout);

        populateWithDemoData(mArticles);
        mArticleAdapter.notifyDataSetChanged();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "universities", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//                Intent intent = new Intent(MainActivity.this, UniversityActivity.class);
//                startActivity(intent);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tchikeva.com/a-propos/"));
                startActivity(browserIntent);
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /**
     * Initial screen setup
     */
    public void initScreen() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mArticlesRV = (RecyclerView) findViewById(R.id.articles_rv);

        mLinearLayout = new LinearLayoutManager(this);
    }

    public void populateWithDemoData(List<Article> articles){

        articles.add(new Article(R.drawable.min_esu, "Min/ESU : Le ministre MBIKAYI lance officiellement la bourse de solidarité.",
                new Date(2017, 10, 13), true, this.getResources().getString(R.string.min_esu)));
        articles.add(new Article(R.drawable.kenzy, "Kenzy Mawanda explique son travail de fond en comble",
                new Date(2017, 10, 9), true, this.getResources().getString(R.string.keny)));
        articles.add(new Article(R.drawable.inedit_kenzy, "Inédit : Kenzy Mawanda, auteur du Tfc qui a bougé la toile se dévoile.",
                new Date(2017, 10, 9), true, this.getResources().getString(R.string.inedit_kenzy)));
        articles.add(new Article(R.drawable.echo, "Amazon Echo, your house AI powered Assisatant",
                new Date(2017, 9, 1), true, this.getResources().getString(R.string.article_amazon)));
        articles.add(new Article(R.drawable.bentley, "The new Bentley Continental GT",
                new Date(2017, 9, 2), true, this.getResources().getString(R.string.paragraph_two)));
        articles.add(new Article(R.drawable.messi, "The not so little man of barcelona",
                new Date(2017, 9, 3), true, this.getResources().getString(R.string.article_messi)));
        articles.add(new Article(R.drawable.trump, "Who is Donald Trmp ?",
                new Date(2017, 9, 4), true, this.getResources().getString(R.string.article_trump)));
        articles.add(new Article(R.drawable.s8, "Samsung galaxy s8, the most photogenic phone",
                new Date(2017, 9, 5), true, this.getResources().getString(R.string.article_samsung)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_evenement, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_universites) {
//
//            Intent intentUniv = new Intent(MainActivity.this, UniversityActivity.class);
//                startActivity(intentUniv);
//            return true;
//        }
//        //noinspection SimplifiableIfStatement
//        else if (id == R.id.action_evenement) {
//
//            Intent intentUniv = new Intent(MainActivity.this, EvenementActivity.class);
//            startActivity(intentUniv);
//            return true;
//        }
//        else if (id == R.id.action_insolite) {
//
//            Intent intentInsolite = new Intent(MainActivity.this, InsolitesActivity.class);
//            startActivity(intentInsolite);
//            return true;
//        }
//        else if (id == R.id.action_promotion) {
//
//            Intent intentPromo = new Intent(MainActivity.this, PromotionActivity.class);
//            startActivity(intentPromo);
//            return true;
//        }
//        else if (id == R.id.action_contact) {
//
//            Intent intentContact = new Intent(MainActivity.this, ContactActivity.class);
//            startActivity(intentContact);
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_evenement) {Intent intentUniv = new Intent(MainActivity.this, EvenementActivity.class);startActivity(intentUniv);
            // Handle the camera action
        } else if (id == R.id.nav_promo) { Intent intentPromo = new Intent(MainActivity.this, PromotionActivity.class);startActivity(intentPromo);

        } else if (id == R.id.nav_insolite) { Intent intentInsolite = new Intent(MainActivity.this, InsolitesActivity.class);startActivity(intentInsolite);

        } else if (id == R.id.nav_univ) {
            Intent intentUniv = new Intent(MainActivity.this, UniversityActivity.class);startActivity(intentUniv);

        } else if (id == R.id.nav_contact) { Intent intentContact = new Intent(MainActivity.this, ContactActivity.class);startActivity(intentContact);

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
