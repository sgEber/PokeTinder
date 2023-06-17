package com.solano.eber.poketinder2023.data.network

import com.solano.eber.poketinder2023.data.model.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET("?limit=1000")
    suspend fun getPokemons() : Response<PokemonListResponse>
}