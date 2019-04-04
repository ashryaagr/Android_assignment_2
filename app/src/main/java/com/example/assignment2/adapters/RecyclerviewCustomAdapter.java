package com.example.assignment2.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment2.R;
import com.example.assignment2.models.item;

import java.util.List;

public class RecyclerviewCustomAdapter extends RecyclerView.Adapter<RecyclerviewCustomAdapter.ViewHolder>  {

    List<item> items ;
    Activity context ;

    public RecyclerviewCustomAdapter(Activity context, List<item> items){
        this.items = items ;
        this.context = context ;
    }

    @NonNull
    @Override
    public RecyclerviewCustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.item_view, viewGroup, false) ;
        ViewHolder viewHolder  = new ViewHolder(v) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewCustomAdapter.ViewHolder viewHolder, int i) {
        item a = items.get(i) ; // i is equivalent to position
        viewHolder.name.setText(a.getName());
        viewHolder.description.setText(a.getDescription());
        viewHolder.image.setImageResource(a.getImage_resource_id());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name ;
        TextView description ;
        ImageView image ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name) ;
            description = itemView.findViewById(R.id.description) ;
            image = itemView.findViewById(R.id.item_image) ;
        }
    }
}
