package com.bolhy91.androidchallengeexcelsior.domain.use_case.detail_track

import com.bolhy91.androidchallengeexcelsior.common.Resource
import com.bolhy91.androidchallengeexcelsior.domain.models.Track
import com.bolhy91.androidchallengeexcelsior.domain.repository.TrackRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class DetailTrackUseCase @Inject constructor(
    private val repository: TrackRepository
) {
    operator fun invoke(id: Long): Flow<Resource<Track>> = flow {
        try {
            emit(Resource.Loading())
            val track = repository.getTrackById(id)
            emit(Resource.Success(track))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Check you internet connection"))
        }
    }
}