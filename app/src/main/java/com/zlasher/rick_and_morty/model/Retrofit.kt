package com.zlasher.rick_and_morty.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface Retrofit {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}