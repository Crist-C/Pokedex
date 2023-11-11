package com.ccastro.pokedexapp.presentation.components.pokemons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ccastro.pokedexapp.presentation.screens.pokemons.list.PokemonListViewModel
import com.ccastro.pokedexapp.presentation.ui.theme.PokedexAppTheme

@Composable
fun PokemonNotFoundScreen(modifier: Modifier = Modifier, viewModel: PokemonListViewModel = hiltViewModel()) {

    val message by viewModel.errorMessage.collectAsState()

    Column(
        modifier = modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxSize(),
            text = message,
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun PokemonNotFoundScreenPreview() {
    PokedexAppTheme {
        PokemonNotFoundScreen()
    }
}