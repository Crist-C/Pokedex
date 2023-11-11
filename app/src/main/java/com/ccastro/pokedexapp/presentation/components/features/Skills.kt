package com.ccastro.pokedexapp.presentation.components.features

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ccastro.pokedexapp.domain.models.Type
import com.ccastro.pokedexapp.domain.models.TypeInfo
import com.ccastro.pokedexapp.domain.models.common.Ability
import com.ccastro.pokedexapp.presentation.ui.theme.PokedexAppTheme

@Composable
fun Skills(modifier: Modifier = Modifier, skills: List<Ability>) {
/*
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        items(types) { type: Type ->
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ){
                ElevatedAssistChip(
                    modifier = Modifier,
                    onClick = {},
                    label = {
                        Text(text = type.type.name)
                    }
                )
            }
        }
    }

 */
}

@Preview
@Composable
fun SkillsPreview() {
    val type1 = Type(slot = 1, type = TypeInfo(name = "Electric", url = ""))
    val type2 = Type(slot = 2, type = TypeInfo(name = "Fire", url = ""))
    val typeList = listOf<Type>(
        type1, type2
    )
    PokedexAppTheme {
        //Skills(types = typeList)
    }
}