package fr.utt.if26.duciel_cursus.controllers.BdControllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import fr.utt.if26.duciel_cursus.models.BDOpenHelper;
import fr.utt.if26.duciel_cursus.models.entities.Module;
import fr.utt.if26.duciel_cursus.controllers.adaptaters.ModuleRecyclerAdapter;
import fr.utt.if26.duciel_cursus.R;
import fr.utt.if26.duciel_cursus.viewModel.BdViewModels.BdModuleListViewModel;

public class BDModuleListActivity extends AppCompatActivity {
    private BDOpenHelper bdo;
    private BdModuleListViewModel viewModel;
    private ArrayList<Module> modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_recycler);

        viewModel = new BdModuleListViewModel(this.getApplication());
        RecyclerView recyclerView = findViewById(R.id.module_recycler_view);

        modules = viewModel.getAllModules().getValue();

        ModuleRecyclerAdapter adapter = new ModuleRecyclerAdapter(modules);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerView.setAdapter(adapter);
    }
}