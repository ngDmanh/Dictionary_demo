package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models_new.Definition;

import java.util.ArrayList;
import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningAdapter.MeaningViewHolder> {
    private final List<Definition> listMeaning;

    public MeaningAdapter(List<Definition> definitions) {
        this.listMeaning = definitions == null ? new ArrayList<>() : definitions;
    }

    @NonNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meaning, parent, false);
        return new MeaningViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {
        if (position < listMeaning.size()) {
            Definition definition = listMeaning.get(position);
            if (definition != null) holder.binData(definition);
        }
    }

    @Override
    public int getItemCount() {
        return listMeaning.size();
    }

    public static class MeaningViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvMeaning;
        private final RecyclerView rcvExamples;

        public MeaningViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMeaning = itemView.findViewById(R.id.tvMeaning);
            rcvExamples = itemView.findViewById(R.id.rcvExamples);
        }

        public void binData(@NonNull Definition definition) {
            tvMeaning.setText(definition.getDefinition());
            List<String> list = new ArrayList<String>();
            list.add(definition.getExample());
            ExampleAdapter exampleAdapter = new ExampleAdapter(list);
            rcvExamples.setAdapter(exampleAdapter);
            exampleAdapter.notifyDataSetChanged();
        }
    }
}
