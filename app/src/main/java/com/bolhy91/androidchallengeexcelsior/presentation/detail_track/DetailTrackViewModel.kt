package com.bolhy91.androidchallengeexcelsior.presentation.detail_track

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailTrackViewModel @Inject constructor(
) : ViewModel() {
    var state by mutableStateOf(DetailTrackState())

    init {

    }

}