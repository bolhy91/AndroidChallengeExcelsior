package com.bolhy91.androidchallengeexcelsior.domain.use_case.search_track

import com.bolhy91.androidchallengeexcelsior.common.Resource
import com.bolhy91.androidchallengeexcelsior.domain.models.Track
import com.bolhy91.androidchallengeexcelsior.domain.repository.TrackRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchTrackUseCase @Inject constructor(private val repository: TrackRepository) {
    operator fun invoke(term: String, limit: Long): Flow<Resource<List<Track>>> = flow {
        try {
            emit(Resource.Loading())
            val tracks = repository.searchTracks(term, limit)
            emit(Resource.Success(tracks))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Check you internet connection"))
        }
    }
}