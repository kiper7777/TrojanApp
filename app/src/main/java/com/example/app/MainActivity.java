package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_App);
        setContentView(R.layout.activity_main);

        // Set click listeners for all images
        ImageView img1 = findViewById(R.id.gameplay_screenshot);
        ImageView img2 = findViewById(R.id.gameplay_screenshot2);
        ImageView img3 = findViewById(R.id.gameplay_screenshot3);
        ImageView img4 = findViewById(R.id.gameplay_screenshot4);
        ImageView poster = findViewById(R.id.game_poster);

        setImageClick(img1, R.drawable.gameplay_visual1);
        setImageClick(img2, R.drawable.gameplay_visual2);
        setImageClick(img3, R.drawable.gameplay_visual3);
        setImageClick(img4, R.drawable.gameplay_visual4);
        setImageClick(poster, R.drawable.poster);
    }

    // Reusable method for setting click to full-screen view
    private void setImageClick(ImageView imageView, int imageResId) {
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GameScreenshotOneActivity.class);
            intent.putExtra("imageResId", imageResId);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.about_game) {
            Toast.makeText(this, "About game", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.gameplay_video) {
            Intent intent = new Intent(this, GameplayVideoActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.game_location) {
            Intent intent = new Intent(this, GameLocationActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.faq) {
            Toast.makeText(this, "FAQ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, FaqActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.contact_us) {
            Toast.makeText(this, "CONTACT", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ContactActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
