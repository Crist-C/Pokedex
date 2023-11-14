package com.ccastro.pokedexapp.presentation.components.pokemons

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
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
import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.presentation.screens.pokemons.list.PokemonListViewModel
import com.ccastro.pokedexapp.presentation.ui.theme.Blue20
import okhttp3.internal.wait

@Composable
fun ListPokemons(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    pokemons: List<Pokemon>,
    onPokemonClick: (Pokemon) -> Unit = {}
) {

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

        items(pokemons) { pokemonItem ->
            PokemonBasicCard(pokemon = pokemonItem, modifier = Modifier.fillMaxWidth()) {
                pokemon: Pokemon -> onPokemonClick(pokemon)
            }
        }

    }
}
