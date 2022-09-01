package com.bolhy91.androidchallengeexcelsior.presentation.detail_track

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bolhy91.androidchallengeexcelsior.common.Constants.PARAM_TRACK_ID
import com.bolhy91.androidchallengeexcelsior.common.Resource
import com.bolhy91.androidchallengeexcelsior.domain.use_case.detail_track.DetailTrackUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailTrackViewModel @Inject constructor(
    private val detailTrackUseCase: DetailTrackUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(DetailTrackState())
    var state: State<DetailTrackState> = _state

    init {
        savedStateHandle.get<Long>(PARAM_TRACK_ID)?.let { trackId ->
            getTrack(trackId)
        }
    }

    private fun getTrack(id: Long) {
        detailTrackUseCase(id).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = DetailTrackState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = DetailTrackState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = DetailTrackState(track = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}