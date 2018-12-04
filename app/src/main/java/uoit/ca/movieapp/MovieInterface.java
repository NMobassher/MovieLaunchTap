package uoit.ca.movieapp;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.*;



/* This is the interface between the MovieInterface and Api*/
public interface MovieInterface {

    String turtle = "turtle";
    //@GET("/find/{external_id}")
    //Call<MovieResponse> getMovieByName(@Path("external_id") @Query("api_key") String apiKey);


    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);
    @GET("/search/movie?api_key=cf5752d327722bc19692de615b556a6f&language=en-US&query=terminator&page=1&include_adult=false")
    Call<MovieResponse> search(  @Query("api_key") String apiKey);
//    @GET("movie/{id}")
//    Call<Movie> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
