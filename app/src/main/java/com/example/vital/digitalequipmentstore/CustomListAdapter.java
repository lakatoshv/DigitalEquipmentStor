package com.example.vital.digitalequipmentstore;

/**
 * Created by vital on 01.04.2018.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final List<String> titleArr;
    private final List<String> priceArr;
    private final List<Integer> imgArr;

    public CustomListAdapter(Activity context, List<String> title, List<Integer> imgid, List<String> price) {
        super(context, R.layout.item, title);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.titleArr=title;
        this.priceArr=price;
        this.imgArr=imgid;
    }

    public View getView(int position, View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item, null,true);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.title);
        TextView extratxt = (TextView) rowView.findViewById(R.id.price);

        txtTitle.setText(titleArr.get(position));
        imageView.setImageResource(imgArr.get(position));
        extratxt.setText(priceArr.get(position));
        return rowView;

    };
}
