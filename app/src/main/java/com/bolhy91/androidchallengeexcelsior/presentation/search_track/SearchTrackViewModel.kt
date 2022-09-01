package com.bolhy91.androidchallengeexcelsior.presentation.search_track

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bolhy91.androidchallengeexcelsior.common.Resource
import com.bolhy91.androidchallengeexcelsior.domain.use_case.search_track.SearchTrackUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchTrackViewModel @Inject constructor(
    private val searchTrackUseCase: SearchTrackUseCase
) : ViewModel() {
    private val _state: MutableState<TrackListState> = mutableStateOf(TrackListState())
    val state: State<TrackListState> = _state

    private var searchJob: Job? = null

    fun onEvent(event: SearchTrackEvent) {
        when (event) {
            is SearchTrackEvent.OnSearchQueryChange -> {
                if (event.term.isNotBlank()) {
                    _state.value = _state.value.copy(searchQuery = event.term)
                    searchJob?.cancel()
                    searchJob = viewModelScope.launch {
                        delay(1000L)
                        searchTrack()
                    }
                }
            }
        }
    }

    private fun searchTrack(
        term: String = _state.value.searchQuery!!.lowercase(),
        limit: Long = 50
    ) {
        searchTrackUseCase(term = term, limit = limit).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = TrackListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = TrackListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = TrackListState(
                        tracks = result.data ?: emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}