package com.bolhy91.androidchallengeexcelsior.domain.models
data class Track(
    val id: Long,
    val name: String,
    val artistId: Long,
    val artistName: String,
    val description: String?,
    val price: Double,
    val country: String,
    val publish: String,
    val banner: String,
    val preview: String,
)