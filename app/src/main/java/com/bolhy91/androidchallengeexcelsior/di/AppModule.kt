package com.bolhy91.androidchallengeexcelsior.di

import android.app.Application
import androidx.room.Room
import com.bolhy91.androidchallengeexcelsior.common.Api.BASE_URL
import com.bolhy91.androidchallengeexcelsior.common.Constants.DATABASE_NAME
import com.bolhy91.androidchallengeexcelsior.data.local.ExcelsiorDao
import com.bolhy91.androidchallengeexcelsior.data.local.ExcelsiorDatabase
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

    @Provides
    @Singleton
    fun provideExcelsiorDatabase(app: Application): ExcelsiorDatabase {
        return Room.databaseBuilder(
            app,
            ExcelsiorDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideExcelsiorDao(appDatabase: ExcelsiorDatabase): ExcelsiorDao {
        return appDatabase.dao()
    }
}