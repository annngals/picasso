package com.example.picasso;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductsAdapter extends CursorAdapter {
    Picasso p;
    public ProductsAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        p  = new Picasso.Builder(context).build();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView picture = view.findViewById(R.id.picture);
        TextView tvName = view.findViewById(R.id.name);
        TextView tvPrice = view.findViewById(R.id.price);
        TextView tvGroup = view.findViewById(R.id.group);
        TextView tvDescription = view.findViewById(R.id.description);

        String name = cursor.getString(cursor.getColumnIndex("name"));
        int price = cursor.getInt(cursor.getColumnIndex("price"));
        String url = cursor.getString(cursor.getColumnIndex("url"));
        String group = cursor.getString(cursor.getColumnIndex("group"));
        String description = cursor.getString(cursor.getColumnIndex("description"));

        tvName.setText(name);
        tvPrice.setText(Integer.toString(price));
        tvGroup.setText(group);
        tvDescription.setText(description);
        p.load(url).error(R.drawable.no_image).into(picture);
    }
}