package com.bolhy91.androidchallengeexcelsior.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface ExcelsiorApi {
    @GET("search")
    suspend fun searchSong(
        @Query("term") term: String,
        @Query("mediaType") mediaType: String = "music",
        @Query("limit") limit: Long
    ): ResponseBody
}