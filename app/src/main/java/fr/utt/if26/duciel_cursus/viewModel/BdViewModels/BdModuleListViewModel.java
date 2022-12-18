package fr.utt.if26.duciel_cursus.viewModel.BdViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import fr.utt.if26.duciel_cursus.models.BDOpenHelper;
import fr.utt.if26.duciel_cursus.models.entities.Module;

public class BdModuleListViewModel extends AndroidViewModel {
    private BDOpenHelper bdo;


    public BdModuleListViewModel(@NonNull Application application) {
        super(application);

        bdo = new BDOpenHelper(application);
    }

    public MutableLiveData<ArrayList<Module>> getAllModules()
    {
        MutableLiveData<ArrayList<Module>> modules = new MutableLiveData<ArrayList<Module>>(bdo.getAllModules());
        return modules;
    }

}
