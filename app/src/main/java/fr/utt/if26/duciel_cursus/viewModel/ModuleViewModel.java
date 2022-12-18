package fr.utt.if26.duciel_cursus.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import fr.utt.if26.duciel_cursus.models.entities.Module;
import fr.utt.if26.duciel_cursus.models.entities.ModuleEntity;
import fr.utt.if26.duciel_cursus.models.entities.ProgrammeISI;
import fr.utt.if26.duciel_cursus.models.repository.RoomCursusRepository;

public class ModuleViewModel extends AndroidViewModel {
    private RoomCursusRepository moduleRepository;
    private final LiveData<List<ModuleEntity>> allEntities;

    public ModuleViewModel(@NonNull Application application) {
        super(application);
        moduleRepository = new RoomCursusRepository(application);
        allEntities = moduleRepository.getAllModules();
    }

    public LiveData<List<ModuleEntity>> getAllEntities() { return allEntities; }

    public void insert(ModuleEntity module) { moduleRepository.insert(module); }

    public MutableLiveData<ArrayList<Module>> getAllStaticModules(){
        ProgrammeISI isi = new ProgrammeISI();
        ArrayList<Module> modules = isi.getModules();

        MutableLiveData<ArrayList<Module>> liveDataModules = new MutableLiveData<ArrayList<Module>>(modules);
        return liveDataModules;
    }

    public MutableLiveData<ArrayList<String>> getAllStaticSigles(){
        ProgrammeISI isi = new ProgrammeISI();
        ArrayList<String> modules = isi.getSigles();

        MutableLiveData<ArrayList<String>> liveDataSigles = new MutableLiveData<ArrayList<String>>(modules);
        return liveDataSigles;
    }
}
