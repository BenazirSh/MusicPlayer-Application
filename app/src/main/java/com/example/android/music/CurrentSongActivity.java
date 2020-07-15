package com.example.android.music;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.android.music.SongInfo.*;

public class CurrentSongActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_song);


        Intent i = getIntent();
        TextView currentSongText = (TextView) findViewById(R.id.title);
        String playingSong = i.getStringExtra("Song");
        String playingArtist = i.getStringExtra("Artist");
        currentSongText.setText(playingSong + "  " + playingArtist);


        final ImageView playingIcon = (ImageView) findViewById(R.id.playingIcon);

        //final MediaPlayer mediaPlayer = MediaPlayer.create(CurrentSongActivity.this,R.raw.song);
        playingIcon.setOnClickListener(new View.OnClickListener() {
            boolean state = false;


            @Override
            public void onClick(View v) {
                if (state == false) {
                    playingIcon.setImageResource(R.drawable.stop);
                    Adapter.player.pause();

                    Toast.makeText(getApplicationContext(), "Stopped playing", Toast.LENGTH_SHORT).show();
                    TextView currentText = findViewById(R.id.textPlaying);
                    currentText.setText("Stopped playing");
                    state = true;

                } else {
                    playingIcon.setImageResource(R.drawable.playing);
                    Adapter.player.start();
                    Toast.makeText(getApplicationContext(), "Started playing", Toast.LENGTH_SHORT).show();
                    TextView currentText = findViewById(R.id.textPlaying);
                    currentText.setText("Being Played");
                    state = false;

                }


            }
        });


    }

}
