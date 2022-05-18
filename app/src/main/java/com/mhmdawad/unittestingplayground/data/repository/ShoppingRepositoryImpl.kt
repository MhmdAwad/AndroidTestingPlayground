package com.mhmdawad.unittestingplayground.data.repository

import com.mhmdawad.unittestingplayground.data.local.ShoppingDao
import com.mhmdawad.unittestingplayground.data.remote.dto.PixabayResponseDto
import com.mhmdawad.unittestingplayground.data.remote.response.PixabayApi
import com.mhmdawad.unittestingplayground.domain.model.ShoppingItem
import com.mhmdawad.unittestingplayground.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response
import javax.inject.Inject

class ShoppingRepositoryImpl @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayApi: PixabayApi
) : ShoppingRepository {

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItems(): Flow<List<ShoppingItem>> = shoppingDao.observeAllShoppingItems()


    override fun observeTotalPrice(): Flow<Float> = shoppingDao.observeTotalPrice()

    // TODO: add use case to check if searchText not empty and check if result is successful
    override suspend fun searchForImages(searchText: String): Response<PixabayResponseDto> =
        pixabayApi.searchForImages(searchText)


}