package com.example.movieinfoquerysystem.service;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class MovieService {
    //TMDB　APIを使って、動画の情報を得る　　BY ID
    public JsonObject getMovieById(int movieId) throws IOException {
        String apiKey = "012890aec9e0ffa92637410c7469ee28";
        String apiUrl = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        Gson gson = new Gson();
        JsonObject movieObject = gson.fromJson(reader, JsonObject.class);
        reader.close();

        return movieObject;
    }

    public JsonObject searchMoviesByTitle(String title) throws IOException {
        String apiKey = "012890aec9e0ffa92637410c7469ee28";
        String apiUrl = "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + URLEncoder.encode(title, "UTF-8");

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        Gson gson = new Gson();
        JsonObject searchResults = gson.fromJson(reader, JsonObject.class);
        reader.close();

        return searchResults;
    }

    public JsonObject searchMoviesByReleaseDate(String startDate, String endDate) throws IOException {
        String apiKey = "012890aec9e0ffa92637410c7469ee28";
        String apiUrl = "https://api.themoviedb.org/3/discover/movie?api_key=" + apiKey + "&primary_release_date.gte=" + startDate + "&primary_release_date.lte=" + endDate;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        Gson gson = new Gson();
        JsonObject searchResults = gson.fromJson(reader, JsonObject.class);
        reader.close();

        return searchResults;
    }
    public JsonObject searchMoviesByOverview(String overview) throws IOException {
        String apiKey = "012890aec9e0ffa92637410c7469ee28";
        String apiUrl = "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + URLEncoder.encode(overview, "UTF-8");

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        Gson gson = new Gson();
        JsonObject searchResults = gson.fromJson(reader, JsonObject.class);
        reader.close();

        return searchResults;
    }
    public JsonObject searchMoviesByKeyword(String keyword) throws IOException {
        String apiKey = "012890aec9e0ffa92637410c7469ee28";
        String apiUrl = "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + URLEncoder.encode(keyword, "UTF-8");

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        Gson gson = new Gson();
        JsonObject searchResults = gson.fromJson(reader, JsonObject.class);
        reader.close();

        return searchResults;
    }



}
