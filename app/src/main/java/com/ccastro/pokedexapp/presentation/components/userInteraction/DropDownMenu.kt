package com.ccastro.pokedexapp.presentation.components.userInteraction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ccastro.pokedexapp.R
import com.ccastro.pokedexapp.presentation.screens.pokemons.list.PokemonListViewModel
import com.ccastro.pokedexapp.presentation.ui.theme.Blue60
import com.ccastro.pokedexapp.presentation.ui.theme.PokedexAppTheme


@Composable
fun DropDownMenu(modifier: Modifier = Modifier, viewModel: PokemonListViewModel = hiltViewModel()) {

    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .padding(end = 4.dp, top = 12.dp)
            .fillMaxSize()
            .wrapContentSize(Alignment.TopEnd)
    ) {

        IconButton(onClick = { expanded = true }) {
            Icon(
                Icons.Default.MoreVert,
                contentDescription = "Localized description",
                Modifier.scale(1.4f))
        }

        ChooseGenerationMenu(
            expanded = expanded,
            onDismiss = { expanded = false },
        ) {
            viewModel.getAllPokemons(it)
            expanded = false
        }

    }
}

@Composable
fun ChooseGenerationMenu(
    modifier: Modifier = Modifier,
    expanded: Boolean, onDismiss: () -> Unit,
    onClick: (Int) -> Unit) {

    DropdownMenu(
        modifier = modifier.background(Blue60),
        expanded = expanded,
        onDismissRequest = { onDismiss() }
    ) {

        for (i in 1..9){
            DropdownMenuItem(
                text = { Text(stringResource(R.string.generation, i)) },
                onClick = {
                    onClick(i)
                },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.ArrowForward,
                        contentDescription = null
                    )
                })

        }

    }
}

@Preview
@Composable
fun DropDownMenuPreview() {
    PokedexAppTheme {
        DropDownMenu()
    }
}