package com.bolhy91.androidchallengeexcelsior.di

import com.bolhy91.androidchallengeexcelsior.common.Api.BASE_URL
import com.bolhy91.androidchallengeexcelsior.data.remote.ExcelsiorApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideExcelsiorApi(retrofit: Retrofit): ExcelsiorApi {
        return retrofit.create(ExcelsiorApi::class.java)
    }
}