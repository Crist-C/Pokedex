package com.ccastro.pokedexapp.presentation.components.images

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImagesPresentation(imagesList: List<String>, modifier: Modifier = Modifier, imagesSize: Int) {

    val pageState = rememberPagerState(initialPage = 1)

    Column(modifier = modifier.fillMaxSize(),verticalArrangement = Arrangement.Top)
    {

        HorizontalPager(
            count = imagesList.size, state = pageState,
            contentPadding = PaddingValues(horizontal = 80.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        { page ->
            ImagePresentationCard(
                urlImage = imagesList[page],
                calculateCurrentOffsetForPage(page).absoluteValue,
                modifier = Modifier, size = imagesSize)
        }
        ImagePresentationDots(imagesList.size, pageState, Modifier.padding(top = 4.dp))

    }

}