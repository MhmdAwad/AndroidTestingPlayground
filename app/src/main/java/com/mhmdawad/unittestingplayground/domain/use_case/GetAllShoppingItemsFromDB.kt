package com.mhmdawad.unittestingplayground.domain.use_case

import com.mhmdawad.unittestingplayground.common.Resource
import com.mhmdawad.unittestingplayground.domain.model.ShoppingItem
import com.mhmdawad.unittestingplayground.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetAllShoppingItemsFromDB @Inject constructor(
    private val repository: ShoppingRepository
){

    operator fun invoke() = repository.observeAllShoppingItems()
}