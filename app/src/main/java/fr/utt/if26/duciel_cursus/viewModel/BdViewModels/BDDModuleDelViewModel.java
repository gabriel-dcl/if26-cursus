package fr.utt.if26.duciel_cursus.viewModel.BdViewModels;

import android.app.Application;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import fr.utt.if26.duciel_cursus.models.BDOpenHelper;

public class BDDModuleDelViewModel extends AndroidViewModel {
    private BDOpenHelper bdo;

    public BDDModuleDelViewModel(@NonNull Application application) {
        super(application);

        bdo = new BDOpenHelper(application);
    }

    public void deleteModule(TextView sigle){
        if(!sigle.getText().toString().equals("")){
            bdo.deleteModule(sigle.getText().toString());
            showSuccessMessage();
            return;
        }
    }

    public void showSuccessMessage(){
        Toast.makeText(this.getApplication(), "Un module a été supprimé avec succès.", Toast.LENGTH_LONG).show();
    }

    public void showErrorMessage(){
        Toast.makeText(this.getApplication(), "Une erreur a été rencontrée.", Toast.LENGTH_LONG).show();
    }
}
