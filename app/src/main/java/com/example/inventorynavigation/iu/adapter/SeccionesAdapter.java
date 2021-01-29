package com.example.inventorynavigation.iu.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventorynavigation.R;
import com.example.inventorynavigation.data.model.Estanteria;

import java.util.List;

public class SeccionesAdapter extends RecyclerView.Adapter<SeccionesAdapter.ViewHolder> {

    List<Estanteria> list;
    OnSeccionesListener listener;

    public interface OnSeccionesListener extends View.OnClickListener, View.OnLongClickListener{
        void onClick(View v);
        boolean onLongClick(View v);
    }

    public SeccionesAdapter(List<Estanteria> list) {
        this.list = list;
    }

    public SeccionesAdapter(List<Estanteria> list, OnSeccionesListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_secciones,parent,false);
        view.setOnClickListener(listener);
        view.setOnLongClickListener(listener);
        return new ViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtEstanteria.setText(list.get(position).getEstanteria());
        holder.txtDependencia.setText(list.get(position).getDependencia().getShortname());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(List<Estanteria> list) {
        this.list.clear();
        this.list.addAll(list);
        this.notifyDataSetChanged();
    }


    public void delete(Estanteria deleted) {
        list.remove(deleted);
        this.notifyDataSetChanged();
    }


    public void add(Estanteria deleted) {
        list.add(deleted);
        //Collections.sort(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtDependencia;
        TextView txtEstanteria;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDependencia = itemView.findViewById(R.id.txtSeccionesDependencia);
            txtEstanteria = itemView.findViewById(R.id.txtSeccionesEstanteria);
        }
    }

    public Estanteria getItem(int position){
        return list.get(position);
    }
}
