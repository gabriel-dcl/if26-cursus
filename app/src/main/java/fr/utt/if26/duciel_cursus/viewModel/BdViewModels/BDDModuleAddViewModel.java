package fr.utt.if26.duciel_cursus.viewModel.BdViewModels;

import android.app.Application;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import fr.utt.if26.duciel_cursus.models.BDOpenHelper;
import fr.utt.if26.duciel_cursus.models.entities.Module;

public class BDDModuleAddViewModel extends AndroidViewModel {
    private BDOpenHelper bdo;

    public BDDModuleAddViewModel(@NonNull Application application) {
        super(application);

        bdo = new BDOpenHelper(application);
    }

    public void addModule( TextView credit, TextView sigle, TextView parcours, TextView categorie)
    {
        if(!sigle.getText().toString().equals("")
                && !credit.getText().toString().equals("")
                && !parcours.getText().toString().equals("")
                && !categorie.getText().toString().equals(""))
        {
            try{
                Integer.parseInt(credit.getText().toString());

                Module module = new Module(sigle.getText().toString(), parcours.getText().toString(),
                        categorie.getText().toString(), Integer.parseInt(credit.getText().toString()));

                bdo.createModule(module);
                showSuccessMessage();

            } catch (Exception e){
                showErrorMessage();
            }
        }
    }

    public void showSuccessMessage(){
        Toast.makeText(this.getApplication(), "Un module a été ajouté avec succès.", Toast.LENGTH_LONG).show();
    }

    public void showErrorMessage(){
        Toast.makeText(this.getApplication(), "Une erreur a été rencontrée.", Toast.LENGTH_LONG).show();
    }
}
