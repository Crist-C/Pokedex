package com.ccastro.pokedexapp.domain.useCases

import com.ccastro.pokedexapp.domain.repositories.IPokemonRepository
import javax.inject.Inject
import javax.inject.Named

class GetPokemonSelected @Inject constructor(@Named("PokemonRepository") val pokemonRepository: IPokemonRepository) {
    suspend operator fun invoke() = pokemonRepository.getPokemonSelected()
}