package com.mhmdawad.unittestingplayground.domain.use_case

import com.mhmdawad.unittestingplayground.common.Resource
import com.mhmdawad.unittestingplayground.data.remote.dto.PixabayResponseDto
import com.mhmdawad.unittestingplayground.data.remote.dto.toHitModel
import com.mhmdawad.unittestingplayground.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.lang.NullPointerException
import javax.inject.Inject

class SearchForImage @Inject constructor(
    private val repository: ShoppingRepository
){

    operator fun invoke(searchText: String) = flow {
        if(searchText.isBlank()) {
            emit(Resource.Error("Please add a valid search text!"))
            return@flow
        }
        try{
            emit(Resource.Loading())
            val response = repository.searchForImages(searchText).body()
            response?.let {hits->
                val hitsList = hits.hits.map { it.toHitModel() }
                emit(Resource.Success(hitsList))
            }?: throw NullPointerException()
        }catch (e: NullPointerException){
            emit(Resource.Error("No images found!"))
        }catch (e: HttpException){
            emit(Resource.Error("An error occurred, Please check your internet connection!"))
        }
    }
}