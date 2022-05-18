package com.mhmdawad.unittestingplayground.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PixabayResponseDto(
    @SerializedName("hits")
    val hits: List<HitDto>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalHits")
    val totalHits: Int
)