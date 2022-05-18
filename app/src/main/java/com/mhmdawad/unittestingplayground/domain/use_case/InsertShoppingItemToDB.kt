package com.mhmdawad.unittestingplayground.domain.use_case

import com.mhmdawad.unittestingplayground.common.Resource
import com.mhmdawad.unittestingplayground.domain.model.ShoppingItem
import com.mhmdawad.unittestingplayground.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class InsertShoppingItemToDB @Inject constructor(
    private val repository: ShoppingRepository
){

    operator fun invoke(shoppingItem: ShoppingItem) = flow{
        try{
            repository.insertShoppingItem(shoppingItem)
            emit(Resource.Success("Item saved successfully."))
        }catch (e: Exception){
            emit(Resource.Error("An error occurred, Please try again!"))
        }
    }
}