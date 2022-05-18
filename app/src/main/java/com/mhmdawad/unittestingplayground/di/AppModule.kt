package com.mhmdawad.unittestingplayground.di

import android.content.Context
import androidx.room.Room
import com.mhmdawad.unittestingplayground.common.Constants.BASE_URL
import com.mhmdawad.unittestingplayground.common.Constants.DATABASE_NAME
import com.mhmdawad.unittestingplayground.data.local.ShoppingDao
import com.mhmdawad.unittestingplayground.data.local.ShoppingDatabase
import com.mhmdawad.unittestingplayground.data.remote.response.PixabayApi
import com.mhmdawad.unittestingplayground.data.repository.ShoppingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideShoppingDatabase(
        @ApplicationContext context: Context,
    ): ShoppingDatabase {
        return Room.databaseBuilder(
            context,
            ShoppingDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideShoppingDao(shoppingDatabase: ShoppingDatabase) = shoppingDatabase.shoppingDao()


    @Provides
    @Singleton
    fun providePixabayApi(): PixabayApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixabayApi::class.java)
    }

    @Provides
    @Singleton
    fun provideShoppingRepository(
        shoppingDao: ShoppingDao,
        pixabayApi: PixabayApi
    ) = ShoppingRepositoryImpl(shoppingDao, pixabayApi)
}

