package com.ccastro.pokedexapp.presentation.screens.pokemons.list

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonListScreen(navHostController: NavHostController) {

    Scaffold (
        topBar = {},
        content = {
                  PokemonListContent(navHostController)
        },
        bottomBar = {}
    )
}