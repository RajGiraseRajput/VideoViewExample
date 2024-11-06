package com.example.videoviewexample;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.videoviewexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        String videoPath = "android.resource://"+getPackageName()+"/raw/sample_video";

        String onlinePath = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4";

       Uri videoUri = Uri.parse(onlinePath);

//        binding.videoView.setVideoPath(videoPath);

        binding.videoView.setVideoURI(videoUri);


        binding.videoView.start();


        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(binding.videoView);

        binding.videoView.setMediaController(mediaController);
    }
}