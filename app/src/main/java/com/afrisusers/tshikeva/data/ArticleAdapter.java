package com.afrisusers.tshikeva.data;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afrisusers.tshikeva.ArticleDetailActivity;
import com.afrisusers.tshikeva.R;
import com.afrisusers.tshikeva.UniversityActivity;

import java.text.DateFormat;
import java.util.List;

/**
 * Created by sugar on 9/28/2017.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    List<Article> mArticles;
    Context mContext;
    DateFormat mDateFormat;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnailIv;
        TextView titleTV, publishedDateTV;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.thumbnailIv = (ImageView) itemView.findViewById(R.id.thumbnail_iv);
            this.titleTV = (TextView) itemView.findViewById(R.id.title_tv);
            this.publishedDateTV = (TextView) itemView.findViewById(R.id.published_date_tv);
        }
    }

    public ArticleAdapter(List<Article> mArticles, Context mContext) {
        this.mArticles = mArticles;
        this.mContext = mContext;
        mDateFormat = DateFormat.getDateInstance();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Article article = mArticles.get(position);

        holder.thumbnailIv.setImageResource(article.getThumbnail());
        holder.titleTV.setText(article.getmTitle());
        holder.publishedDateTV.setText(mDateFormat.format(article.getmPublishedDate()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ArticleDetailActivity.class);
                intent.putExtra("article",article);
                mContext.startActivity(intent);
                Toast.makeText(mContext, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View articleView = LayoutInflater.from(mContext).
                inflate(R.layout.article_item_layout, parent, false);

        return new MyViewHolder(articleView);
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

}
