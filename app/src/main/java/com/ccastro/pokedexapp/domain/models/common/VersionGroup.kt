package com.ccastro.pokedexapp.domain.models.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VersionGroup(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)
