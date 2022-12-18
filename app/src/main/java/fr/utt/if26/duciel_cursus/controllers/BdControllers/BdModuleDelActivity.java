package fr.utt.if26.duciel_cursus.controllers.BdControllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.utt.if26.duciel_cursus.R;
import fr.utt.if26.duciel_cursus.viewModel.BdViewModels.BDDModuleDelViewModel;

public class BdModuleDelActivity extends AppCompatActivity {
    private TextView sigle;
    private Button button;
    private BDDModuleDelViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_module_del);

        viewModel = new BDDModuleDelViewModel(this.getApplication());
        sigle = findViewById(R.id.sigle_to_delete);
        button = findViewById(R.id.delete_sigle);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.deleteModule(sigle);
            }
        });

    }
}