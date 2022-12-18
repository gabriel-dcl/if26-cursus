package fr.utt.if26.duciel_cursus.controllers.adaptaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.utt.if26.duciel_cursus.R;
import fr.utt.if26.duciel_cursus.models.entities.ModuleEntity;

public class ModuleEntitiesRecyclerAdapter extends ListAdapter<ModuleEntity, ModuleEntitiesRecyclerAdapter.ModuleHolder> {
    List<ModuleEntity> modules;

    public ModuleEntitiesRecyclerAdapter(@NonNull DiffUtil.ItemCallback<ModuleEntity> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ModuleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.module_item, parent, false);

        return new ModuleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleHolder holder, int position) {
        ModuleEntity current = getItem(position);
        holder.display(current);
    }

    class ModuleHolder extends RecyclerView.ViewHolder{
        private TextView nameTv;
        private TextView parcoursTv;
        private TextView categorieTv;
        private TextView creditTv;

        ModuleHolder(View itemView) {
            super(itemView);

            this.nameTv = itemView.findViewById(R.id.module_name);
            this.parcoursTv = itemView.findViewById(R.id.module_parcours);
            this.categorieTv = itemView.findViewById(R.id.module_categorie);
            this.creditTv = itemView.findViewById(R.id.module_credit);
        }

        void display(ModuleEntity module)
        {
            this.nameTv.setText(module.getSigle());
            this.parcoursTv.setText(module.getParcours());
            this.categorieTv.setText(module.getCategorie());
            this.creditTv.setText(Integer.toString(module.getCredit()));
        }
    }

    public static class ModulesDiff extends DiffUtil.ItemCallback<ModuleEntity> {


        @Override
        public boolean areItemsTheSame(@NonNull ModuleEntity oldItem, @NonNull ModuleEntity newItem) {
            if(oldItem.getSigle().equals(newItem.getSigle()))
                return true;

            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ModuleEntity oldItem, @NonNull ModuleEntity newItem) {
            if(oldItem.getSigle().equals(newItem.getSigle()))
                return true;

            return false;
        }
    }

}
