package com.ccastro.pokedexapp.presentation.navigation

sealed class AppScreens(val route: String) {
    object PokemonDetail: AppScreens("detail")
    object PokemonList: AppScreens("list") {

    }
}
