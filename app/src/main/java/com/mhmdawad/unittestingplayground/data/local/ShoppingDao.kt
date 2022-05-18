package com.mhmdawad.unittestingplayground.data.local

import androidx.room.*
import com.mhmdawad.unittestingplayground.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    fun observeAllShoppingItems(): Flow<List<ShoppingItem>>

    @Query("SELECT SUM(price * amount) FROM shopping_item")
    fun observeTotalPrice(): Flow<Float>

}