package com.refactored.satvocabrefactored;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewAnimator;

public class WordActivity extends AppCompatActivity {
    
    ViewAnimator viewAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_layout);

        WordFragment wordFragment = new WordFragment();

        DefinitionFragment wordDefFragment = new DefinitionFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.wordNameContainer, new WordFragment());
        ft.add(R.id.wordDefContainer, new DefinitionFragment());
        ft.commit();

        viewAnimator = (ViewAnimator) findViewById(R.id.viewFlipper);

        viewAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationFactory.flipTransition(viewAnimator, AnimationFactory.FlipDirection.LEFT_RIGHT, 50);
            }
        });
    }
}
