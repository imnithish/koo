package com.imnstudios.koo.data

import com.imnstudios.koo.models.RandomUser
import com.imnstudios.koo.network.APIInterface
import com.imnstudios.koo.util.ResultWrapper
import com.imnstudios.koo.util.safeApiCall
import javax.inject.Inject

class Repo @Inject constructor(private val api: APIInterface) {

    suspend fun getRepos(
        result: Int,
    ): ResultWrapper<RandomUser> {
        return safeApiCall {
            api.getList(result)
        }
    }
}