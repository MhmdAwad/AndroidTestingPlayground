package com.mhmdawad.unittestingplayground.repository

import com.mhmdawad.unittestingplayground.data.remote.dto.PixabayResponseDto
import com.mhmdawad.unittestingplayground.domain.model.ShoppingItem
import com.mhmdawad.unittestingplayground.domain.repository.ShoppingRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class FakeShoppingRepository : ShoppingRepository {

    private val shoppingDatabaseList = mutableListOf<ShoppingItem>()
    private val observeAllShoppingFlow = MutableStateFlow<List<ShoppingItem>>(shoppingDatabaseList)
    private val observeTotalPriceFlow = MutableStateFlow(0f)
    private var shouldThrowCancellationException: Boolean = false



    private fun refreshLiveData() = runBlocking{
        observeAllShoppingFlow.emit(shoppingDatabaseList)
        observeTotalPriceFlow.emit(getTotalPrice())
    }

    private fun getTotalPrice(): Float {
        return shoppingDatabaseList.sumOf { (it.price * it.amount).toDouble() }.toFloat()
    }

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDatabaseList.add(shoppingItem)
        refreshLiveData()
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDatabaseList.remove(shoppingItem)
        refreshLiveData()
    }

    override fun observeAllShoppingItems(): Flow<List<ShoppingItem>> = observeAllShoppingFlow


    override fun observeTotalPrice(): Flow<Float> = observeTotalPriceFlow

    override suspend fun searchForImages(searchText: String): Response<PixabayResponseDto> {
        if(shouldThrowCancellationException)
            throw CancellationException("Error")

        return Response.success(PixabayResponseDto(listOf(), 50, 50))
    }


}