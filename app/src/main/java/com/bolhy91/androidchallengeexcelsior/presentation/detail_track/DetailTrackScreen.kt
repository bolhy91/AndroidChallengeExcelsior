package com.bolhy91.androidchallengeexcelsior.presentation.detail_track

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.bolhy91.androidchallengeexcelsior.presentation.detail_track.components.BodySection
import com.bolhy91.androidchallengeexcelsior.presentation.detail_track.components.TopBarSectionDetail

@Composable
fun DetailTrackScreen(
    viewModel: DetailTrackViewModel = hiltViewModel(),
    pressOnBack: () -> Unit
) {
    val state = viewModel.state.value

        Column {
            TopBarSectionDetail(pressOnBack)
            state.track?.let { BodySection(track = it) }
        }

}