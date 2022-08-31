package com.bolhy91.androidchallengeexcelsior.data.repository

import com.bolhy91.androidchallengeexcelsior.data.remote.ExcelsiorApi
import com.bolhy91.androidchallengeexcelsior.data.txt.TXTParser
import com.bolhy91.androidchallengeexcelsior.domain.models.Track
import com.bolhy91.androidchallengeexcelsior.domain.repository.TrackRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrackRepositoryImpl @Inject constructor(
    private val excelsiorApi: ExcelsiorApi,
    private val searchTrackParse: TXTParser<Track>
) : TrackRepository {
    override suspend fun searchTracks(term: String, limit: Long): List<Track> {
        val response = excelsiorApi.searchSong(term = term, limit = limit)
        return searchTrackParse.parse(response.toString())
    }
}