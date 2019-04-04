package com.example.assignment2.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment2.R;
import com.example.assignment2.models.item;

import java.util.List;

// Not sure if I need this java file .

public class itemAdapter extends ArrayAdapter<item> {
    Activity context;
    List<item> items;

    public itemAdapter(@NonNull Activity context, @NonNull List<item> objects) {
        super(context, R.layout.item_view, objects);
        items = objects ;
        this.context = context ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.item_view,  parent, false) ;

        TextView name = v.findViewById(R.id.name) ;
        TextView description = v.findViewById(R.id.description);
        ImageView icon = v.findViewById(R.id.item_image);

        final item Item = items.get(position) ;

        name.setText(Item.getName());
        description.setText(Item.getDescription());
        icon.setImageResource(Item.getImage_resource_id());

        // Uncomment all these after adding fonts
        // Typeface medium = Typeface.createFromAsset(context.getAssets(), "fonts/medium.ttf");

        //name.setTypeface(medium);
        //description.setTypeface(medium);

        return v ;
    }
}
