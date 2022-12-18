package fr.utt.if26.duciel_cursus.models;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fr.utt.if26.duciel_cursus.models.DAO.ModuleDAO;
import fr.utt.if26.duciel_cursus.models.entities.ModuleEntity;

@Database(entities = {ModuleEntity.class}, version = 1)
public abstract class RoomCursusDatabase extends RoomDatabase {
    public abstract ModuleDAO moduleDAO();

    private static volatile RoomCursusDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static RoomCursusDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomCursusDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    RoomCursusDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                ModuleDAO dao = INSTANCE.moduleDAO();
                dao.deleteAll();

                ModuleEntity room1 = new ModuleEntity("Room1", "MSC", "CS", 6);
                dao.insert(room1);

                ModuleEntity room2 = new ModuleEntity("Room2", "MSC", "CS", 6);
                dao.insert(room2);

                ModuleEntity room3 = new ModuleEntity("Room3", "MSC", "CS", 6);
                dao.insert(room3);
            });
        }
    };

}


