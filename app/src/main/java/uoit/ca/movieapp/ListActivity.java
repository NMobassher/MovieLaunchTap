package uoit.ca.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    public static TextView globalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        globalList = (TextView)findViewById(R.id.watchList);
        globalList.setText(MovieActivity.globalList);

    }
}
