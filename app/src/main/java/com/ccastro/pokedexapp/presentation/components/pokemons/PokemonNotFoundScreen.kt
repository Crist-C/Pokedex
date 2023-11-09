package com.ccastro.pokedexapp.presentation.components.pokemons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ccastro.pokedexapp.R
import com.ccastro.pokedexapp.presentation.ui.theme.PokedexAppTheme

@Composable
fun PokemonNotFoundScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.mensaje_no_se_encontro_pokemon),
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