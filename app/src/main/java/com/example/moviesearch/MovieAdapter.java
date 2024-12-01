package com.example.moviesearch;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.context = context;
        this.movieList = movieList;
    }



    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_layout, parent, false);
        return new MovieViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder( @NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.titleTextView.setText(movie.getTitle());
        holder.yearTextView.setText(movie.getYear());
        Picasso.get().load(movie.getPoster()).into(holder.posterImageView);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MovieDetail.class);
            intent.putExtra("movieTitle", movie.getTitle());
            intent.putExtra("movieYear", movie.getYear());
            intent.putExtra("moviePoster", movie.getPoster());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView, yearTextView, movieDescription;
        public ImageView posterImageView;

        public MovieViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.movie_title);
            yearTextView = view.findViewById(R.id.movie_year);
            posterImageView = view.findViewById(R.id.movie_poster);
        }
    }
}
