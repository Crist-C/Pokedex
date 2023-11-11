package com.ccastro.pokedexapp.presentation.components.features

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import com.ccastro.pokedexapp.presentation.screens.MoveName

@Composable
fun Moves(modifier: Modifier = Modifier, moves: List<MoveName>) {
    val maxMovesToShow = 10

    moves.fastForEachIndexed { i, moveName ->

        if(i < maxMovesToShow) {
            Surface(
                modifier = Modifier.wrapContentSize()
            ) {
                Text(
                    text = moveName,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = modifier
                )
            }
        }
    }
}