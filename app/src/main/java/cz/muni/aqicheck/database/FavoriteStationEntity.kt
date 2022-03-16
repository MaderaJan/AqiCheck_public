package cz.muni.aqicheck.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FavoriteStationEntity(
    @PrimaryKey
    val id: Long,
    val lastKnownAqi: String,
    val lastSyncTime: String,
    val station: String,
)