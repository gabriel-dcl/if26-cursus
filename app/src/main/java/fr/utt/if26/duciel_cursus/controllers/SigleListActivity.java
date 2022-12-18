package fr.utt.if26.duciel_cursus.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import fr.utt.if26.duciel_cursus.controllers.adaptaters.AdaptateurSigle;
import fr.utt.if26.duciel_cursus.R;
import fr.utt.if26.duciel_cursus.viewModel.ModuleViewModel;

public class SigleListActivity extends AppCompatActivity {
    private ModuleViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);

        viewModel = new ModuleViewModel(this.getApplication());

        ArrayList<String> sigles = viewModel.getAllStaticSigles().getValue();

        AdaptateurSigle adapter = new AdaptateurSigle(this, R.layout.sigle_item, sigles);
        ListView sigleListeLv = (ListView) findViewById(R.id.module_list_lv);

        sigleListeLv.setAdapter(adapter);

    }
}