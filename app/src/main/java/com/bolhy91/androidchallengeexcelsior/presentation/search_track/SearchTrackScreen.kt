package com.bolhy91.androidchallengeexcelsior.presentation.search_track

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bolhy91.androidchallengeexcelsior.presentation.search_track.components.TrackItem
import com.bolhy91.androidchallengeexcelsior.ui.components.InputSearchComponent
import com.bolhy91.androidchallengeexcelsior.ui.components.ShimmerLoading
import com.bolhy91.androidchallengeexcelsior.ui.components.TopBarComponent
import com.bolhy91.androidchallengeexcelsior.ui.theme.AndroidChallengeExcelsiorTheme

@Composable
fun SearchTrackScreen(
    viewModel: SearchTrackViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            Column {
                TopBarComponent()
                InputSearchComponent(onInputValue = {})
            }
        },
        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
            ) {
                items(state.tracks.size) { index ->
                    TrackItem(track = state.tracks[index], itemClick = {})
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }

            if (state.error?.isNotBlank() == true) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }

            if (state.isLoading) {
                Column(modifier = Modifier.padding(top = 20.dp)) {
                    repeat(10) {
                        ShimmerLoading()
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun SearchTrackScreenPreview() {
    AndroidChallengeExcelsiorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            SearchTrackScreen()
        }
    }
}