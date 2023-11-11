package com.ccastro.pokedexapp.presentation.components.images

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp

@Composable
fun ImagePresentationCard(urlImage: String, pagerOffset: Float, size: Int, modifier: Modifier = Modifier ) {
    Surface(
        modifier = modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(10.dp))
            .graphicsLayer {
                lerp( start = 0.55f, stop = 1f, fraction = 1f - pagerOffset.coerceIn(
                    minimumValue = 0f,
                    maximumValue = 1f
                )
                ).also { scale ->
                    scaleX = scale
                    scaleY = scale
                }
                alpha = lerp(
                    start = 0.50f, // Transparencia
                    stop = 1f,
                    fraction = 1f - pagerOffset.coerceIn(
                        minimumValue = 0f,
                        maximumValue = 1f
                    )
                )
            },
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 0.dp,
        color = Color.Transparent,
        contentColor = Color.Transparent
    ) {
        AsyncImage(url = urlImage, Modifier.size(size.dp))
    }
}