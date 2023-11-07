package com.ccastro.pokedexapp.presentation.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.SubcomposeAsyncImage
import com.ccastro.pokedexapp.R

@Composable
fun AsyncImage(url: String, modifier: Modifier = Modifier) {

    SubcomposeAsyncImage(
        model = url,
        loading = {
            CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.Center))
        },
        alignment = Alignment.Center,
        modifier = modifier,
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(R.string.default_image_description)
    )

}
