package uoit.ca.movieapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* This is the instantiation of Retrofit2 used to communicate with TMDb */

public class TMDb {
    public static final String USED_URL = "http://api.themoviedb.org/3/";
    public static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(USED_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }

}
