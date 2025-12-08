package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private final List<String> listExample;

    public ExampleAdapter(List<String> listExample) {
        this.listExample = listExample == null ? new ArrayList<>() : listExample;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_example, parent, false);
        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        if (position < listExample.size()) {
            String example = listExample.get(position);
            if (example != null) holder.binData(example);
        }
    }

    @Override
    public int getItemCount() {
        return listExample.size();
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvExample;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvExample = itemView.findViewById(R.id.tvExample);
        }

        public void binData(@NonNull String example) {
            tvExample.setText(example);
        }
    }
}
