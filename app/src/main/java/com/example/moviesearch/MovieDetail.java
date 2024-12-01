package com.example.moviesearch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        // Get data from the intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("movieTitle");
        String description = intent.getStringExtra("movieYear");
        String posterUrl = intent.getStringExtra("moviePoster");

        // Bind data to UI
        TextView titleTextView = findViewById(R.id.movie_title);
        TextView descriptionTextView = findViewById(R.id.movie_year);
        ImageView posterImageView = findViewById(R.id.movie_poster);

        titleTextView.setText(title);
        descriptionTextView.setText(description);
        Picasso.get().load(posterUrl).into(posterImageView);

        // Back button
        findViewById(R.id.back_button).setOnClickListener(v -> finish());
    }
}