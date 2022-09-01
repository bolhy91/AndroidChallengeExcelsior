package com.bolhy91.androidchallengeexcelsior.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bolhy91.androidchallengeexcelsior.presentation.detail_track.DetailTrackScreen
import com.bolhy91.androidchallengeexcelsior.presentation.search_track.SearchTrackScreen

@Composable
fun ExcelsiorNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Destination.TrackList.route) {
        tracksListNav(navHostController)
        trackDetailNav(navHostController)
    }
}

fun NavGraphBuilder.tracksListNav(navHostController: NavHostController) {
    composable(route = Destination.TrackList.route) {
        SearchTrackScreen(
            itemClick = { id ->
                navHostController.navigate("${Destination.TrackDetail.route}/${id}") {
                    popUpTo(navHostController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                }
            }
        )
    }
}

fun NavGraphBuilder.trackDetailNav(navHostController: NavHostController) {
    composable(
        route = Destination.TrackDetail.route + "/{id}",
        arguments = Destination.TrackDetail.arguments
    ) {
        DetailTrackScreen(
            pressOnBack = { navHostController.popBackStack() }
        )
    }
}