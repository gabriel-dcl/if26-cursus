package fr.utt.if26.duciel_cursus.controllers;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fr.utt.if26.duciel_cursus.models.entities.Module;
import fr.utt.if26.duciel_cursus.controllers.adaptaters.ModuleAdaptateur;
import fr.utt.if26.duciel_cursus.R;
import fr.utt.if26.duciel_cursus.viewModel.ModuleViewModel;

public class ModuleListActivity extends AppCompatActivity {
    private ModuleViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);

        viewModel = new ModuleViewModel(this.getApplication());

        ArrayList<Module> modules = viewModel.getAllStaticModules().getValue();

        ModuleAdaptateur adapter = new ModuleAdaptateur(this, R.layout.module_item,modules);
        ListView sigleListeLv = (ListView) findViewById(R.id.module_list_lv);

        sigleListeLv.setAdapter(adapter);

    }


}
