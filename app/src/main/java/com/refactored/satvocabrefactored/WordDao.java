package com.refactored.satvocabrefactored;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    public void insertWords(Word[] words);

    @Query("SELECT * FROM words")
    List<Word> getAll();

    @Query("SELECT * FROM words WHERE id = :id")
    public Word getWord(int id);
}
