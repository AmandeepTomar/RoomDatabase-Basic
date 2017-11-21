package com.camellia.aman.roomdatabase.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import com.camellia.aman.roomdatabase.db.Repo;

import java.util.List;

/**
 * Created by amandeep on 21/11/17.
 */
@Dao
public interface RepoDao {
    @Query("SELECT * FROM  repo")
    List<Repo> getAllRepos();

    @Insert
    void insert(Repo... repos);

    @Insert
    void insert(Repo repo);


    @Update
    void update(Repo... repos);

    @Delete
    void delete(Repo... repos);

    // return some queries

    @Query("SELECT * FROM repo WHERE id=:id")
    Repo getRepo(int id);

    @Query("SELECT * FROM repo")
    Cursor getRepoCursor();

    @Query("SELECT * FROM repo WHERE name=:name")
    List<Repo> getReposByName(String name);

    @Query("SELECT * FROM repo WHERE name=:name LIMIT :max")
    List<Repo> getReposByName(int max, String... name);

}
