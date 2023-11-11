package com.ccastro.pokedexapp.presentation.components.features

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ccastro.pokedexapp.R
import com.ccastro.pokedexapp.domain.models.Type
import com.ccastro.pokedexapp.domain.models.TypeInfo
import com.ccastro.pokedexapp.presentation.ui.theme.PokedexAppTheme

@Composable
fun Types(modifier: Modifier = Modifier, types: List<Type>) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 24.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {

        types.forEach { type: Type ->

            AssistChip(
                modifier = Modifier,
                onClick = {},
                label = {
                    Text(text = type.type.name)
                },
                colors = AssistChipDefaults.assistChipColors(type.getColorFromType()),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = type.getIconFromType()),
                        contentDescription = stringResource(R.string.type_icon_content_desc),
                        tint = Color.Black
                    )
                }
            )

        }
    }

}


@Preview(showSystemUi = false, showBackground = true)
@Composable
fun TypesPreview() {
    val type1 = Type(slot = 1, type = TypeInfo(name = "electric", url = ""))
    val type2 = Type(slot = 2, type = TypeInfo(name = "fire", url = ""))
    val type3 = Type(slot = 1, type = TypeInfo(name = "electric", url = ""))
    val typeList = listOf(
        type1, type2, type3
    )
    PokedexAppTheme {
        Types(types = typeList)
    }
}