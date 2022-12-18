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

public class AdaptateurSigle extends ArrayAdapter<String> {
    List<String> modules;
    Context c;
    int r;

    public AdaptateurSigle(@NonNull Context context, int resource, @NonNull List<String> objects) {
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
        String elt = modules.get(position);

        TextView tv = v.findViewById(R.id.sigle_name);
        tv.setText(elt);

        return v;
    }
}
