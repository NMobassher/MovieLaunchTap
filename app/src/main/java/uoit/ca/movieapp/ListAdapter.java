package uoit.ca.movieapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    /* Fields */


    Context context;
    List<ListData> listData;
    ViewFields fields;

    public ListAdapter(Context context, List<ListData> listData) {
        this.context = context;
        this.listData = listData;
    }

    private class ViewFields {
        ImageView imageView;
        TextView titleView;
        TextView subtitleView;
        TextView itemPath;

    }


    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
      return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listData.indexOf(getItemId(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        fields = null;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.list_item, null);
            fields = new ViewFields();
            fields.titleView = (TextView) convertView.findViewById(R.id.itemTitle);
            fields.subtitleView = (TextView) convertView.findViewById(R.id.itemSubtitle);
            fields.imageView = (ImageView) convertView.findViewById(R.id.itemImage);
            fields.itemPath = (TextView) convertView.findViewById(R.id.itemPath);

            convertView.setTag(fields);

        } else {
            fields = (ViewFields) convertView.getTag();
        }

        ListData theItem = (ListData)getItem(position);

        fields.titleView.setText(theItem.getTitle());
        fields.subtitleView.setText(theItem.getSubtitle());
        fields.imageView.setImageResource(theItem.getImageId());
        fields.imageView.setImageBitmap(theItem.getImageBitmap());

        final String theUrl;
        theUrl = "https://image.tmdb.org/t/p/w92"+theItem.getDebugPath();

        Picasso.with(context).
                load(theUrl).
                fit().
               // transform(trans). // if you want any transformations..
                centerCrop().
                //error(R.drawable.error_avatar). // in case of error
                into(fields.imageView);





        return convertView;
    }
}
