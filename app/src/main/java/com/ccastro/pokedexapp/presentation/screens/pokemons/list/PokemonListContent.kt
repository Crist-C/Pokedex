package com.ccastro.pokedexapp.presentation.screens.pokemons.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun PokemonListContent(
    navHostController: NavHostController,
    viewModel: PokemonListViewModel = hiltViewModel()) {
    Text(text = "Pokemon List!")
}