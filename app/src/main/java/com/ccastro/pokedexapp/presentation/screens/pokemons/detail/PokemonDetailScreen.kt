package com.ccastro.pokedexapp.presentation.screens.pokemons.detail

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.ccastro.pokedexapp.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonDetailScreen(navHostController: NavHostController) {

    Scaffold(
        topBar = {
                 IconButton(
                     onClick = { navHostController.popBackStack() }) {
                     Icon(
                         imageVector = Icons.Filled.ArrowBack,
                         contentDescription = stringResource(id = R.string.default_image_description)
                     )
                 }
        },
        content = {
            PokemonDetailContent()
        },
        bottomBar = {}
    )
}