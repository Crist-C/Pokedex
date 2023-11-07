package com.ccastro.pokedexapp.domain.models

import com.ccastro.pokedexapp.presentation.screens.PokemonId
import com.ccastro.pokedexapp.presentation.screens.PokemonName
import com.ccastro.pokedexapp.domain.models.common.AbilityInfo
import com.ccastro.pokedexapp.domain.models.common.Language
import com.ccastro.pokedexapp.domain.models.common.VersionGroup
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class GenerationData(
    @SerializedName("id") val id: PokemonId,
    @SerializedName("name") val name: String,
    @SerializedName("abilities") val abilities: List<AbilityInfo>,
    @SerializedName("main_region") val mainRegion: MainRegion,
    @SerializedName("moves") val moves: List<MoveUrl>,
    @SerializedName("names") val names: List<Name>,
    @SerializedName("pokemon_species") val pokemonSpecies: List<PokemonSpecies>,
    @SerializedName("types") val types: List<TypeUrl>,
    @SerializedName("version_groups") val versionGroups: List<VersionGroup>
) {
    fun getPokemonsNames(): MutableList<PokemonName> {
        val pokemonNameList = mutableListOf<PokemonName>()
        this.pokemonSpecies.forEach { pokemonNameList.add(it.name) }
        return pokemonNameList
    }
    fun getFlowPokemonsNames(): Flow<PokemonName> {
        val pokemonSpecies = this.pokemonSpecies
        return flow {
            pokemonSpecies.forEach {
                emit(value = it.name)
            }
        }
    }
}

data class MainRegion(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class MoveUrl(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class Name(
    @SerializedName("name") val name: String,
    @SerializedName("language") val language: Language
)

data class PokemonSpecies(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class TypeUrl(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)