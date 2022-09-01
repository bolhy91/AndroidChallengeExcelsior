package com.bolhy91.androidchallengeexcelsior.presentation.detail_track

import com.bolhy91.androidchallengeexcelsior.domain.models.Track

data class DetailTrackState(
    val track: Track? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
