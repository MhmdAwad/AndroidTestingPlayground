package com.mhmdawad.unittestingplayground.domain.use_case

data class ShoppingUseCase(
    val deleteShoppingItemToDB: DeleteShoppingItemToDB,
    val getAllShoppingItemsFromDB: GetAllShoppingItemsFromDB,
    val getTotalPriceFromDB: GetTotalPriceFromDB,
    val insertShoppingItemToDB: InsertShoppingItemToDB,
    val searchForImage: SearchForImage
)
