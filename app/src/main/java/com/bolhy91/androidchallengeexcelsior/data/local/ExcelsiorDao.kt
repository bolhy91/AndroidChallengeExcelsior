package com.bolhy91.androidchallengeexcelsior.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface ExcelsiorDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertTracks(tracks: List<TrackEntity>)

    @Query(
        """
        SELECT * FROM tracks
        WHERE LOWER(name) LIKE '%' || LOWER(:name) || '%'
    """
    )
    suspend fun searchTracks(name: String?): List<TrackEntity>

    @Query(
        """
        SELECT * FROM tracks as c WHERE c.id =:id
    """
    )
    suspend fun getTrackById(id: Long): TrackEntity
}