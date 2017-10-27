package com.afrisusers.tshikeva.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.afrisusers.tshikeva.R;

public class EvenementActivity extends AppCompatActivity implements View.OnClickListener{
    private Boolean isFabOpen = false;
    private FloatingActionButton fab0,fab1,fab2,fab3;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement);
        fab0 = (FloatingActionButton)findViewById(R.id.fabEvent_);
        fab1 = (FloatingActionButton)findViewById(R.id.fab1Event_insolite);
        fab2 = (FloatingActionButton)findViewById(R.id.fab2Event_promo);
        fab3 = (FloatingActionButton)findViewById(R.id.fab3Event_Univ);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        fab0.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) { int id = v.getId();
        switch (id){
            case R.id.fabEvent_:
                animateFAB();
                break;
            case R.id.fab1Event_insolite:
// coe un gros thug --Insolite
                Log.d("Message 1", "niko ku Fab 1");
                Intent intentEvent = new Intent(EvenementActivity.this, InsolitesActivity.class);
                startActivity(intentEvent);
                break;
            case R.id.fab2Event_promo:
//promo ici
                Log.d("Message 2", "apa ni Fab 2");
                Intent intentPromo = new Intent(EvenementActivity.this, PromotionActivity.class);
                startActivity(intentPromo);
                break;
            case R.id.fab3Event_Univ:
//the school
                Log.d("Message 2", "apa ni Fab 2");
                Intent intentUniv = new Intent(EvenementActivity.this, UniversityActivity.class);
                startActivity(intentUniv);
                break;
        }

    }

    public void animateFAB(){

        if(isFabOpen){

            fab0.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            isFabOpen = false;


        } else {

            fab0.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isFabOpen = true;


        }
    }
}
