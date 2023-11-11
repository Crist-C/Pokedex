package com.ccastro.pokedexapp.data.repositories

import com.ccastro.pokedexapp.core.Constants
import com.ccastro.pokedexapp.data.apis.PokemonsDAO
import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.domain.repositories.IPokemonRepository
import com.ccastro.pokedexapp.presentation.screens.GenerationNumber
import com.ccastro.pokedexapp.presentation.screens.PokemonId
import com.ccastro.pokedexapp.presentation.screens.PokemonName
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
        val pokemonReponse = pokemonDao.getPokemonDetail(name)
        val pokemon = pokemonReponse.body()
        //Log.i(TAG, "getPokemonByName: ${pokemon?.name}")
        return pokemonReponse
    }

    override suspend fun getPokemonList(generation: GenerationNumber): Response<List<Pokemon>> {
        val generationData = pokemonDao.getGenerationList(generation)
        val pokemonsNames = generationData.body()?.getPokemonsNames()
        val pokemonList : MutableList<Pokemon> = mutableListOf()

        pokemonsNames?.forEachIndexed{ iteration, pokemonName ->
            //if(iteration <= 10)
                getPokemonByName(pokemonName).body()?.let { pokemonList.add(it) }
        }

        return Response.success(pokemonList)
    }


}