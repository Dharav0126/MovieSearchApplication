package com.example.moviesearch;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieApi {

    public static void searchMovies(Context context, String query, Response.Listener<List<Movie>> listener, Response.ErrorListener errorListener) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = "https://www.omdbapi.com/?s=" + query + "&apikey=19e816f5";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray moviesArray = response.getJSONArray("Search");
                            List<Movie> movieList = new ArrayList<>();

                            for (int i = 0; i < moviesArray.length(); i++) {
                                JSONObject movieObject = moviesArray.getJSONObject(i);
                                Movie movie = new Movie();
                                movie.setTitle(movieObject.getString("Title"));
                                movie.setYear(movieObject.getString("Year"));
                                movie.setPoster(movieObject.getString("Poster"));
                                movieList.add(movie);
                            }

                            listener.onResponse(movieList);
                        } catch (JSONException e) {
                            errorListener.onErrorResponse(new VolleyError("JSON parsing error"));
                        }
                    }
                }, errorListener);

        requestQueue.add(jsonObjectRequest);
    }
}
