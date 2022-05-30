package com.example.moviedetails.hilt

import com.example.moviedetails.remote.MovieInterface
import com.example.moviedetails.ui.details.MovieDetailsRepository
import com.example.moviedetails.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object HiltModules {
    @Singleton
    @Provides
    fun provideRetroFitInterface(): MovieInterface{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(MovieInterface::class.java)
    }

    @Provides
    fun provideRepository(movieInterface: MovieInterface): MovieDetailsRepository{
        return MovieDetailsRepository(movieInterface)
    }
}