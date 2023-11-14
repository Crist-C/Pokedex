package com.ccastro.pokedexapp.presentation.screens.pokemons.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ccastro.pokedexapp.core.Constants
import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.presentation.components.userInteraction.DropDownMenu
import com.ccastro.pokedexapp.presentation.components.userInteraction.SearchingField
import com.ccastro.pokedexapp.presentation.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonListScreen(navHostController: NavHostController) {

    Scaffold (
        topBar = {
            SearchingField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 40.dp, top = 8.dp, bottom = 8.dp)
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


fun gotoDetail(pokemon: Pokemon, navHostController: NavHostController) {
    Constants.pokemonChosed = pokemon
    navHostController.navigate(AppScreens.PokemonDetail.route)
}
