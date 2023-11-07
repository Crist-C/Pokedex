package com.ccastro.pokedexapp.domain.repositories

import com.ccastro.pokedexapp.presentation.screens.GenerationNumber
import com.ccastro.pokedexapp.presentation.screens.PokemonId
import com.ccastro.pokedexapp.presentation.screens.PokemonName
import com.ccastro.pokedexapp.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface IPokemonRepository {

    suspend fun getPokemonSelected(): Response<Pokemon>
    suspend fun getPokemonById(id: PokemonId): Response<Pokemon>
    suspend fun getPokemonByName(name: PokemonName): Response<Pokemon>
    suspend fun getPokemonList(generation: GenerationNumber = 1): Response<List<Pokemon>>

}