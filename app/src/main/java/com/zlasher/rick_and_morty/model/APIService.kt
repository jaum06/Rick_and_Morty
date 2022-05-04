package com.zlasher.rick_and_morty.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET("character")
    suspend fun getCharacters(): Response<CharactersResponse>

}