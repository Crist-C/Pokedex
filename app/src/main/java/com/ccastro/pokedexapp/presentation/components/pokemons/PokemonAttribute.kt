package com.ccastro.pokedexapp.presentation.components.pokemons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ccastro.pokedexapp.presentation.ui.theme.BlueVariant40
import com.ccastro.pokedexapp.presentation.ui.theme.PokedexAppTheme

@Composable
fun Attribute(
    modifier: Modifier = Modifier,
    title: String,
    content: List<String>,
) {
    Column(
        modifier = modifier.fillMaxWidth().wrapContentHeight(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant)

            Column {
                content.forEach {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.End
                    )
                }
            }
        }
        Divider(modifier = Modifier.wrapContentSize(), thickness = 1.dp, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun AttributePreview() {
    PokedexAppTheme {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()) {
            item {
                //Attribute(title = "Habilidades", content = listOf("Mudar", "Intimidar"), lazyListScope = this@LazyColumn)
            }
        }
    }
}