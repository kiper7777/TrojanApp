package com.example.trojanapp;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView videoPreview1, videoPreview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoPreview1=findViewById(R.id.videoPreview1);
        videoPreview2=findViewById(R.id.videoPreview2);

        videoPreview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(R.raw.trojan_gameplay);
            }
        });

        videoPreview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(R.raw.trojan_gameplay2);
            }
        });
    }

    private void playVideo(int videoResId){
        // Create a dialog box to display VideoView
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.video_dialog);
        dialog.setCancelable(true);

        VideoView videoView=dialog.findViewById(R.id.videoView);
        String videoPath="android.resource://" + getPackageManager() + "/" + videoResId;
        Uri uri=Uri.parse(videoPath);

        videoView.setVideoURI(uri);
        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.start();

        dialog.show();
    }
}