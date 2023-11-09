package com.ccastro.pokedexapp.presentation.components.pokemons

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.pokedexapp.presentation.screens.pokemons.list.PokemonListViewModel

@Composable
fun ListPokemons(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: PokemonListViewModel = hiltViewModel()
) {

    val pokemons by viewModel.pokemonList.collectAsState()
    val loading by viewModel.loading.collectAsState()

    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Adaptive(140.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 24.dp)
    ) {

        if(pokemons.isEmpty() && !loading) {
            item {
                PokemonNotFoundScreen()
            }
        } else {
            items(pokemons) { pokemon ->
                PokemonBasicCard(pokemon = pokemon, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}