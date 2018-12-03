package uoit.ca.movieapp;

import android.os.AsyncTask;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ProgressBar;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import netUtils.netUtility;

public class MovieActivity extends AppCompatActivity {

    /* Fields */

    String popularMoviesURL;
    //@BindView(R.id.indeterminateBar)
    ProgressBar mProgressBar;
    // GridView gridView;
    ArrayList<MyMovie> myMovieList;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ArrayList<MyMovie> mPopularList;
    ListView listView;
    String[] test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        /* Initialize variables*/

        listView = (ListView) findViewById(R.id.listView);
        test = new String[]{};

        /* Movie gathering code */


        ButterKnife.bind(this);
//        mProgressBar.setVisibility(View.INVISIBLE); //Hide Progressbar by Default
//        mProgressBar.setVisibility(View.INVISIBLE); //Hide Progressbar by Default
        new FetchMovies().execute();
//        gridView = (GridView) findViewById(R.id.pop_movies_grid);
//        gridView.setAdapter(new MovieAdapter(this,myMovieList));
//        gridView.setOnItemClickListener(new OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                Toast.makeText(MovieActivity.this, "" + position,
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

        /* UI display code*/

        final List<String> testList = new ArrayList<String>(Arrays.asList(test));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, testList);
        listView.setAdapter(arrayAdapter);


        /* Iterate through movie list and print their titles*/

        for (int i = 0; i < netUtility.movies.size(); i++) {
            testList.add(netUtility.movies.get(i).getTitle());
        }
//        netUtility.movies.add(netUtility.m1);
//        netUtility.movies.add(netUtility.m2);
//        netUtility.movies.add(netUtility.m3);
//        netUtility.movies.add(netUtility.m4);
//        netUtility.movies.add(netUtility.m5);
//        netUtility.movies.add(netUtility.m6);
//        netUtility.movies.add(netUtility.m7);
//        netUtility.movies.add(netUtility.m8);
//        netUtility.movies.add(netUtility.m9);
//        netUtility.movies.add(netUtility.m10);
//        netUtility.movies.add(netUtility.m11);
//        netUtility.movies.add(netUtility.m12);


        /* Print title of first 12 movies */
        testList.add(netUtility.movies.get(1).getTitle());
        testList.add(netUtility.movies.get(2).getTitle());
        testList.add(netUtility.movies.get(3).getTitle());
        testList.add(netUtility.movies.get(4).getTitle());
        testList.add(netUtility.movies.get(5).getTitle());
        testList.add(netUtility.movies.get(6).getTitle());
        testList.add(netUtility.movies.get(7).getTitle());
        testList.add(netUtility.movies.get(8).getTitle());
        testList.add(netUtility.movies.get(9).getTitle());
        testList.add(netUtility.movies.get(10).getTitle());
        testList.add(netUtility.movies.get(11).getTitle());

    }

    public class FetchMovies extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            popularMoviesURL = "https://api.themoviedb.org/3/movie/550?api_key=4f809abf854213ca4ff8e365ebe62359";

            Looper.prepare();
            try {
                if (netUtility.networkStatus(MovieActivity.this)) {
                    mPopularList = netUtility.fetchData(popularMoviesURL); //Get popular movies

                } else {
                    Toast.makeText(MovieActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void s) {
            super.onPostExecute(s);
            // mProgressBar.setVisibility(View.INVISIBLE);
        }
    }
}
