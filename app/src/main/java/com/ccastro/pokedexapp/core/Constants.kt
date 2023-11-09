package com.ccastro.pokedexapp.core

import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.domain.models.PokemonDemo
import com.ccastro.pokedexapp.domain.models.Sprites

object Constants {
    const val TAG: String = "APPLOG"
    var pokemonChosed: Pokemon? = null
    var pokemonDemo = PokemonDemo(
        name = "Pikachu",
        sprites = Sprites(
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/25.png",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/female/25.png",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/25.png",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/female/25.png",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/female/25.png",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/25.png",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/female/25.png",
        )
    )

}