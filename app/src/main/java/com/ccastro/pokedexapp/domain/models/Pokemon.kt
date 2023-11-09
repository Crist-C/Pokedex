package com.ccastro.pokedexapp.domain.models

import com.ccastro.pokedexapp.domain.models.common.Ability
import com.ccastro.pokedexapp.domain.models.common.Language
import com.ccastro.pokedexapp.domain.models.common.VersionGroup
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pokemon(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("base_experience") val baseExperience: Int,
    @Expose @SerializedName("height") val height: Int,
    @Expose @SerializedName("is_default") val isDefault: Boolean,
    @Expose @SerializedName("order") val order: Int,
    @Expose @SerializedName("weight") val weight: Int,
    @Expose @SerializedName("sprites") val sprites: Sprites,
    @Expose @SerializedName("abilities") val abilities: List<Ability>,
    @Expose @SerializedName("forms") val forms: List<Form>,
    @Expose @SerializedName("game_indices") val gameIndices: List<GameIndex>,
    @Expose @SerializedName("held_items") val heldItems: List<HeldItem>,
    @Expose @SerializedName("location_area_encounters") val locationAreaEncounters: String,
    @Expose @SerializedName("moves") val moves: List<Move>,
    @Expose @SerializedName("species") val species: Species,
    @Expose @SerializedName("stats") val stats: List<Stat>,
    @Expose @SerializedName("types") val types: List<Type>,
    @Expose @SerializedName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>,
    // added property for the Spanish flavor text entries
    var spanishFlavorTextEntries: List<String> = emptyList()
) {
    fun containTextInName(name: String): Boolean {
        return this.name.contains(name, true)
    }
}

data class PokemonDemo(
    @Expose @SerializedName("id") val id: Int? = null,
    @Expose @SerializedName("name") val name: String? = null,
    @Expose @SerializedName("base_experience") val baseExperience: Int? = null,
    @Expose @SerializedName("height") val height: Int? = null,
    @Expose @SerializedName("is_default") val isDefault: Boolean? = null,
    @Expose @SerializedName("order") val order: Int? = null,
    @Expose @SerializedName("weight") val weight: Int? = null,
    @Expose @SerializedName("sprites") val sprites: Sprites? = null,
    @Expose @SerializedName("abilities") val abilities: List<Ability>? = null,
    @Expose @SerializedName("forms") val forms: List<Form>? = null,
    @Expose @SerializedName("game_indices") val gameIndices: List<GameIndex>? = null,
    @Expose @SerializedName("held_items") val heldItems: List<HeldItem>? = null,
    @Expose @SerializedName("location_area_encounters") val locationAreaEncounters: String? = null,
    @Expose @SerializedName("moves") val moves: List<Move>? = null,
    @Expose @SerializedName("species") val species: Species? = null,
    @Expose @SerializedName("stats") val stats: List<Stat>? = null,
    @Expose @SerializedName("types") val types: List<Type>? = null,
    @Expose @SerializedName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>? = null,
    // added property for the Spanish flavor text entries
    var spanishFlavorTextEntries: List<String>? = null
)


data class FlavorTextEntry(
    @Expose @SerializedName("flavor_text") val flavorText: String,
    @Expose @SerializedName("language") val language: Language
)

data class Sprites(
    @Expose @SerializedName("back_default") val backDefault: String?,
    @Expose @SerializedName("back_female") val backFemale: String?,
    @Expose @SerializedName("back_shiny") val backShiny: String?,
    @Expose @SerializedName("back_shiny_female") val backShinyFemale: String?,
    @Expose @SerializedName("front_default") var frontDefault: String?,
    @Expose @SerializedName("front_female") val frontFemale: String?,
    @Expose @SerializedName("front_shiny") val frontShiny: String?,
    @Expose @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class Form(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class GameIndex(
    @Expose @SerializedName("game_index") val gameIndex: Int,
    @Expose @SerializedName("version") val version: Version
)

data class Version(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class HeldItem(
    @Expose @SerializedName("item") val item: Item,
    @Expose @SerializedName("version_details") val versionDetails: List<VersionDetail>
)

data class Item(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class VersionDetail(
    @Expose @SerializedName("rarity") val rarity: Int,
    @Expose @SerializedName("version") val version: Version
)

data class Move(
    @Expose @SerializedName("move") val move: MoveInfo,
    @Expose @SerializedName("version_group_details") val versionGroupDetails: List<VersionGroupDetail>
)

data class MoveInfo(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class VersionGroupDetail(
    @Expose @SerializedName("level_learned_at") val levelLearnedAt: Int,
    @Expose @SerializedName("move_learn_method") val moveLearnMethod: MoveLearnMethod,
    @Expose @SerializedName("version_group") val versionGroup: VersionGroup
)

data class MoveLearnMethod(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class Species(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class Stat(
    @Expose @SerializedName("base_stat") val baseStat: Int,
    @Expose @SerializedName("effort") val effort: Int,
    @Expose @SerializedName("stat") val stat: StatInfo
)

data class StatInfo(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class Type(
    @Expose @SerializedName("slot") val slot: Int,
    @Expose @SerializedName("type") val type: TypeInfo
)

data class TypeInfo(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)
