package com.afrisusers.tshikeva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.afrisusers.tshikeva.data.Article;

import org.w3c.dom.Text;

public class ArticleDetailActivity extends AppCompatActivity {

    String TAG = ArticleDetailActivity.class.getSimpleName();

    ImageView thumbnail;
    TextView articleTitleTV, articleBodyTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        initScreen();

        Intent intent = getIntent();
        // Get the article which has been selected
        Article article = intent.getParcelableExtra("article");

        thumbnail.setImageResource(article.getThumbnail());
        articleTitleTV.setText(article.getmTitle());
        articleBodyTV.setText(article.getmBody());
    }

    public void initScreen() {
        thumbnail = (ImageView) findViewById(R.id.article_thumbnail);
        articleTitleTV = (TextView) findViewById(R.id.article_title_tv);
        articleBodyTV = (TextView) findViewById(R.id.article_body_tv);
    }
}
