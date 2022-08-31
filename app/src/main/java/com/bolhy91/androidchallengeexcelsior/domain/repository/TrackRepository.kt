package com.bolhy91.androidchallengeexcelsior.domain.repository

import com.bolhy91.androidchallengeexcelsior.domain.models.Track

interface TrackRepository {
    suspend fun searchTracks(term: String, limit: Long): List<Track>
}