package com.ccastro.pokedexapp.presentation.screens.pokemons.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ccastro.pokedexapp.core.Constants.pokemonChosed
import com.ccastro.pokedexapp.presentation.components.images.ImagesPresentation

@Composable
fun PokemonDetailContent(navHostController: NavHostController) {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        ImagesPresentation(
            modifier = Modifier.fillMaxHeight(0.3f).fillMaxWidth(0.95f),
            imagesList = pokemonChosed.sprites.getImageUrlList(), imagesSize = 200)
        Text(text = pokemonChosed.name, fontStyle = MaterialTheme.typography.titleMedium.fontStyle)
    }
}