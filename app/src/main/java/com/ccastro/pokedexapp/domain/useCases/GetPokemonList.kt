package com.ccastro.pokedexapp.domain.useCases

import com.ccastro.pokedexapp.domain.repositories.IPokemonRepository
import com.ccastro.pokedexapp.presentation.screens.GenerationNumber
import javax.inject.Inject
import javax.inject.Named

class GetPokemonList @Inject constructor(
    @Named("PokemonRepository") val pokemonRepository: IPokemonRepository
) {
    suspend operator fun invoke(generationNumber: GenerationNumber) = pokemonRepository
        .getPokemonList(generationNumber)
}