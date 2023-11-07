package com.ccastro.pokedexapp.di

import com.ccastro.pokedexapp.domain.repositories.IPokemonRepository
import com.ccastro.pokedexapp.domain.useCases.GetPokemonList
import com.ccastro.pokedexapp.domain.useCases.GetPokemonSelected
import com.ccastro.pokedexapp.domain.useCases.PokemonUseCases
import com.ccastro.pokedexapp.presentation.useCases.IPokemonUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    @Named("PokemonUseCases")
    fun providePokemonUseCases(
        @Named("PokemonRepository")pokemonRepository: IPokemonRepository
    ): IPokemonUseCases = PokemonUseCases(
        getPokemonList = GetPokemonList(pokemonRepository),
        getPokemonSelected = GetPokemonSelected(pokemonRepository)
    )

}