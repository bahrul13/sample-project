package com.example.sampleproject.data.remote

import com.example.sampleproject.data.remote.model.response.CharacterInfo
import com.example.sampleproject.data.remote.model.response.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RIckAndMortyService {

    @GET("character")
    suspend fun getCharacters(): Response<CharacterList>

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int
    ) :Response<CharacterInfo>
}