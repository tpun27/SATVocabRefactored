package com.refactored.satvocabrefactored;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DefinitionFragment extends Fragment {

    DefinitionInterface mCallback;

    public interface DefinitionInterface {
        String getDefinition();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (DefinitionInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement DefinitionInterface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View defView = inflater.inflate(R.layout.definition_fragment, container, false);
        TextView defTextView = (TextView) defView.findViewById(R.id.defTextView);
        defTextView.setText(mCallback.getDefinition());

        return defView;
    }
}
