package com.bolhy91.androidchallengeexcelsior.di

import com.bolhy91.androidchallengeexcelsior.data.repository.TrackRepositoryImpl
import com.bolhy91.androidchallengeexcelsior.data.txt.SearchTrackParser
import com.bolhy91.androidchallengeexcelsior.data.txt.TXTParser
import com.bolhy91.androidchallengeexcelsior.domain.models.Track
import com.bolhy91.androidchallengeexcelsior.domain.repository.TrackRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSearchTrackParser(searchTrackParser: SearchTrackParser): TXTParser<Track>

    @Binds
    @Singleton
    abstract fun bindTrackRepository(trackRepositoryImpl: TrackRepositoryImpl): TrackRepository

}