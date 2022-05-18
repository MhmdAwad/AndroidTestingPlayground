package com.mhmdawad.unittestingplayground.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mhmdawad.unittestingplayground.domain.model.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1,
    exportSchema = false
)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun shoppingDao(): ShoppingDao

}