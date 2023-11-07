package com.ccastro.pokedexapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ccastro.pokedexapp.R
import com.ccastro.pokedexapp.domain.models.Pokemon

@Composable
fun PokemonBasicCard(modifier: Modifier = Modifier, pokemon: Pokemon) {
    Card(
        modifier = Modifier.wrapContentHeight().fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.wrapContentHeight().fillMaxWidth()
        ) {
            AsyncImage(
                url = pokemon.sprites.frontDefault?: stringResource(R.string.url_default_pokemon_onlist_image)
            )
            Text(text = pokemon.name)
        }
    }
}