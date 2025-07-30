package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_location);

        // === Add Clickable Images ===
        ImageView locationOne = findViewById(R.id.game_location);
        ImageView locationTwo = findViewById(R.id.location_two);
        ImageView locationThree = findViewById(R.id.location_three);

        locationOne.setOnClickListener(v -> openFullscreenImage(R.drawable.location_one));
        locationTwo.setOnClickListener(v -> openFullscreenImage(R.drawable.location_two));
        locationThree.setOnClickListener(v -> openFullscreenImage(R.drawable.location_three));
    }

    // Open fullscreen image
    private void openFullscreenImage(int imageResId) {
        Intent intent = new Intent(this, GameScreenshotOneActivity.class);
        intent.putExtra("imageResId", imageResId);
        startActivity(intent);
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
            startActivity(new Intent(this, MainActivity.class));
            return true;

        } else if (id == R.id.gameplay_video) {
            startActivity(new Intent(this, GameplayVideoActivity.class));
            return true;

        } else if (id == R.id.game_location) {
            Toast.makeText(this, "You are already here", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.faq) {
            startActivity(new Intent(this, FaqActivity.class));
            return true;

        } else if (id == R.id.contact_us) {
            startActivity(new Intent(this, ContactActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}