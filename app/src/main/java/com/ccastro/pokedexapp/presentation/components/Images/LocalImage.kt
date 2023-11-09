package com.ccastro.pokedexapp.presentation.components.Images

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.ccastro.pokedexapp.R

@Composable
fun LocalImage(id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = stringResource(R.string.default_image_description),
        modifier = Modifier
            .fillMaxSize()
    )
}