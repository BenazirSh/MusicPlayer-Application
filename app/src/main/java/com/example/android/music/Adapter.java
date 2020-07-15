package com.example.android.music;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class Adapter extends ArrayAdapter<SongInfo> {

    private Context context;

    public Adapter(Activity context, ArrayList<SongInfo> information) {
        super(context, 0, information);
        this.context = context; // initialize it here


    }

    public static MediaPlayer player;
    public static void SoundPlayer(Context context,int raw_id){

        player = MediaPlayer.create(context, raw_id);
        player.setLooping(false); // Set looping
        player.setVolume(100, 100);
        //player.release();
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                if (player != null) {
                    // Regardless of the current state of the media player, release its resources
                    // because we no longer need it.
                    player.release();

                    // Set the media player back to null. For our code, we've decided that
                    // setting the media player to null is an easy way to tell that the media player
                    // is not configured to play an audio file at the moment.
                    player = null;
                }
            }
        });
    }





    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.view, parent, false);
        }
        Button playButton = listItemView.findViewById(R.id.playButton);
        //final MediaPlayer mediaPlayer = MediaPlayer.create(context,R.raw.song);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                SongInfo currentSong = getItem(position);
                String Song = currentSong.returnSongName();
                String Artist = currentSong.returnSingerName();
                Intent playIntent = new Intent(context, CurrentSongActivity.class);


                playIntent.putExtra("Song", Song);
                playIntent.putExtra("Artist", Artist);
                if (player != null) {
                    // Regardless of the current state of the media player, release its resources
                    // because we no longer need it.
                    player.release();

                    // Set the media player back to null. For our code, we've decided that
                    // setting the media player to null is an easy way to tell that the media player
                    // is not configured to play an audio file at the moment.
                    player = null;
                }

                SoundPlayer(context, R.raw.song);
                context.startActivity(playIntent);

            }
        });


        SongInfo song = getItem(position);

        TextView songTextView = (TextView) listItemView.findViewById(R.id.song);

        songTextView.setText(song.returnSongName());

        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist);

        artistTextView.setText(song.returnSingerName());


        return listItemView;

    }

}
