package com.ccastro.pokedexapp.presentation.components.Images

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.ccastro.pokedexapp.R

@Composable
fun AsyncImage(url: String, modifier: Modifier = Modifier) {

    SubcomposeAsyncImage(
        model = url,
        alignment = Alignment.Center,
        modifier = modifier,
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(R.string.default_image_description)
    ) {
        when(painter.state){
            is AsyncImagePainter.State.Error -> LocalImage(R.drawable.interrogation_pokemon)
            is AsyncImagePainter.State.Loading -> {
                Box {
                    LocalImage(id = R.drawable.pokeball_default_image)
                    CircularProgressIndicator(modifier.size(24.dp))
                }
            }
            else -> SubcomposeAsyncImageContent()
        }
    }

}
