package uoit.ca.movieapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import netUtils.netUtility;

public class MovieActivity extends AppCompatActivity {
    String popularMoviesURL;
    @BindView(R.id.indeterminateBar)
    ProgressBar mProgressBar;
    GridView gridView;
    ArrayList<MyMovie> myMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        mProgressBar.setVisibility(View.INVISIBLE); //Hide Progressbar by Default
        mProgressBar.setVisibility(View.INVISIBLE); //Hide Progressbar by Default
        new FetchMovies().execute();
        gridView = (GridView) findViewById(R.id.pop_movies_grid);
        gridView.setAdapter(new MovieAdapter(this,myMovieList));
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MovieActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class FetchMovies extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            popularMoviesURL = "https://api.themoviedb.org/3/movie/550?api_key=4f809abf854213ca4ff8e365ebe62359";
            ArrayList<MyMovie> mPopularList;

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
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }
}
