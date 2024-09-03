package com.example.appbook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.appbook.ChapterAdapter;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.chapter_list);


        String[] chapters = new String[216];
        for (int i = 0; i < chapters.length; i++) {
            chapters[i] = "Capítulo " + (i + 1);
        }

        ChapterAdapter adapter = new ChapterAdapter(this, chapters);
        listView.setAdapter(adapter);
    }
}
