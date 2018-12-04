package uoit.ca.movieapp;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.*;

/* This is the interface between the MovieInterface and Api*/
public interface MovieInterface {

    //@GET("/find/{external_id}")
    //Call<MovieResponse> getMovieByName(@Path("external_id") @Query("api_key") String apiKey);


    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);
//    @GET("movie/{id}")
//    Call<Movie> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
