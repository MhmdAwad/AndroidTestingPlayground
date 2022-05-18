package com.mhmdawad.unittestingplayground.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhmdawad.unittestingplayground.common.Resource
import com.mhmdawad.unittestingplayground.domain.model.PixabayImageModel
import com.mhmdawad.unittestingplayground.domain.model.ShoppingItem
import com.mhmdawad.unittestingplayground.domain.use_case.ShoppingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val shoppingUseCase: ShoppingUseCase
): ViewModel() {

    val totalPrice = shoppingUseCase.getTotalPriceFromDB()
    val shoppingItemList = shoppingUseCase.getAllShoppingItemsFromDB()

    private val _searchedImages = MutableStateFlow<Resource<List<PixabayImageModel>>>(Resource.Loading())
    val searchedImages = _searchedImages.asStateFlow()

    private val _currentSelectedImage = MutableStateFlow<String>("")
    val currentSelectedImage = _currentSelectedImage.asStateFlow()

    private var _databaseState = MutableStateFlow<Resource<String>>(Resource.Loading())
    val databaseState = _databaseState.asStateFlow()

    fun setCurrentSelectedImage(value: String) = viewModelScope.launch{
        _currentSelectedImage.emit(value)
    }

    fun deleteShoppingItem(shoppingItem: ShoppingItem) = viewModelScope.launch {
        shoppingUseCase.deleteShoppingItemToDB(shoppingItem).onEach {
            _databaseState.emit(it)
        }
    }

    fun insertShoppingItem(shoppingItem: ShoppingItem) = viewModelScope.launch {
        shoppingUseCase.insertShoppingItemToDB(shoppingItem).onEach {
            _databaseState.emit(it)
        }
    }




}