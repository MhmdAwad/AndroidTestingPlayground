package com.mhmdawad.unittestingplayground.domain.repository

import com.mhmdawad.unittestingplayground.data.remote.dto.PixabayResponseDto
import com.mhmdawad.unittestingplayground.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): Flow<List<ShoppingItem>>

    fun observeTotalPrice(): Flow<Float>

    suspend fun searchForImages(searchText: String): Response<PixabayResponseDto>
}