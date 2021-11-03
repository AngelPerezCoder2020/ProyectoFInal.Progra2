package com.example.sayagymapp.FragmentosSecundarios.Adaptadores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sayagymapp.ActivitiesPrincipales.HomeActivity;
import com.example.sayagymapp.ClasesSecundarias.Couch;
import com.example.sayagymapp.DataBaseConectorPackage.DataBaseConector;
import com.example.sayagymapp.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class MyItemEntrenadoresViewAdapter extends FirestoreRecyclerAdapter<Couch,MyItemEntrenadoresViewAdapter.ViewHolder>{

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
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext()).setTitle("Escogiendo Entrenador")
                        .setMessage("Deseas Elegir a "+couch.getNombre()+" Como tu entrenador Personal?")
                        .setPositiveButton("CI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DataBaseConector.EstablecerEntrenador(couch.getNombre());
                                DataBaseConector.ObtenerReferencia(v.getContext(), HomeActivity.EmailIngresado);
                            }
                        })
                        .setNegativeButton("no",null)
                        .show();
            }
        });
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView Nombre;

        public ViewHolder(View v) {
            super(v);
            Nombre = v.findViewById(R.id.NombreEntrenadorTextV);
        }
    }
}