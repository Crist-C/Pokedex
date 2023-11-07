package com.ccastro.pokedexapp.domain.models.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Ability(
    @Expose @SerializedName("ability") val ability: AbilityInfo,
    @Expose @SerializedName("is_hidden") val isHidden: Boolean,
    @Expose @SerializedName("slot") val slot: Int
)
