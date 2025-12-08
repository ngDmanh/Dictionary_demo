package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models_new.Meaning;

import java.util.ArrayList;
import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {
    private final List<Meaning> listContent;

    public ContentAdapter(List<Meaning> listContent) {
        this.listContent = listContent == null ? new ArrayList<>() : listContent;
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        if (position < listContent.size()) {
            Meaning meaning = listContent.get(position);
            if (meaning != null) holder.binData(meaning);
        }
    }

    @Override
    public int getItemCount() {
        return listContent.size();
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvGuideWord;
        private final RecyclerView rcvMeanings;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGuideWord = itemView.findViewById(R.id.tvGuideWord);
            rcvMeanings = itemView.findViewById(R.id.rcvMeanings);
        }

        public void binData(@NonNull Meaning meaning) {
            tvGuideWord.setText(meaning.getPartOfSpeech());
            MeaningAdapter meaningAdapter = new MeaningAdapter(meaning.getDefinitions());
            rcvMeanings.setAdapter(meaningAdapter);
            meaningAdapter.notifyDataSetChanged();
        }
    }


}
