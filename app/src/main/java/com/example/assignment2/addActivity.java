package com.example.assignment2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText name, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences sharedpreferences = getSharedPreferences("assignment2", Context.MODE_PRIVATE);

        // Checking for the presence of counter

        setContentView(R.layout.activity_add);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // My code starts
        Intent intent = getIntent();
        Button submit = findViewById(R.id.submit) ;
        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                name = findViewById(R.id.name);
                description = findViewById(R.id.description);
                SharedPreferences.Editor editor = sharedpreferences.edit() ;
                // sharedpreferences.edit().clear().commit() ;
                int counter = sharedpreferences.getInt("counter", 0) ;
                editor.putString(String.valueOf(counter), name.getText().toString()) ;
                editor.putString(String.valueOf(counter+1), description.getText().toString()) ;
                counter +=2 ;
                editor.putInt("counter", counter).apply();
                editor.commit() ;
                Toast.makeText(addActivity.this, "Item created", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(String.valueOf(MainActivity.class)) ;
                startActivity(intent1);
            }
        });
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




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.home:
                Intent intent = new Intent(this, MainActivity.class) ;
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
