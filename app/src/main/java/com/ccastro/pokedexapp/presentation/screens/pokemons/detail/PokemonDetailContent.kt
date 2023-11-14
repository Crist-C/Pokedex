package com.ccastro.pokedexapp.presentation.screens.pokemons.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ccastro.pokedexapp.R
import com.ccastro.pokedexapp.core.Constants.pokemonChosed
import com.ccastro.pokedexapp.presentation.components.features.Moves
import com.ccastro.pokedexapp.presentation.components.features.Sprites
import com.ccastro.pokedexapp.presentation.components.features.Types
import com.ccastro.pokedexapp.presentation.components.pokemons.PokemonInfoCard
import com.ccastro.pokedexapp.presentation.components.features.PokemonStatList
import com.ccastro.pokedexapp.presentation.ui.theme.Blue20

@Composable
fun PokemonDetailContent(modifier: Modifier = Modifier, viewModel: PokemonDetailViewModel = hiltViewModel()) {

    val moves by viewModel.moveList.collectAsState()

    val scrollState = rememberScrollState()
    Column(
        modifier
            .fillMaxSize()
            .background(Blue20)
            .verticalScroll(scrollState)
            .padding(bottom = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {

        Sprites()

        TitleText(stringResource(R.string.types))

        Types(types = pokemonChosed.types)

        TitleText(stringResource(R.string.information))

        PokemonInfoCard(attributesMap = pokemonChosed.getAttributes())

        TitleText(stringResource(R.string.stats))

        PokemonStatList(statMap = pokemonChosed.getStats())

        TitleText(stringResource(R.string.moves))

        Moves(moves = moves)

    }
}

@Composable
fun TitleText(text: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        text = text,
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )
}
