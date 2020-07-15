package com.example.android.music;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AllSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_songs);


        ArrayList<SongInfo> information = new ArrayList<SongInfo>();
        information.add(new SongInfo("Океан", "Дима Билан"));
        information.add(new SongInfo("Birds", "Imagine Dragons"));
        information.add(new SongInfo("Химия", "Дима Билан"));
        information.add(new SongInfo("Не молчи", "Дима Билан"));
        information.add(new SongInfo("The Scientist", "Coldplay"));
        information.add(new SongInfo("Держи", "Дима Билан"));
        information.add(new SongInfo("Thunder", "Imagine Dragons"));
        information.add(new SongInfo("Химия", "Дима Билан"));
        information.add(new SongInfo("Не молчи", "Дима Билан"));
        information.add(new SongInfo("Paradise", "Coldplay"));
        information.add(new SongInfo("Держи", "Дима Билан"));
        information.add(new SongInfo("Thunder", "Imagine Dragons"));
        information.add(new SongInfo("Химия", "Дима Билан"));
        information.add(new SongInfo("Не молчи", "Дима Билан"));
        information.add(new SongInfo("Paradise", "Coldplay"));

        Adapter items = new Adapter(this, information);
        ListView allSongsLayout = findViewById(R.id.layout2);
        allSongsLayout.setAdapter(items);


    }


}
