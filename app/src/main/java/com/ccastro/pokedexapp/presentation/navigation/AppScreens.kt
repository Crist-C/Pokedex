package com.ccastro.pokedexapp.presentation.navigation

import java.util.Objects

sealed class AppScreens(val route: String) {
    object PokemonDetail: AppScreens("detail")
    object PokemonList: AppScreens("list") {

    }
}
