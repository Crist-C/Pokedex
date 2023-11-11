package com.ccastro.pokedexapp.presentation.components.features

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ccastro.pokedexapp.core.Constants
import com.ccastro.pokedexapp.presentation.components.images.ImagesPresentation

@Composable
fun Sprites(modifier: Modifier = Modifier) {
    val cardColor = Constants.pokemonChosed.types.first().getColorFromType()
    Card(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .shadow(
                6.dp,
                shape = RoundedCornerShape(
                    topEnd = 0.dp, topStart = 0.dp,
                    bottomEnd = 60.dp, bottomStart = 60.dp
                ), ambientColor = Color.Black, spotColor = cardColor
            )
            .clip(
                shape = RoundedCornerShape(
                    topEnd = 0.dp, topStart = 0.dp,
                    bottomEnd = 60.dp, bottomStart = 60.dp
                )
            ),
        colors = CardDefaults.cardColors(containerColor = Constants.pokemonChosed.types.first().getColorFromType())
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            ImagesPresentation(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .sizeIn(maxHeight = 300.dp),
                imagesList = Constants.pokemonChosed.sprites.getImageUrlList(), imagesSize = 600)
        }
    }
}