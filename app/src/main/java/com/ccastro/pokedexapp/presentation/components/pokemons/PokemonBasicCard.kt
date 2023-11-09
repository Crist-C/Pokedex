package com.ccastro.pokedexapp.presentation.components.pokemons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.presentation.components.images.AsyncImage

@Composable
fun PokemonBasicCard(modifier: Modifier = Modifier, pokemon: Pokemon, onClick: (Pokemon) -> Unit = {}) {

    Surface (
        modifier = Modifier
            .wrapContentSize().clickable { onClick(pokemon) },
        shape = MaterialTheme.shapes.large,
        shadowElevation = 6.dp
    ) {

        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 16.dp, top = 12.dp, bottom = 12.dp, end = 20.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                url = pokemon.sprites.frontDefault!!,
                modifier = modifier
                    .sizeIn(100.dp,100.dp, 130.dp, 130.dp).clip(RoundedCornerShape(10.dp)),
            )

            Text(text = pokemon.name, style = MaterialTheme.typography.titleMedium)

        }
    }
}
