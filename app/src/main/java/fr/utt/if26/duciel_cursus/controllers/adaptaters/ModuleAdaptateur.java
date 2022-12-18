package fr.utt.if26.duciel_cursus.controllers.adaptaters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fr.utt.if26.duciel_cursus.R;
import fr.utt.if26.duciel_cursus.models.entities.Module;

public class ModuleAdaptateur extends ArrayAdapter<Module> {
    List<Module> modules;
    Context c;
    int r;

    public ModuleAdaptateur(@NonNull Context context, int resource, @NonNull List<Module> objects) {
        super(context, resource, objects);

        this.modules = objects;
        this.c = context;
        this.r = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater influater = ((Activity) c).getLayoutInflater();
        View v = influater.inflate(r, parent, false );
        Module elt = modules.get(position);

        TextView nameTv = v.findViewById(R.id.module_name);
        nameTv.setText(elt.getSigle());

        TextView parcoursTv = v.findViewById(R.id.module_parcours);
        parcoursTv.setText(elt.getParcours());

        TextView categorieTv = v.findViewById(R.id.module_categorie);
        categorieTv.setText(elt.getCategorie());

        TextView tv = v.findViewById(R.id.module_credit);
        tv.setText(Integer.toString(elt.getCredit()));

        return v;
    }

}
