package com.ccastro.pokedexapp.presentation.screens.pokemons.list

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.pokedexapp.core.Constants
import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.presentation.components.userInteraction.SearchingField
import com.ccastro.pokedexapp.presentation.navigation.AppScreens
import com.ccastro.pokedexapp.presentation.ui.theme.Blue20
import com.ccastro.pokedexapp.presentation.ui.theme.Blue60
import com.ccastro.pokedexapp.presentation.ui.theme.Blue80
import com.ccastro.pokedexapp.presentation.ui.theme.BlueVariant40
import com.ccastro.pokedexapp.presentation.ui.theme.PokedexAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonListScreen(navHostController: NavHostController) {

    Scaffold (
        topBar = {
            SearchingField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 24.dp, end = 40.dp, top = 8.dp, bottom = 8.dp
                    )
                    )
        },
        content = {
            DropDownMenu()
            PokemonListContent(
                modifier = Modifier.padding(top = 68.dp),
                navHostController = navHostController
            )
        },
        bottomBar = {},
    )

}

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


        DropdownMenu(
            modifier = Modifier.background(Blue60),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {

            for (i in 1..5){
                DropdownMenuItem(
                    text = { Text("Generacion $i") },
                    onClick = {
                        viewModel.getAllPokemons(i)
                        expanded = false
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
}

fun gotoDetail(pokemon: Pokemon, navHostController: NavHostController) {
    Constants.pokemonChosed = pokemon
    navHostController.navigate(AppScreens.PokemonDetail.route)
}

@Preview
@Composable
fun DropDownMenuPreview() {
    PokedexAppTheme {
        DropDownMenu()
    }
}