package netUtils;

import android.content.Context;
import android.graphics.Movie;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import uoit.ca.movieapp.MyMovie;

public class netUtility {

    public static ArrayList<MyMovie> movies = new ArrayList<MyMovie>();

    /* Default values for testing*/
    public static MyMovie m1 = new MyMovie();
    public static MyMovie m2 = new MyMovie();
    public static MyMovie m3 = new MyMovie();
    public static MyMovie m4 = new MyMovie();
    public static MyMovie m5 = new MyMovie();
    public static MyMovie m6 = new MyMovie();
    public static MyMovie m7 = new MyMovie();
    public static MyMovie m8 = new MyMovie();
    public static MyMovie m9 = new MyMovie();
    public static MyMovie m10 = new MyMovie();
    public static MyMovie m11 = new MyMovie();
    public static MyMovie m12 = new MyMovie();

    private static final String TAG = netUtility.class.getSimpleName();

    public static ArrayList<MyMovie> fetchData(String url) throws IOException {
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);


        try {

            URL new_url = new URL(url); //create a url from a String
            HttpURLConnection connection = (HttpURLConnection) new_url.openConnection(); //Opening a http connection  to the remote object
            connection.connect();

            InputStream inputStream = connection.getInputStream(); //reading from the object
            String results = IOUtils.toString(inputStream);  //IOUtils to convert input stream objects into Strings type
            parseJson(results,movies);
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
    public static void parseJson(String data, ArrayList<MyMovie> list){

        try {
            JSONObject mainObject = new JSONObject(data);

            JSONArray resArray = mainObject.getJSONArray("results"); //Getting the results object
            for (int i = 0; i < resArray.length(); i++) {
                JSONObject jsonObject = resArray.getJSONObject(i);
                MyMovie movie = new MyMovie(); //New MyMovie object
                movie.setId(jsonObject.getInt("imdbID"));
                movie.setimdbRating(jsonObject.getInt("imdbRating"));
                movie.setimdbVotes(jsonObject.getInt("imdbVotes"));
                movie.setTitle(jsonObject.getString("Title"));
                movie.setPlot(jsonObject.getString("Plot"));
                movie.setReleased(jsonObject.getString("Released"));
                movie.setPoster(jsonObject.getString("Poster"));
                //Adding a new movie object into ArrayList
                list.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "Error occurred during JSON Parsing", e);
        }

    }
    public static Boolean networkStatus(Context context){
        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            return true;
        }
        return false;
    }
}
