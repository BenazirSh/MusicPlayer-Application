package com.example.android.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView allSongs = (TextView) findViewById(R.id.allSongs);

//        // Set a click listener on that View
        allSongs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link all_songs}
                Intent songsIntent = new Intent(MainActivity.this, AllSongsActivity.class);

                // Start the new activity
                startActivity(songsIntent);
            }
        });

        TextView albums = (TextView) findViewById(R.id.albums);
        albums.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link albums}
                Intent albumIntent = new Intent(MainActivity.this, AlbumsActivity.class);

                // Start the new activity
                startActivity(albumIntent);
            }
        });


    }


}
