package com.zlasher.rick_and_morty.model

import com.google.gson.annotations.SerializedName
import com.zlasher.rick_and_morty.detail.CharacterDetail

data class CharactersResponse(
    var info: Info,
    @SerializedName("results") var character: List<CharacterDetail>
)
