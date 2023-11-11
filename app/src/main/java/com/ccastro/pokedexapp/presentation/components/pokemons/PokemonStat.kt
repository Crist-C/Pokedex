package com.ccastro.pokedexapp.presentation.components.pokemons

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ccastro.pokedexapp.domain.models.Pokemon


@Composable
fun PokemonStatList(modifier: Modifier = Modifier, statMap: Map<String, Int>) {
    statMap.entries.toList().forEach {
        PokemonStat(stat = it.toPair())
    }
}

@Composable
fun PokemonStat(modifier: Modifier = Modifier, stat: Pair<String, Int>) {

    val statIndicationValue by animateFloatAsState(
        targetValue = stat.second / Pokemon.statMaxValue.toFloat(), label = ""
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stat.first.uppercase(),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LinearProgressIndicator(
                modifier = modifier
                    .wrapContentHeight()
                    .height(4.dp)
                    .border(0.5.dp, color = Color.Gray),
                progress = statIndicationValue,
                color = Color(0xFFFEAE63),
                trackColor = Color.White
            )
            StatValuesIndicator(stat.second, Pokemon.statMaxValue)

        }
    }
}

@Composable
fun StatValuesIndicator(actualValue: Int, referenceValue: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "$actualValue/",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
        )
        Text(
            text = "$referenceValue",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFFFE7F09)
        )

    }
}