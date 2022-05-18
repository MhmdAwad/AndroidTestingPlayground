package com.mhmdawad.unittestingplayground.data.remote.response

import com.mhmdawad.unittestingplayground.BuildConfig
import com.mhmdawad.unittestingplayground.data.remote.dto.PixabayResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("/api/")
    suspend fun searchForImages(
        @Query("q") searchText: String,
        @Query("key") key: String = BuildConfig.API_KEY
    ): Response<PixabayResponseDto>

}