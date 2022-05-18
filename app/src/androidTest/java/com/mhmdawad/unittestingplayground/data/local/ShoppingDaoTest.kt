package com.mhmdawad.unittestingplayground.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.mhmdawad.unittestingplayground.domain.model.ShoppingItem
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingDaoTest {

    private lateinit var database: ShoppingDatabase
    private lateinit var dao : ShoppingDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShoppingDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.shoppingDao()
    }

    @After
    fun teardown(){
        database.close()
    }


    @Test
    fun insertShoppingItem() = runBlocking {
        val shoppingItem = ShoppingItem(1, "name", 10, 20f, "image")
        dao.insertShoppingItem(shoppingItem)

        val result = dao.observeAllShoppingItems().first()
        assertThat(result).contains(shoppingItem)
    }

    @Test
    fun deleteShoppingItem() = runBlocking {
        val shoppingItem = ShoppingItem(1, "name", 10, 20f, "image")
        dao.insertShoppingItem(shoppingItem)

        dao.deleteShoppingItem(shoppingItem)
        val result = dao.observeAllShoppingItems().first()
        assertThat(result).doesNotContain(shoppingItem)
    }

    @Test
    fun observeTotalPrice() = runBlocking {
        val shoppingItem1 = ShoppingItem(1, "name", 4, 20f, "image")
        val shoppingItem2 = ShoppingItem(2, "name", 5, 20f, "image")
        val shoppingItem3 = ShoppingItem(3, "name", 1, 20f, "image")
        val shoppingItem4 = ShoppingItem(4, "name", 4, 20f, "image")
        dao.insertShoppingItem(shoppingItem1)
        dao.insertShoppingItem(shoppingItem2)
        dao.insertShoppingItem(shoppingItem3)
        dao.insertShoppingItem(shoppingItem4)
        val result = dao.observeTotalPrice().first()

        assertThat(result).isEqualTo(4*20f + 5*20f + 20f + 4*20f)
    }













}