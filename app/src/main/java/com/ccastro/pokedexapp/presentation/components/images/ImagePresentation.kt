package com.ccastro.pokedexapp.presentation.components.images

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.ccastro.pokedexapp.core.Constants
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import java.util.Locale
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImagesPresentation(imagesList: List<String>, modifier: Modifier = Modifier, imagesSize: Int) {

    val pageState = rememberPagerState(initialPage = 1)

    Box {
        Column(modifier = modifier.fillMaxSize(),verticalArrangement = Arrangement.Top)
        {

            HorizontalPager(
                count = imagesList.size, state = pageState,
                contentPadding = PaddingValues(horizontal = 100.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
            )
            { page ->
                ImagePresentationCard(
                    urlImage = imagesList[page],
                    calculateCurrentOffsetForPage(page).absoluteValue,
                    modifier = Modifier, size = imagesSize)
            }

            ImagePresentationDots(
                imagesList.size,
                pageState,
                Modifier
                    .padding(top = 4.dp)
                    .fillMaxHeight())

        }

        Column(modifier = modifier.fillMaxSize(),verticalArrangement = Arrangement.Bottom)
        {
            Text(
                modifier = Modifier.fillMaxWidth().padding(bottom = 46.dp),
                text = Constants.pokemonChosed.getNameId(),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }

    }

}