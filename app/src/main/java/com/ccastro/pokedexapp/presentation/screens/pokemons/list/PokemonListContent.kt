package com.ccastro.pokedexapp.presentation.screens.pokemons.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.presentation.components.LoadingScreen
import com.ccastro.pokedexapp.presentation.components.pokemons.ListPokemons


@Composable
fun PokemonListContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: PokemonListViewModel = hiltViewModel()) {

    val loading by viewModel.loading.collectAsState()

    if (loading) {
        LoadingScreen()
    } else{
        ListPokemons(modifier, navHostController, viewModel) {pokemon: Pokemon ->
            gotoDetail(pokemon = pokemon, navHostController = navHostController)
        }
    }
}

