package com.mhmdawad.unittestingplayground.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_item")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val amount: Int,
    val price: Float,
    val imageUrl: String
)