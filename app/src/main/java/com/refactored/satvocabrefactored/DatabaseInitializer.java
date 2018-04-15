package com.refactored.satvocabrefactored;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.annotations.NonNull;

public class DatabaseInitializer {

    public static void populateAsync(@NonNull final AppDatabase db, JSONArray wordBankAry) {
        PopulateDbAsync task = new PopulateDbAsync(db, wordBankAry);
        task.execute();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;
        private JSONArray mWordBankAry;

        PopulateDbAsync(AppDatabase db, JSONArray wordBankAry) {
            mDb = db;
            mWordBankAry = wordBankAry;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWordBank(mDb, mWordBankAry);
            return null;
        }
    }

    private static void populateWordBank(AppDatabase db, JSONArray wordBankAry) {

        Word[] tempWordAry = new Word[wordBankAry.length()];

        try {
            for (int wordIndex = 0; wordIndex < wordBankAry.length(); wordIndex++) {
                JSONObject jsonObj = wordBankAry.getJSONObject(wordIndex);
                tempWordAry[wordIndex] = new Word(jsonObj.getString("word"), jsonObj.getString("definition"));
            }
            db.wordDao().insertWords(tempWordAry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}