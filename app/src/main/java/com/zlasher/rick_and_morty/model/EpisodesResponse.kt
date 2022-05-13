package com.zlasher.rick_and_morty.model

import com.google.gson.annotations.SerializedName
import com.zlasher.rick_and_morty.detail.EpisodeDetail

data class EpisodesResponse(
    @SerializedName("info") var info: Info,
    @SerializedName("results") var episodeList: List<EpisodeDetail>
)
