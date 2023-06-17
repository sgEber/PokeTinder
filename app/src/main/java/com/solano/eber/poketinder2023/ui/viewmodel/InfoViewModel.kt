package com.solano.eber.poketinder2023.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.solano.eber.poketinder2023.data.FirebaseRemoteConfigRepository

class InfoViewModel : ViewModel() {
    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init {
        firebaseRemoteConfigRepository.init()
    }

    fun getUrlPokemon(): MutableLiveData<String>{
        return firebaseRemoteConfigRepository.getUrlPokemonLiveData
    }
}