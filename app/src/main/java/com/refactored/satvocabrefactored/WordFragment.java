package com.refactored.satvocabrefactored;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WordFragment extends Fragment{

    WordInterface mCallback;

    public interface WordInterface {
        void getWordFromDB();
        String getWordName();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (WordInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement WordInterface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View wordView = inflater.inflate(R.layout.word_fragment, container, false);
        TextView wordTextView = (TextView) wordView.findViewById(R.id.wordTextView);
        wordTextView.setText(mCallback.getWordName());

        Button wordChangeButton = (Button) wordView.findViewById(R.id.wordChangeButton);
        wordChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.getWordFromDB();
            }
        });
        return wordView;
    }
}
