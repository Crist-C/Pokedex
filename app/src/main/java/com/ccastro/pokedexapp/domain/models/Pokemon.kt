package com.ccastro.pokedexapp.domain.models

import androidx.compose.ui.graphics.Color
import com.ccastro.pokedexapp.R
import com.ccastro.pokedexapp.domain.models.common.Ability
import com.ccastro.pokedexapp.domain.models.common.Language
import com.ccastro.pokedexapp.domain.models.common.VersionGroup
import com.ccastro.pokedexapp.presentation.screens.AttributeContent
import com.ccastro.pokedexapp.presentation.screens.AttributeName
import com.ccastro.pokedexapp.presentation.screens.ImageUrl
import com.ccastro.pokedexapp.presentation.screens.MoveName
import com.ccastro.pokedexapp.presentation.screens.StatName
import com.ccastro.pokedexapp.presentation.screens.StatValue
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
    @Expose @SerializedName("location_area_encounters") val locationAreaEncounters: String,
    @Expose @SerializedName("moves") val moves: List<Move>,
    @Expose @SerializedName("species") val species: Species,
    @Expose @SerializedName("stats") val stats: List<Stat>,
    @Expose @SerializedName("types") val types: List<Type>,
    @Expose @SerializedName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>,
    // added property for the Spanish flavor text entries
    var spanishFlavorTextEntries: List<String> = emptyList()
) {
    companion object { const val statMaxValue: Int = 150 }

    fun getNameId(): String {
        return "$id. ${name.uppercase()}"
    }

    fun containTextInName(name: String): Boolean {
        return this.name.contains(name, true)
    }

    fun getAttributes(): Map<AttributeName, AttributeContent> {

        val abilityList = mutableListOf<String>()
        abilities.forEach {
            abilityList.add(it.ability.name)
        }

        return mapOf(
            Pair("Base Experience", listOf("$baseExperience")),
            Pair("Height", listOf("${(height.toFloat() / 10)} m")),
            Pair("Weight", listOf("${(weight.toFloat() / 10)} Kg")),
            Pair("Abilities", abilityList),
        )
    }

    fun getStats(): Map<StatName,StatValue> {
        val statMap = mutableMapOf<StatName,StatValue>()
        stats.iterator().forEach { stat: Stat ->
            statMap[stat.stat.name] = stat.baseStat
        }
        return statMap
    }

    fun getMoveList(): List<MoveName> {
        val moveList = mutableListOf<MoveName>()
        moves.forEach {
            moveList.add(it.move.name)
        }
        return moveList
    }
}

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
){
    fun getImageUrlList(): List<ImageUrl> {
        return listOf(
            backDefault?:"", backFemale?:"", backShiny?:"", backShinyFemale?:"",
            frontDefault?:"", frontFemale?:"", frontShiny?:"", frontShinyFemale?:""
        ).filter { it.isNotEmpty() }
    }

}

data class Form(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class Version(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
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
) {
    fun getIconFromType(): Int {
        return when(type.name) {
            PokemonTypes.Normal.typeName -> PokemonTypes.Normal.icon
            PokemonTypes.Fighting.typeName -> PokemonTypes.Fighting.icon
            PokemonTypes.Flying.typeName -> PokemonTypes.Flying.icon
            PokemonTypes.Poison.typeName -> PokemonTypes.Poison.icon
            PokemonTypes.Ground.typeName -> PokemonTypes.Ground.icon
            PokemonTypes.Rock.typeName -> PokemonTypes.Rock.icon
            PokemonTypes.Bug.typeName -> PokemonTypes.Bug.icon
            PokemonTypes.Ghost.typeName -> PokemonTypes.Ghost.icon
            PokemonTypes.Steel.typeName -> PokemonTypes.Steel.icon
            PokemonTypes.Fire.typeName -> PokemonTypes.Fire.icon
            PokemonTypes.Water.typeName -> PokemonTypes.Water.icon
            PokemonTypes.Grass.typeName -> PokemonTypes.Grass.icon
            PokemonTypes.Electric.typeName -> PokemonTypes.Electric.icon
            PokemonTypes.Psychic.typeName -> PokemonTypes.Psychic.icon
            PokemonTypes.Ice.typeName -> PokemonTypes.Ice.icon
            PokemonTypes.Dragon.typeName -> PokemonTypes.Dragon.icon
            PokemonTypes.Dark.typeName -> PokemonTypes.Dark.icon
            PokemonTypes.Fairy.typeName -> PokemonTypes.Fairy.icon
            PokemonTypes.Unknown.typeName -> PokemonTypes.Unknown.icon
            PokemonTypes.Shadow.typeName -> PokemonTypes.Shadow.icon
            else -> PokemonTypes.Unknown.icon
        }
    }

    fun getColorFromType(): Color {
        return when(type.name) {
            PokemonTypes.Normal.typeName -> PokemonTypes.Normal.PokemonColor.colorValue
            PokemonTypes.Fighting.typeName -> PokemonTypes.Normal.PokemonColor.colorValue
            PokemonTypes.Flying.typeName -> PokemonTypes.Flying.PokemonColor.colorValue
            PokemonTypes.Poison.typeName -> PokemonTypes.Poison.PokemonColor.colorValue
            PokemonTypes.Ground.typeName -> PokemonTypes.Ground.PokemonColor.colorValue
            PokemonTypes.Rock.typeName -> PokemonTypes.Rock.PokemonColor.colorValue
            PokemonTypes.Bug.typeName -> PokemonTypes.Bug.PokemonColor.colorValue
            PokemonTypes.Ghost.typeName -> PokemonTypes.Ghost.PokemonColor.colorValue
            PokemonTypes.Steel.typeName -> PokemonTypes.Steel.PokemonColor.colorValue
            PokemonTypes.Fire.typeName -> PokemonTypes.Fire.PokemonColor.colorValue
            PokemonTypes.Water.typeName -> PokemonTypes.Water.PokemonColor.colorValue
            PokemonTypes.Grass.typeName -> PokemonTypes.Grass.PokemonColor.colorValue
            PokemonTypes.Electric.typeName -> PokemonTypes.Electric.PokemonColor.colorValue
            PokemonTypes.Psychic.typeName -> PokemonTypes.Psychic.PokemonColor.colorValue
            PokemonTypes.Ice.typeName -> PokemonTypes.Ice.PokemonColor.colorValue
            PokemonTypes.Dragon.typeName -> PokemonTypes.Dragon.PokemonColor.colorValue
            PokemonTypes.Dark.typeName -> PokemonTypes.Dark.PokemonColor.colorValue
            PokemonTypes.Fairy.typeName -> PokemonTypes.Fairy.PokemonColor.colorValue
            PokemonTypes.Unknown.typeName -> PokemonTypes.Unknown.PokemonColor.colorValue
            PokemonTypes.Shadow.typeName -> PokemonTypes.Shadow.PokemonColor.colorValue
            else -> PokemonTypes.Unknown.PokemonColor.colorValue
        }
    }
}

data class TypeInfo(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

sealed class PokemonColors(val colorName: String, val colorValue: Color) {
    object Black: PokemonColors("black", Color(0x80414141))
    object BlueWater: PokemonColors("blueWater", Color(0x804592C4))
    object BlueIce: PokemonColors("blueIce", Color(0x8051C4E7))
    object BlueFly: PokemonColors("blueFly", Color(0x803DC7EF))
    object Brown: PokemonColors("brown", Color(0x80A38C21))
    object GrayNormal: PokemonColors("greyNormal", Color(0x80A4ACAF))
    object GrayAcero: PokemonColors("greyAcero", Color(0x809EB7B8))
    object Green: PokemonColors("green", Color(0x80729F3F))
    object Pink: PokemonColors("pink", Color(0x80FDB9E9))
    object PurpleGhost: PokemonColors("purpleGhost", Color(0x807B62A3))
    object PurplePoison: PokemonColors("purpleVenom", Color(0x80B97FC9))
    object RedFire: PokemonColors("redFire", Color(0x80FD7D24))
    object RedDragon: PokemonColors("red", Color(0x80F16E57))
    object White: PokemonColors("white", Color(0x80FFFFFF))
    object Yellow: PokemonColors("yellow", Color(0x80EED535))
}
sealed class PokemonTypes(val typeName: String, val icon: Int, val PokemonColor: PokemonColors) {
    object Normal: PokemonTypes("normal", R.drawable.normal_icon, PokemonColors.GrayNormal)
    object Fighting: PokemonTypes("fighting", R.drawable.fighting_icon, PokemonColors.GrayAcero)
    object Flying: PokemonTypes("flying", R.drawable.flying_icon, PokemonColors.BlueFly)
    object Poison: PokemonTypes("poison", R.drawable.poison_icon, PokemonColors.PurplePoison)
    object Ground: PokemonTypes("ground", R.drawable.rock_icon, PokemonColors.Brown)
    object Rock: PokemonTypes("rock", R.drawable.rock_icon, PokemonColors.Brown)
    object Bug: PokemonTypes("bug", R.drawable.bug_icon, PokemonColors.Green)
    object Ghost: PokemonTypes("ghost", R.drawable.ghost_icon, PokemonColors.PurpleGhost)
    object Steel: PokemonTypes("steel", R.drawable.steel_icon, PokemonColors.GrayAcero)
    object Fire: PokemonTypes("fire", R.drawable.fire_icon, PokemonColors.RedFire)
    object Water: PokemonTypes("water", R.drawable.water_icon, PokemonColors.BlueWater)
    object Grass: PokemonTypes("grass", R.drawable.grass_icon, PokemonColors.Green)
    object Electric: PokemonTypes("electric", R.drawable.electric_icon, PokemonColors.Yellow)
    object Psychic: PokemonTypes("psychic", R.drawable.psychic_icon, PokemonColors.Pink)
    object Ice: PokemonTypes("ice", R.drawable.ice_icon, PokemonColors.BlueIce)
    object Dragon: PokemonTypes("dragon", R.drawable.dragon_icon, PokemonColors.RedDragon)
    object Dark: PokemonTypes("dark", R.drawable.dark_icon, PokemonColors.Black)
    object Fairy: PokemonTypes("fairy", R.drawable.flying_icon, PokemonColors.Pink)
    object Unknown: PokemonTypes("unknown", R.drawable.dark_icon, PokemonColors.White)
    object Shadow: PokemonTypes("shadow", R.drawable.shadow_icon, PokemonColors.Black)

}
