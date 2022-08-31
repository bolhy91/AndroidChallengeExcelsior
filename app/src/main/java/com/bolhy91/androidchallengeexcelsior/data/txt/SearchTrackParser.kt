package com.bolhy91.androidchallengeexcelsior.data.txt

import com.bolhy91.androidchallengeexcelsior.data.mapper.toTrack
import com.bolhy91.androidchallengeexcelsior.data.remote.dto.SearchTrackDto
import com.bolhy91.androidchallengeexcelsior.domain.models.Track
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchTrackParser @Inject constructor() : TXTParser<Track> {
    override suspend fun parse(response: InputStream): List<Track> {
        val gson = Gson()
        return withContext(Dispatchers.IO) {
            val reader = InputStreamReader(response)
            val result = gson.fromJson(reader, SearchTrackDto::class.java)
            result.results.map { trackDto ->
                trackDto.toTrack()
            }
        }
    }
}