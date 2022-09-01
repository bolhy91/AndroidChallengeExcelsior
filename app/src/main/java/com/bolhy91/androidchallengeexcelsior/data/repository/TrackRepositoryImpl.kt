package com.bolhy91.androidchallengeexcelsior.data.repository

import android.util.Log
import com.bolhy91.androidchallengeexcelsior.data.local.ExcelsiorDao
import com.bolhy91.androidchallengeexcelsior.data.mapper.toTrack
import com.bolhy91.androidchallengeexcelsior.data.mapper.toTrackEntity
import com.bolhy91.androidchallengeexcelsior.data.remote.ExcelsiorApi
import com.bolhy91.androidchallengeexcelsior.data.txt.TXTParser
import com.bolhy91.androidchallengeexcelsior.domain.models.Track
import com.bolhy91.androidchallengeexcelsior.domain.repository.TrackRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TrackRepositoryImpl @Inject constructor(
    private val excelsiorApi: ExcelsiorApi,
    private val excelsiorDao: ExcelsiorDao,
    private val searchTrackParse: TXTParser<Track>
) : TrackRepository {
    override suspend fun searchTracks(term: String, limit: Long): List<Track> {

        val localTracks = excelsiorDao.searchTracks(name = term)
        Log.i("LOCAL TRACKS", localTracks.toString())
        if (localTracks.isNotEmpty()) {
            return localTracks.map { it.toTrack() }
        }
        val remoteResponse = try {
            val response = excelsiorApi.searchSong(term = term, limit = limit)
            Log.i("RESPONSE HTTP: ", response.toString())
            searchTrackParse.parse(response.byteStream())
        } catch (e: IOException) {
            e.printStackTrace()
            null
        } catch (e: HttpException) {
            e.printStackTrace()
            null
        }
        Log.i("REMOTE RESPONSE`: ", remoteResponse.toString())
        remoteResponse?.let { tracks ->
            excelsiorDao.insertTracks(tracks.map { it.toTrackEntity() })
        }
        val results = excelsiorDao.searchTracks(term)
        return results.map { it.toTrack() }
    }

    override suspend fun getTrackById(id: Long): Track {
        return excelsiorDao.getTrackById(id).toTrack()
    }
}