package fr.utt.if26.duciel_cursus.controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import fr.utt.if26.duciel_cursus.models.entities.Module;
import fr.utt.if26.duciel_cursus.controllers.adaptaters.ModuleRecyclerAdapter;
import fr.utt.if26.duciel_cursus.R;
import fr.utt.if26.duciel_cursus.viewModel.ModuleViewModel;

public class ModuleRecyclerActivity extends AppCompatActivity {
    private ModuleViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_recycler);

        RecyclerView recyclerView = findViewById(R.id.module_recycler_view);

        viewModel = new ModuleViewModel(this.getApplication());

        ArrayList<Module> modules = viewModel.getAllStaticModules().getValue();

        ModuleRecyclerAdapter adapter = new ModuleRecyclerAdapter(modules);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerView.setAdapter(adapter);
    }
}