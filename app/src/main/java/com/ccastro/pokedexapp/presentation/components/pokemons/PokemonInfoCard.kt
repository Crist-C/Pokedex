package com.ccastro.pokedexapp.presentation.components.pokemons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ccastro.pokedexapp.presentation.screens.AttributeContent
import com.ccastro.pokedexapp.presentation.screens.AttributeName
import com.ccastro.pokedexapp.presentation.ui.theme.BlueVariant40

@Composable
fun PokemonInfoCard(modifier: Modifier = Modifier, attributesMap: Map<AttributeName, AttributeContent>) {

    Column(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .wrapContentHeight()
            .border(
                BorderStroke(1.dp, BlueVariant40),
                shape = RoundedCornerShape(
                    topStartPercent = 10, topEndPercent = 10,
                    bottomEndPercent = 10, bottomStartPercent = 10)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp),
    ) {

        attributesMap.keys.forEach {attributeName ->
            Attribute(title = attributeName, content = attributesMap[attributeName]!!)
        }

    }

}