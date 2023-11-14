package com.ccastro.pokedexapp.presentation.components.features

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ccastro.pokedexapp.presentation.screens.MoveName
import com.ccastro.pokedexapp.presentation.ui.theme.Blue60

@Composable
fun Moves(modifier: Modifier = Modifier, moves: List<MoveName>) {

    LazyHorizontalStaggeredGrid(
        modifier = Modifier
            .wrapContentWidth()
            .height(100.dp),
        verticalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(0.dp),
        horizontalItemSpacing = 4.dp,
        rows = StaggeredGridCells.Fixed(3)
    ) {

        items(moves) {
            AssistChip(
                modifier = Modifier
                    .padding(4.dp)
                    .wrapContentSize(),
                colors = AssistChipDefaults.assistChipColors(containerColor = Blue60),
                onClick = { },
                label = {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = modifier.wrapContentSize()
                )
            })
        }
    }

}