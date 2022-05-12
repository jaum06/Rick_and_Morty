package com.zlasher.rick_and_morty.detail

import com.zlasher.rick_and_morty.model.Location
import com.zlasher.rick_and_morty.model.Origin
import java.io.Serializable

data class CharacterDetail(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) : Serializable