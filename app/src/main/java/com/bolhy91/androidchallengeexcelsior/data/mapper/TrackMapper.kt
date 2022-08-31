package com.bolhy91.androidchallengeexcelsior.data.mapper

import com.bolhy91.androidchallengeexcelsior.data.remote.dto.TrackDto
import com.bolhy91.androidchallengeexcelsior.domain.models.Track

fun TrackDto.toTrack(): Track {
    return Track(
        id = trackID,
        name = trackName,
        artistId = artistID,
        artistName = artistName,
        description = longDescription ?: shortDescription ?: "",
        price = trackPrice,
        country = country,
        publish = releaseDate,
        banner = artworkUrl100,
        preview = previewURL
    )
}