package com.ccastro.pokedexapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ccastro.pokedexapp.presentation.screens.pokemons.detail.PokemonDetailScreen
import com.ccastro.pokedexapp.presentation.screens.pokemons.list.PokemonListScreen

@Composable
fun AppNavigation(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = AppScreens.PokemonList.route
    ){

        composable(route = AppScreens.PokemonList.route) {
            PokemonListScreen(navHostController)
        }

        composable(route = AppScreens.PokemonDetail.route) {
            PokemonDetailScreen(navHostController)
        }
    }
}