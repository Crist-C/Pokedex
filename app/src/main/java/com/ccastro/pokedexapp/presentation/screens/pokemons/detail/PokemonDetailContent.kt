package com.ccastro.pokedexapp.presentation.screens.pokemons.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ccastro.pokedexapp.R
import com.ccastro.pokedexapp.core.Constants.pokemonChosed
import com.ccastro.pokedexapp.domain.models.Sprites
import com.ccastro.pokedexapp.presentation.components.features.Moves
import com.ccastro.pokedexapp.presentation.components.features.Sprites
import com.ccastro.pokedexapp.presentation.components.features.Types
import com.ccastro.pokedexapp.presentation.components.images.ImagesPresentation
import com.ccastro.pokedexapp.presentation.components.pokemons.Attribute
import com.ccastro.pokedexapp.presentation.components.pokemons.PokemonInfoCard
import com.ccastro.pokedexapp.presentation.components.pokemons.PokemonStat
import com.ccastro.pokedexapp.presentation.components.pokemons.PokemonStatList
import com.ccastro.pokedexapp.presentation.ui.theme.Blue20
import com.ccastro.pokedexapp.presentation.ui.theme.Blue200
import com.ccastro.pokedexapp.presentation.ui.theme.BlueVariant40

@Composable
fun PokemonDetailContent() {

    val scrollState = rememberScrollState()
    Column(
        Modifier
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

        Moves(moves = pokemonChosed.getMoveList())

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
