package uoit.ca.movieapp;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;


public class MovieActivity extends AppCompatActivity {


    /* */

    public static String globalList = "To watch: \n ";

    /* Fields */


    private final static String API_KEY = "cf5752d327722bc19692de615b556a6f";

    public static String title;
    public static String year;
    SimpleCursorAdapter mAdapter;


    //static final String[] PROJECTION = new String[] {title, year};


    ListView list;
    List<ListData> listData;

    String popularMoviesURL;
    ProgressBar mProgressBar;
    ArrayList<MyMovie> myMovieList;
    ListData data;
    List<Movie> movies;


    ArrayList<MyMovie> mPopularList;
    ListView listView;
    String[] test;
    MovieInterface movieInterface;

    /* Refined */

    public List<Movie> films;
    public Context context;

    /* URL of website data is from*/
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        listData = new ArrayList<ListData>();


        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);


        /* Initialize variables*/


//        for (int i = 0; i < movies.size(); i++) {
//            testList.add(movies.get(i).getTitle());
//
//        }
//
        /* Warn user if key is empty*/

        if (API_KEY.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Error with API key. Unintended behavior may occur", Toast.LENGTH_LONG).show();

        }

        /* Code to get movies*/


        movieInterface = TMDb.getClient().create(MovieInterface.class);

        Call<MovieResponse> call = movieInterface.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, retrofit2.Response<MovieResponse> response) {
                movies = response.body().getResults();

               // Toast.makeText(getApplicationContext(), "Got data", Toast.LENGTH_LONG).show();

                for (int i = 0; i < movies.size(); i++) {


                    data = new ListData();
                    data.setTitle(movies.get(i).getTitle());
                    data.setSubtitle(movies.get(i).getReleaseDate());
                    data.setDebugPath(movies.get(i).getPosterPath());
                    globalList.concat(movies.get(i).getTitle() + "\n");

                    try {


                        String url = "https://image.tmdb.org/t/p/w92";
                        String meme = movies.get(i).getPosterPath();
                        url.concat(meme);
                        URL address = new URL(url);



                    } catch (Exception e) {
                        e.printStackTrace();
                    }





                    listData.add(data);





                    //listItems.add(info);
                }
              //  adapter.notifyDataSetChanged();
                Context context = getApplicationContext();
                list = (ListView)findViewById(R.id.listView);
                ListAdapter adapter = new ListAdapter(context, listData);
                list.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), "Serious Issue", Toast.LENGTH_LONG).show();
            }
        });



        /* UI display code*/


    }


}
