package com.refactored.satvocabrefactored;

import android.os.AsyncTask;

import org.json.JSONArray;

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

    }
}