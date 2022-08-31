package com.bolhy91.androidchallengeexcelsior.presentation.search_track

import com.bolhy91.androidchallengeexcelsior.domain.models.Track

data class TrackListState(
    val tracks: List<Track> = emptyList(),
    val isLoading: Boolean = false,
    val searchQuery: String? = null,
    val error: String? = null
)