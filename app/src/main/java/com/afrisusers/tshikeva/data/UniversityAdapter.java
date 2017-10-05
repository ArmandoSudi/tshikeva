package com.afrisusers.tshikeva.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afrisusers.tshikeva.R;

import java.util.List;

/**
 * Created by sugar on 10/3/2017.
 */

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.MyViewHolder> {

    private static final String TAG = "UniversityAdapter";


    private List<University> mUniversities;
    private Context mContext;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView universityNameTV, universityYearTV, universityStateTV;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.thumbnail = (ImageView) itemView.findViewById(R.id.university_thumbnail_iv);
            this.universityNameTV = (TextView) itemView.findViewById(R.id.university_name_tv);
            this.universityYearTV = (TextView) itemView.findViewById(R.id.university_year_tv);
            this.universityStateTV = (TextView) itemView.findViewById(R.id.university_state_tv);
        }
    }

    public UniversityAdapter(Context mContext, List<University> mUniversities) {
        this.mUniversities = mUniversities;
        this.mContext = mContext;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        University university = mUniversities.get(position);
        
        holder.thumbnail.setImageResource(university.getThumbnail());
        holder.universityNameTV.setText(university.getmName());
        holder.universityYearTV.setText(university.getmFoundingYear().toString());
        holder.universityStateTV.setText(university.getmState());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View universityView = LayoutInflater.from(mContext).
                inflate(R.layout.university_item_layout, parent, false);

        return new MyViewHolder(universityView);
    }

    @Override
    public int getItemCount() {
        return mUniversities.size();
    }


}
