package com.example.android.music;

public class SongInfo {
    private String songName;
    private String singerName;


    public SongInfo(String song, String singer) {
        songName = song;
        singerName = singer;
    }

    public String returnSongName() {
        return songName;
    }

    public String returnSingerName() {
        return singerName;
    }
}
