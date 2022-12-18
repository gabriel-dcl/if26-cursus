package fr.utt.if26.duciel_cursus.controllers.BdControllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.utt.if26.duciel_cursus.R;
import fr.utt.if26.duciel_cursus.viewModel.BdViewModels.BDDModuleAddViewModel;

public class BDModuleAddActivity extends AppCompatActivity {
    private TextView credit;
    private TextView sigle;
    private TextView parcours;
    private TextView categorie;
    private BDDModuleAddViewModel viewModel;

    private Button addModuleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdmodule_add);
        viewModel = new BDDModuleAddViewModel(this.getApplication());

        sigle = findViewById(R.id.sigle_add);
        credit = findViewById(R.id.credit_add);
        parcours = findViewById(R.id.parcours_add);
        categorie = findViewById(R.id.categorie_add);

        addModuleButton = findViewById(R.id.add_module);

        addModuleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addModule(credit, sigle, parcours, categorie);
            }
        });
    }

}