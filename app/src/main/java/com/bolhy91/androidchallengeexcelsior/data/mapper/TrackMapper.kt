package com.bolhy91.androidchallengeexcelsior.data.mapper

import com.bolhy91.androidchallengeexcelsior.data.local.TrackEntity
import com.bolhy91.androidchallengeexcelsior.data.remote.dto.TrackDto
import com.bolhy91.androidchallengeexcelsior.domain.models.Track
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun TrackDto.toTrack(): Track {
    return Track(
        id = trackId,
        name = trackName ?: "Undefined",
        artistId = artistId,
        artistName = artistName ?: "Undefined",
        description = longDescription ?: shortDescription ?: "",
        price = trackPrice,
        country = country,
        publish = releaseDate ?: "Undefined",
        banner = artworkUrl100,
        preview = previewURL ?: ""
    )
}

fun TrackEntity.toTrack(): Track {
    return Track(
        id = id,
        name = name,
        artistId = artistId,
        artistName = artistName,
        description = description ?: "",
        price = price,
        country = country,
        publish = publish,
        banner = banner,
        preview = preview ?: ""
    )
}

fun Track.toTrackEntity(): TrackEntity {
    return TrackEntity(
        id = id,
        name = name,
        artistId = artistId,
        artistName = artistName,
        description = description,
        price = price,
        country = country,
        publish = publish,
        banner = banner,
        preview = preview ?: ""
    )
}