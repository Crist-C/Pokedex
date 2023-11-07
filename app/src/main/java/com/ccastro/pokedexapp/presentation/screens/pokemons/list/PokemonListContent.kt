package com.ccastro.pokedexapp.presentation.screens.pokemons.list

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.presentation.components.PokemonBasicCard


@Composable
fun PokemonListContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: PokemonListViewModel = hiltViewModel()) {
    //Text(text = "Pokemon List!")

    var pokemons: List<Pokemon> = emptyList()

    viewModel.pokemonList.observeForever { pokemons = it }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )

            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(bottom = 150.dp)
    ) {

        if(pokemons.isEmpty() == true) {
            item {
                Text(
                    text = "Descargando Pokemons",
                    textAlign = TextAlign.Center
                )
            }
        } else {
            items(pokemons) { pokemon ->
                PokemonBasicCard(pokemon = pokemon)
            }
        }

    }
}
