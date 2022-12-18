package fr.utt.if26.duciel_cursus.controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import fr.utt.if26.duciel_cursus.controllers.adaptaters.ModuleEntitiesRecyclerAdapter;
import fr.utt.if26.duciel_cursus.R;
import fr.utt.if26.duciel_cursus.viewModel.ModuleViewModel;

public class RoomModuleListActivity extends AppCompatActivity {
    private ModuleViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_module_recycler);
        RecyclerView recyclerView = findViewById(R.id.module_recycler_view);

        mWordViewModel = new ViewModelProvider(this).get(ModuleViewModel.class);

        ModuleEntitiesRecyclerAdapter adapter
                = new ModuleEntitiesRecyclerAdapter(new ModuleEntitiesRecyclerAdapter.ModulesDiff());


        mWordViewModel.getAllEntities().observe(this, moduleEntities -> {
            adapter.submitList(moduleEntities);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }
}