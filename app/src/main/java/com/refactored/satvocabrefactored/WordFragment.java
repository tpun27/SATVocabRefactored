package com.refactored.satvocabrefactored;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WordFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View wordView = inflater.inflate(R.layout.word_fragment, container, false);
        TextView wordTextView = (TextView) wordView.findViewById(R.id.wordTextView);
        wordTextView.setText("Test Word");

        return wordView;
    }
}
