package com.solano.eber.poketinder2023.data

import androidx.lifecycle.MutableLiveData
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get
import com.solano.eber.poketinder2023.R

class FirebaseRemoteConfigRepository {

    val instance = FirebaseRemoteConfig.getInstance()

    val getUrlPokemonLiveData: MutableLiveData<String> = MutableLiveData()
    val isUnderMaintnanceLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun init(){
        instance.setDefaultsAsync(R.xml.remote_config_defaults)
        instance.fetchAndActivate().addOnCompleteListener{task ->
            if(task.isSuccessful){
                getUrlPokemonLiveData.value
            }
        }
    }

    private fun getUrlPokemonLiveData(): String = instance["url_pokemon_live"].asString()

    private fun getisUnderMaintnance(): Boolean {
        return instance["url_pokemon_live"].asBoolean()
    }
}