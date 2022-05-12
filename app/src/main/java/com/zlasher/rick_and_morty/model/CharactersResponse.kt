package com.zlasher.rick_and_morty.model

import com.google.gson.annotations.SerializedName
import com.zlasher.rick_and_morty.detail.CharacterDetail

data class CharactersResponse(
    @SerializedName("info") var info: Info,
    @SerializedName("results") var character: List<CharacterDetail>
)
