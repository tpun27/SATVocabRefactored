package com.refactored.satvocabrefactored;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private String fileName = "majortests_words.json";
    private JSONArray wordBankAry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadWords();

        Button startAppButton = (Button) findViewById(R.id.startAppButton);
        startAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WordActivity.class);
                startActivity(intent);
            }
        });
    }

    public String loadJSONData() {
        String jsonStr = null;
        try {
            InputStream iStream = getAssets().open(fileName);
            int size = iStream.available();
            byte[] buffer = new byte[size];
            iStream.read(buffer);
            iStream.close();

            jsonStr = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonStr;
    }

    public void loadWords() {
        try {
            String jsonStr = loadJSONData();
            JSONObject jsonObj = new JSONObject(jsonStr);
            wordBankAry = jsonObj.getJSONArray("wordBank");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
