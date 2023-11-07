package com.ccastro.pokedexapp.core

import com.ccastro.pokedexapp.domain.models.Pokemon
import com.google.gson.Gson

object Constants {
    const val TAG: String = "APPLOG"
    var pokemonChosed: Pokemon? = null
    val gson = Gson()
}