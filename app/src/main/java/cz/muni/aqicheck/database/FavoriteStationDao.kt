package cz.muni.aqicheck.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// TODO 5.1 Dao
@Dao
interface FavoriteStationDao {

    // TODO 5.2 SAVE a strategy
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEntity(entity: FavoriteStationEntity)

    // TODO 5.3 DELETE
    @Query("DELETE FROM FavoriteStationEntity WHERE id = :id")
    fun deleteById(id: Long)

    // TODO 5.4 SELCT *
    @Query("SELECT * FROM FavoriteStationEntity")
    fun getAll(): List<FavoriteStationEntity>
}