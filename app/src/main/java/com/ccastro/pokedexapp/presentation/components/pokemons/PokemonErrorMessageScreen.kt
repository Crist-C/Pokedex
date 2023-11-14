package com.ccastro.pokedexapp.presentation.components.pokemons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ccastro.pokedexapp.R
import com.ccastro.pokedexapp.presentation.screens.pokemons.list.PokemonListViewModel
import com.ccastro.pokedexapp.presentation.ui.theme.PokedexAppTheme

@Composable
fun PokemonErrorMessageScreen(modifier: Modifier = Modifier, message: String) {

    Column(
        modifier = modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = message,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PokemonNotFoundScreenPreview() {
    PokedexAppTheme {
        PokemonErrorMessageScreen(message = "Pokemon not found!")
    }
}