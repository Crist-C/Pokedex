package com.ccastro.pokedexapp.presentation.components.userInteraction

import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ccastro.pokedexapp.presentation.screens.pokemons.list.PokemonListViewModel
import com.ccastro.pokedexapp.presentation.ui.theme.Blue20
import com.ccastro.pokedexapp.presentation.ui.theme.Blue200
import com.ccastro.pokedexapp.presentation.ui.theme.Blue80

@Composable
fun SearchingField(modifier: Modifier = Modifier, viewModel: PokemonListViewModel = hiltViewModel()) {

    val searchText by viewModel.searchText.collectAsState()

    OutlinedTextField(
        value = searchText,
        onValueChange = viewModel::onSearchTextChange,
        maxLines = 1,
        singleLine = true,
        modifier = modifier
            .background(Color.Transparent)
            .border(width = 8.dp, color = Blue20),
        placeholder = {
            Text(text = "Search")
        },
        leadingIcon = {
            Image(imageVector = Icons.Outlined.Search, contentDescription = "",
                colorFilter = ColorFilter.tint(Blue200))
        },
        trailingIcon = {
            ClickableCustomColor (onClick = { viewModel.onSearchTextChange("") } ) {
                Image(imageVector = Icons.Outlined.Clear, contentDescription = "",
                    colorFilter = ColorFilter.tint(Blue200))

            }
        }
    )

}

@Composable
fun ClickableCustomColor( color: Color = Blue80, onClick: () -> Unit = {}, content: @Composable () -> Unit) {
    val indication = rememberRipple(color = color)
    CompositionLocalProvider(LocalIndication provides indication) {
        Surface(modifier = Modifier.clickable(onClick = onClick), content = content)
    }
}
