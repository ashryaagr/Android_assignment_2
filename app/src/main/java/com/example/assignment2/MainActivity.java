package com.example.assignment2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.assignment2.adapters.RecyclerviewCustomAdapter;
import com.example.assignment2.models.item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView.LayoutManager layoutManager ;
    RecyclerView recyclerView;
    ArrayList<item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Below is the code written by me and above one was written automatically as i didn't choose empty activity.
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        items = new ArrayList<>();
        final SharedPreferences sharedpreferences = getSharedPreferences("assignment2", Context.MODE_PRIVATE);
        int counter = sharedpreferences.getInt("counter", 0);
        for (int i=0; i<counter; i+=2){
            String name = sharedpreferences.getString(String.valueOf(i), " ");
            String description = sharedpreferences.getString(String.valueOf(i+1), " ") ;
            item Item = new item(name, description, R.drawable.bb) ;
            items.add(Item) ;
        }
        // item twitter = new item("Twitter", "Yolo description", R.drawable.bb);
        // item facebook = new item("Facebook", "Some description", R.drawable.bb);

        // items.add(twitter) ;
        // items.add(facebook) ;

        RecyclerviewCustomAdapter adapter = new RecyclerviewCustomAdapter(this, items);
        recyclerView.setAdapter(adapter);
        FloatingActionButton button = findViewById(R.id.add_new) ;
        button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(MainActivity.this, addActivity.class);
                  startActivity(intent);
              }
          }
        ) ;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Toast.makeText(this, "item selected", Toast.LENGTH_SHORT).show();
        switch (id){
            case R.id.add :
                Intent intent = new Intent(this, addActivity.class) ;
                startActivity(intent);

                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    // No need of code for item refresh in OnResume as when Onresume is called , OnCreate is also called .
}
