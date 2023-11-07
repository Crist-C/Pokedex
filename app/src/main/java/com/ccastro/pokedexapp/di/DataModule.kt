package com.ccastro.pokedexapp.di

import com.ccastro.pokedexapp.data.apis.PokemonsDAO
import com.ccastro.pokedexapp.data.repositories.PokemonRepository
import com.ccastro.pokedexapp.domain.repositories.IPokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    @Named("PokeApiUrlBase")
    fun provideBaseUrl(): String = "https://pokeapi.co/api/v2/"

    @Provides
    @Singleton
    @Named("RetrofitClient")
    fun provideRetrofitClient(@Named("PokeApiUrlBase") urlBase: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlBase)
            .client(
                OkHttpClient().newBuilder().build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("PokemonDao")
    fun providePokemonDao(@Named("RetrofitClient")retrofit: Retrofit) : PokemonsDAO =
        retrofit.create(PokemonsDAO::class.java)

    @Provides
    @Singleton
    @Named("PokemonRepository")
    fun providePokemonRepository(@Named("PokemonDao") pokemonDao: PokemonsDAO) :
            IPokemonRepository = PokemonRepository(pokemonDao = pokemonDao)


}