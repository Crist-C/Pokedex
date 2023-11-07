package com.ccastro.pokedexapp.presentation.useCases

import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.presentation.screens.GenerationNumber
import retrofit2.Response

interface IPokemonUseCases {

    suspend fun getPokemonList(generationNumber: GenerationNumber = 1): Response<List<Pokemon>>

    //suspend fun getPokemonListOneByOne(generationNumber: GenerationNumber = 1): Response<List<Pokemon>>

    suspend fun getPokemonSelected(): Response<Pokemon>

}