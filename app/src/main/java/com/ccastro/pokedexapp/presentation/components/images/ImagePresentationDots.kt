package com.ccastro.pokedexapp.presentation.components.images

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ccastro.pokedexapp.presentation.ui.theme.Blue80
import com.ccastro.pokedexapp.presentation.ui.theme.BlueVariant40
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImagePresentationDots(count: Int, pageState: PagerState, modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    val isThisSelected = remember {
        mutableIntStateOf(0)
    }
    isThisSelected.intValue = pageState.currentPage

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(count) {
            Divider(
                thickness = 8.dp,
                color = if (isThisSelected.intValue == it ) BlueVariant40 else Blue80,
                modifier = Modifier
                    .padding(4.dp)
                    .size(10.dp)
                    .clip(CircleShape)
                    .clickable {
                        isThisSelected.intValue = it
                        scope.launch {
                            pageState.animateScrollToPage(it)
                        }
                    }
            )
        }
    }
}
