package com.ccastro.pokedexapp.presentation.screens.pokemons.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ccastro.pokedexapp.core.Constants.TAG
import com.ccastro.pokedexapp.domain.models.Pokemon
import com.ccastro.pokedexapp.presentation.screens.Message
import com.ccastro.pokedexapp.presentation.useCases.IPokemonUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    @Named("PokemonUseCases")val pokemonUseCases: IPokemonUseCases
) : ViewModel() {

    private val errorMessage = MutableLiveData<Message>()
    private val pokemonList = MutableLiveData<List<Pokemon>>()
    private val loading = MutableLiveData<Boolean>()
    private var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.i(TAG, "Exception Handled: ${throwable.localizedMessage}")
        viewModelScope.launch(coroutineContext){
            onError("Exception Handled: ${throwable.localizedMessage}")
        }

    }

    init {
        getAllPokemons()
    }
    private fun getAllPokemons() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = pokemonUseCases.getPokemonList()
            Log.i(TAG, "getAllPokemons: ${response.body()}")
            withContext(Dispatchers.Main){
                if (response.isSuccessful) {
                    pokemonList.postValue(response.body())
                    loading.value = false
                } else {
                  onError("Error: ${response.message()}")
                }
            }
        }
    }

    private fun onError(message: Message) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}