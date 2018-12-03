package uoit.ca.movieapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.squareup.picasso.Picasso;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieAdapter extends BaseAdapter {

    /* Fields */

    private static final String TAG = MovieAdapter.class.getSimpleName();
    private Context mContext;
    private ArrayList<MyMovie> list;
    public static final String MOVIE_BASE_URL = "https://image.tmdb.org/t/p/w185";
    ImageView imageView;

    public MovieAdapter(Context context, ArrayList<MyMovie> myMovieList) {
        this.mContext = context;
        this.list = myMovieList;
    }

    /* Getters */

    @Override
    public int getCount() {
//        return list.size();
        return 0;
    }

    @Override
    public MyMovie getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyMovie movies = getItem(position);
        RelativeLayout relativeLayout = new RelativeLayout(mContext);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(200, 300));
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setAdjustViewBounds(true); //!important
            relativeLayout.addView(imageView);
        } else {
            imageView = (ImageView) convertView;
        }

        //load data into the ImageView using Picasso
        Picasso.get().load(MOVIE_BASE_URL + movies.getPosterPath())
                .placeholder(R.drawable.image_placeholder)
                .into(imageView);

        return imageView;
    }


}
