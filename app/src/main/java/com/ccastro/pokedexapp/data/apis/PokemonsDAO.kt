package com.ccastro.pokedexapp.data.apis

import com.ccastro.pokedexapp.domain.models.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonsDAO {
    @GET("pokemon/{idOrName}/")
    suspend fun getPokemonDetail(@Path("idOrName") idOrName: Any) : Response<Pokemon>

    @GET("generation/{generation}/")
    suspend fun getGenerationList(@Path("generation") generation: Int) : Response<List<Pokemon>>
}