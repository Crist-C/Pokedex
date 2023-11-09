package com.ccastro.pokedexapp.presentation.screens.pokemons.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ccastro.pokedexapp.core.Constants
import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.presentation.components.SearchingField
import com.ccastro.pokedexapp.presentation.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonListScreen(navHostController: NavHostController) {

    Scaffold (
        topBar = {
            SearchingField(modifier = Modifier.padding(top = 8.dp))
        },
        content = {
            PokemonListContent(
                modifier = Modifier.padding(top = 64.dp),
                navHostController = navHostController
            )
        },
        bottomBar = {}
    )
}


fun gotoDetail(pokemon: Pokemon, navHostController: NavHostController) {
    Constants.pokemonChosed = pokemon
    navHostController.navigate(AppScreens.PokemonDetail.route)
}