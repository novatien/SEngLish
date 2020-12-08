package com.notin.senglish.database.api;

import com.notin.senglish.model.English;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EnglishApi {
    @GET("senglish/english.json")
    Call<List<English>> getListEnglish();
}