package com.example.appbook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ChapterAdapter extends ArrayAdapter<String> {

    public ChapterAdapter(Context context, String[] chapters) {
        super(context, 0, chapters);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView chapterNumber = convertView.findViewById(R.id.chapter_number);
        chapterNumber.setText(getItem(position));
        convertView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.animate().scaleX(1.05f).scaleY(1.05f).setDuration(200).start();
            } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                v.animate().scaleX(1f).scaleY(1f).setDuration(200).start();
            }
            return false;
        });

        return convertView;
    }
}
