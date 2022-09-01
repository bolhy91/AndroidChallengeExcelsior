package com.bolhy91.androidchallengeexcelsior.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object TrackList : Destination("tracks", emptyList())
    object TrackDetail : Destination("track",
        arguments = listOf(
            navArgument("id") {
                type = NavType.LongType
            }
        ))
}