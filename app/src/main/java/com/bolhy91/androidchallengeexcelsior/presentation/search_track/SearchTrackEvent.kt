package com.bolhy91.androidchallengeexcelsior.presentation.search_track

sealed class SearchTrackEvent {
    data class OnSearchQueryChange(val term: String) : SearchTrackEvent()
}
