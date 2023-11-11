package com.ccastro.pokedexapp.presentation.components.features

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ccastro.pokedexapp.presentation.ui.theme.PokedexAppTheme

@Composable
fun column() {
    Column {
        ListItem(
            headlineContent = { Text("Three line list item") },
            supportingContent = {
                Text("Secondary text that is long and perhaps goes onto another line")
            },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            },
            trailingContent = { Text("meta") }
        )
        Divider()
    }
}

@Preview()
@Composable
fun previewColum() {
    PokedexAppTheme {
        column()
    }
}