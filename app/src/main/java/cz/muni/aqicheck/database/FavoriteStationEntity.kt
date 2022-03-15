package cz.muni.aqicheck.database

import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO 4.1 Entity
// TODO 4.2 Jak fungují ROOM migrace? Co se stane když něco změním v @Enity
@Entity
class FavoriteStationEntity(
    @PrimaryKey
    val id: Long,
    val lastKnownAqi: String,
    val lastSyncTime: String,
    val station: String,
)