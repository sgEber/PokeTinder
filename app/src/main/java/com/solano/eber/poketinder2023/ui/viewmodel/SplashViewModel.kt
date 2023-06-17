package com.solano.eber.poketinder2023.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.solano.eber.poketinder2023.data.FirebaseRemoteConfigRepository

class SplashViewModel: ViewModel() {

    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init {
        firebaseRemoteConfigRepository.init()
    }

    fun getIsUnderMaintenance(): MutableLiveData<Boolean>{
        return firebaseRemoteConfigRepository.isUnderMaintnanceLiveData
    }
}