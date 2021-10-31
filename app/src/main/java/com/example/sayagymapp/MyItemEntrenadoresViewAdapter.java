package com.example.sayagymapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sayagymapp.placeholder.PlaceholderContent.PlaceholderItem;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemEntrenadoresViewAdapter extends FirestoreRecyclerAdapter<Couch,MyItemEntrenadoresViewAdapter.ViewHolder> {

    public MyItemEntrenadoresViewAdapter(@NonNull FirestoreRecyclerOptions<Couch> options) {
        super(options);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_entrenadores, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull Couch couch) {
        viewHolder.Nombre.setText(couch.getNombre());
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView Nombre;

        public ViewHolder(View v) {
            super(v);
            Nombre = v.findViewById(R.id.NombreEntrenadorTextV);
        }
    }
}