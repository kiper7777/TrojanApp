package com.example.app;

import static com.example.app.R.*;
import static com.example.app.R.id.game_location;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(style.Theme_App); //
        setContentView(layout.activity_main);
    }

   @Override
   public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item){
            int id = item.getItemId();
       {
           if (id == R.id.about_game) {
               Toast.makeText(this, "About game", Toast.LENGTH_SHORT).show();
               return true;
           }
           else if (id == R.id.gameplay_videos) {
               Toast.makeText(this, "Gameplay videos", Toast.LENGTH_SHORT).show();
               return true;

           }
           else if (id == R.id.game_location) { // Assuming game_location is an R.id
               Toast.makeText(this, "Game location", Toast.LENGTH_SHORT).show();
               return true;

           }
           else if (id == R.id.faq) { // Assuming faq is an R.id
               Toast.makeText(this, "FAQ", Toast.LENGTH_SHORT).show();
               return true;
           }

           else {
               // Handle other menu items or return false if the item wasn't handled.
               return super.onOptionsItemSelected(item); // Important for default behavior
           }

       }}}
