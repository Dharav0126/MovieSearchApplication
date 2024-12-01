package com.example.moviesearch;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesearch.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    ImageView poster;
    TextView title;
    TextView year;
    TextView plot;

    public MovieViewHolder(@NonNull View movielayout) {
        super(movielayout);
        poster = movielayout.findViewById(R.id.movie_poster);
        title = movielayout.findViewById(R.id.movie_title);
        year = movielayout.findViewById(R.id.movie_year);
    }
}