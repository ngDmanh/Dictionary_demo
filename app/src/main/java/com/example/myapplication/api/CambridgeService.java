package com.example.myapplication.api;

import com.example.myapplication.models_new.Word;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CambridgeService {
    @GET("words/{word}")
    Call<Word> searchByKeyword(@Path("word") String keyword);
}
