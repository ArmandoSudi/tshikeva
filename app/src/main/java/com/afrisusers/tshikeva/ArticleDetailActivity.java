package com.afrisusers.tshikeva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.afrisusers.tshikeva.data.Article;

public class ArticleDetailActivity extends AppCompatActivity {

    String TAG = ArticleDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        Intent intent = getIntent();
        // Get the article which has been selected
        Article article = intent.getParcelableExtra("article");

        Log.e(TAG, "onCreate: " + article.getmTitle());
    }
}
