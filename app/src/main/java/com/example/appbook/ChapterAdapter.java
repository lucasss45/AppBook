package com.example.appbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ChapterAdapter extends ArrayAdapter<String> {

    public ChapterAdapter(Context context, String[] chapters) {
        super(context, 0, chapters);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView chapterNumber = convertView.findViewById(R.id.chapter_number);
        chapterNumber.setText(getItem(position));

        convertView.setOnClickListener(v -> {
            Animation scaleUp = AnimationUtils.loadAnimation(getContext(), R.anim.scale_up);
            Animation scaleDown = AnimationUtils.loadAnimation(getContext(), R.anim.scale_down);

            v.startAnimation(scaleUp);
            v.postDelayed(() -> v.startAnimation(scaleDown), scaleUp.getDuration());
        });

        return convertView;
    }
}
