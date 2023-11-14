package com.ccastro.pokedexapp.presentation.screens.pokemons.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ccastro.pokedexapp.core.Constants.pokemonChosed
import com.ccastro.pokedexapp.presentation.screens.MoveName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor() : ViewModel() {

    private val _moveList = MutableStateFlow(emptyList<MoveName>())
    val moveList = _moveList.asStateFlow()

    init {
        viewModelScope.launch{
            delay(1000L)
            loadMoves()
        }
    }

    private fun loadMoves() {
        _moveList.value = pokemonChosed.getMoveList()
    }

}