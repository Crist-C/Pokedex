package com.ccastro.pokedexapp.presentation.screens.pokemons.detail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun PokemonDetailScreen(navHostController: NavHostController) {

    Scaffold (
        topBar = {},
        content = {
                  PokemonDetailContent(navHostController)
        },
        bottomBar = {}
    )
}