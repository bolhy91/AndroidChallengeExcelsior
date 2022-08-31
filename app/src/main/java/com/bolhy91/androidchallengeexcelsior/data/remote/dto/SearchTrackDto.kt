package com.bolhy91.androidchallengeexcelsior.data.remote.dto

data class SearchTrackDto(
    val resultCount: Long,
    val results: List<TrackDto>
)