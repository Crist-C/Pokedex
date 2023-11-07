package com.ccastro.pokedexapp.domain.useCases

import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.presentation.screens.GenerationNumber
import com.ccastro.pokedexapp.presentation.useCases.IPokemonUseCases
import retrofit2.Response

data class PokemonUseCases(
    val getPokemonList: GetPokemonList,
    val getPokemonSelected: GetPokemonSelected
): IPokemonUseCases {
    override suspend fun getPokemonList(generationNumber: GenerationNumber): Response<List<Pokemon>> {
        return getPokemonList.invoke(generationNumber)
    }

    override suspend fun getPokemonSelected(): Response<Pokemon> {
        return getPokemonSelected.invoke()
    }
}
