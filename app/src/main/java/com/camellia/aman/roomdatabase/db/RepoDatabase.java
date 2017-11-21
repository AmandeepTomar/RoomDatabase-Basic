package com.camellia.aman.roomdatabase.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by amandeep on 21/11/17.
 */
@Database(entities = {Repo.class},version = 1)
public abstract class RepoDatabase extends RoomDatabase {
    private final static String DB_NAME="repoDatabase.db";
    private static volatile RepoDatabase instance;

    public static synchronized RepoDatabase getInstance(Context context) {
        if (instance == null) {
            instance =
                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(), RepoDatabase.class)
                            // To simplify the codelab, allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return instance;

    }

    private static RepoDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                RepoDatabase.class,

                DB_NAME).build();
    }

    public abstract RepoDao getRepoDao();

    public static void destroyInstance() {
        instance = null;
    }

}
