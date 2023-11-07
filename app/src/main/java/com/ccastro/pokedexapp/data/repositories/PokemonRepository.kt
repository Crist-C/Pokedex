package com.ccastro.pokedexapp.data.repositories

import com.ccastro.pokedexapp.core.Constants
import com.ccastro.pokedexapp.data.apis.PokemonsDAO
import com.ccastro.pokedexapp.presentation.screens.GenerationNumber
import com.ccastro.pokedexapp.presentation.screens.PokemonId
import com.ccastro.pokedexapp.presentation.screens.PokemonName
import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.domain.repositories.IPokemonRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class PokemonRepository @Inject constructor(
    @Named("PokemonDao")val pokemonDao: PokemonsDAO
): IPokemonRepository {
    override suspend fun getPokemonSelected(): Response<Pokemon> {
        return Response.success(Constants.pokemonChosed)
    }

    override suspend fun getPokemonById(id: PokemonId): Response<Pokemon> {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonByName(name: PokemonName): Response<Pokemon> {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonList(generation: GenerationNumber): Response<List<Pokemon>> {
        return pokemonDao.getGenerationList(generation)
    }
}