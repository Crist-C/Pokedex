package com.ccastro.pokedexapp.presentation.screens.pokemons.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ccastro.pokedexapp.core.Constants.TAG
import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.presentation.screens.GenerationNumber
import com.ccastro.pokedexapp.presentation.screens.Message
import com.ccastro.pokedexapp.presentation.useCases.IPokemonUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    @Named("PokemonUseCases")val pokemonUseCases: IPokemonUseCases
) : ViewModel() {

    // ----------- Declaración e inicialización de variables -------------- //

    private var job: Job? = null
    private var isFirstTime = true

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _errorMessage = MutableStateFlow("")
    val errorMessage = _errorMessage.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.i(TAG, "Exception Handled: ${throwable.localizedMessage}")
        viewModelScope.launch(coroutineContext){
            onError("Exception Handled: ${throwable.localizedMessage}")
        }
    }

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())


    val pokemonList = searchText
        .debounce(500L)
        .combine(_pokemonList){ textToSearch, pokemonList ->
            if(textToSearch.isEmpty()){
                pokemonList
            }else {
                pokemonList.filter { it.containTextInName(textToSearch) }
            }
        }.onEach {
            _errorMessage.value =
                if(it.isEmpty() && !isFirstTime) "Pokemon not found!"
                else ""
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, _pokemonList.value)



    init {
        getAllPokemons()
    }


    // ----------- Coroutines -------------- //
    fun getAllPokemons(generation: GenerationNumber = 1) {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {

            _loading.update { true }

            val response = pokemonUseCases.getPokemonList(generation)
            withContext(Dispatchers.Main){

                if (response.isSuccessful) {
                    onError("")
                    _pokemonList.update{response.body()?: emptyList()}
                } else {
                  onError("Error: Pokemons couldn't be loaded\ntry it again!")
                }
            }
        }
    }


    // ----------- Métodos para validación de error -------------- //
    private fun onError(message: Message) {
        _errorMessage.value = message
        _loading.value = false
        isFirstTime = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    // ----------- Métodos para actualización de variables -------------- //
    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

}