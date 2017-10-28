package com.afrisusers.tshikeva.UI;

import android.support.design.widget.FloatingActionButton;
import android.view.MenuItem;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.afrisusers.tshikeva.R;

public class InsolitesActivity extends AppCompatActivity implements View.OnClickListener{
    private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2,fab3;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insolite);

        initializeScreen();
    }

    public void initializeScreen() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            case android.R.id.home:
                this.finish();
                return true;
            default:
                return true;
//            setContentView(R.layout.activity_insolite);
//            fab = (FloatingActionButton) findViewById(R.id.fab);
//            fab1 = (FloatingActionButton) findViewById(R.id.fab1);
//            fab2 = (FloatingActionButton) findViewById(R.id.fab2);
//            fab3 = (FloatingActionButton) findViewById(R.id.fab3);
//            fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
//            fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
//            rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
//            rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);
//            fab.setOnClickListener(this);
//            fab1.setOnClickListener(this);
//            fab2.setOnClickListener(this);
//            fab3.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab:

                animateFAB();
                break;
            case R.id.fab1:
// coe un gros thug --Evenement
                Log.d("Message 1", "niko ku Fab 1");
                Intent intentEvent = new Intent(InsolitesActivity.this, EvenementActivity.class);
                startActivity(intentEvent);
                break;
            case R.id.fab2:
//promo ici
                Log.d("Message 2", "apa ni Fab 2");
                Intent intentPromo = new Intent(InsolitesActivity.this, PromotionActivity.class);
               startActivity(intentPromo);
                break;
            case R.id.fab3:
//the school
                Log.d("Message 2", "apa ni Fab 2");
                Intent intentUniv = new Intent(InsolitesActivity.this, UniversityActivity.class);
                startActivity(intentUniv);
                break;
        }

    }

    public void animateFAB(){

        if(isFabOpen){

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            isFabOpen = false;
            Log.d("Raj", "close");

        } else {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isFabOpen = true;
            Log.d("Raj","open");
        }
    }
}
