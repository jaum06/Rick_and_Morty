package com.zlasher.rick_and_morty.model

import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("character")
    suspend fun getCharacters(): Response<CharactersResponse>

    @GET("episode")
    suspend fun getEpisodes(): Response<EpisodesResponse>
}