package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models_new.Phonetics;
import com.example.myapplication.models_new.Word;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    private List<Word> listWord = new ArrayList<>();

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
        return new WordViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if (position < listWord.size()) {
            Word word = listWord.get(position);
            if (word != null) holder.bindData(word);
        }
    }

    @Override
    public int getItemCount() {
        return listWord.size();
    }

    public void setListWord(List<Word> listWord) {
        this.listWord = listWord;
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle, tvGrammar;
        private final TextView tvPronounceUS;
        private final TextView tvPronounceUK;
        private final RecyclerView rcvContents;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvGrammar = itemView.findViewById(R.id.tvGrammar);
            tvPronounceUS = itemView.findViewById(R.id.tvPronounceUS);
            tvPronounceUK = itemView.findViewById(R.id.tvPronounceUK);
            rcvContents = itemView.findViewById(R.id.rcvContents);
        }

        public void bindData(@NonNull Word word) {
            tvTitle.setText(word.getTitle());
            tvGrammar.setText(word.getGrammar());
            Phonetics phonetics = word.getPronounce();
            tvPronounceUS.setText(phonetics == null ? "" : phonetics.getText());
            tvPronounceUK.setText(phonetics == null ? "" : phonetics.getText());
            ContentAdapter contentAdapter = new ContentAdapter(word.getContents());
            rcvContents.setHasFixedSize(true);
            rcvContents.setAdapter(contentAdapter);
            contentAdapter.notifyDataSetChanged();
        }
    }
}
