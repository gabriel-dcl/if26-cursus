package fr.utt.if26.duciel_cursus.models.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.utt.if26.duciel_cursus.models.DAO.ModuleDAO;
import fr.utt.if26.duciel_cursus.models.RoomCursusDatabase;
import fr.utt.if26.duciel_cursus.models.entities.ModuleEntity;

public class RoomCursusRepository {
    private ModuleDAO moduleDAO;
    private LiveData<List<ModuleEntity>> allModules;

    public RoomCursusRepository(Application application) {
        RoomCursusDatabase db = RoomCursusDatabase.getDatabase(application);
        moduleDAO = db.moduleDAO();
        allModules = moduleDAO.getAllModules();
    }

    public LiveData<List<ModuleEntity>> getAllModules() {
        return allModules;
    }

    public void insert(ModuleEntity module) {
        InsertAsyncTask task = new InsertAsyncTask(moduleDAO);
        task.execute(module);
    }

    public void deleteBySigle(String sigle) {
        DeleteAsyncTask task = new DeleteAsyncTask(moduleDAO);
        task.execute(sigle);
    }

    private static class InsertAsyncTask extends AsyncTask<ModuleEntity, Void, Void> {
        private ModuleDAO moduleDAO;

        InsertAsyncTask(ModuleDAO moduleDAO){
            this.moduleDAO = moduleDAO;
        }

        @Override
        protected Void doInBackground(ModuleEntity... moduleEntities) {
            moduleDAO.insert(moduleEntities[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<String, Void, Void> {
        private ModuleDAO moduleDAO;

        DeleteAsyncTask(ModuleDAO moduleDAO){
            this.moduleDAO = moduleDAO;
        }

        @Override
        protected Void doInBackground(String... strings) {
            moduleDAO.deleteBySigle(strings[0]);
            return null;
        }
    }

}
