package com.imnstudios.koo.network

import com.imnstudios.koo.models.RandomUser
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET("api/")
    suspend fun getList(
        @Query("results") result: Int,
    ): RandomUser
}