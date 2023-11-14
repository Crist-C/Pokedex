package com.ccastro.pokedexapp.presentation.screens.pokemons.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.presentation.components.userInteraction.LoadingScreen
import com.ccastro.pokedexapp.presentation.components.pokemons.ListPokemons
import com.ccastro.pokedexapp.presentation.components.pokemons.PokemonErrorMessageScreen


@Composable
fun PokemonListContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: PokemonListViewModel = hiltViewModel()) {

    val loading by viewModel.loading.collectAsState()
    val pokemons by viewModel.pokemonList.collectAsState()
    val message by viewModel.errorMessage.collectAsState()

    if (loading) {
        LoadingScreen()
    } else {
        if(message.isNotEmpty()) {
            PokemonErrorMessageScreen(message = message)
        }
        if(pokemons.isNotEmpty()) {
            ListPokemons(modifier, navHostController, pokemons) {pokemon: Pokemon ->
                gotoDetail(pokemon = pokemon, navHostController = navHostController)
            }
        }
    }
}

