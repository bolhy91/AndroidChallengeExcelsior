package com.bolhy91.androidchallengeexcelsior.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tracks")
data class TrackEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val artistId: Long,
    val artistName: String,
    val description: String?,
    val price: Double,
    val country: String,
    val publish: String,
    val banner: String,
    val preview: String?,
)
