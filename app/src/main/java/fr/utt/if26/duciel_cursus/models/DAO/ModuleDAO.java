package fr.utt.if26.duciel_cursus.models.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.utt.if26.duciel_cursus.models.entities.ModuleEntity;

@Dao
public interface ModuleDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ModuleEntity module);

    @Update
    void update(ModuleEntity module);

    @Delete
    void delete(ModuleEntity module);

    @Query("SELECT * FROM module_table WHERE module_table.sigle == :sigle")
    LiveData<ModuleEntity> getOne(String sigle);

    @Query("DELETE FROM module_table")
    void deleteAll();

    @Query("DELETE FROM module_table WHERE module_table.sigle == :sigle")
    void deleteBySigle(String sigle);

    @Query("SELECT * FROM module_table ORDER BY sigle ASC")
    LiveData<List<ModuleEntity>> getAllModules();
}
