package com.bolhy91.androidchallengeexcelsior.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [TrackEntity::class],
    version = 1
)
abstract class ExcelsiorDatabase : RoomDatabase() {
    abstract fun dao(): ExcelsiorDao
}