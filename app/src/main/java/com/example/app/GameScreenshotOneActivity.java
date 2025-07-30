package com.example.app;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class GameScreenshotOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_full_screenshot_one);

        ImageView fullscreenImage = findViewById(R.id.gameplay_screenshot);
        int imageResId = getIntent().getIntExtra("imageResId", 0);

        if (imageResId != 0) {
            fullscreenImage.setImageResource(imageResId);
        }
        fullscreenImage.setOnClickListener(v -> finish());
    }
}
