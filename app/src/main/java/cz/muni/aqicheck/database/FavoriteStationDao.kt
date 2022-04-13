package cz.muni.aqicheck.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoriteStationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEntity(entity: FavoriteStationEntity)

    @Query("DELETE FROM FavoriteStationEntity WHERE id = :id")
    fun deleteById(id: Long)

    @Query("SELECT * FROM FavoriteStationEntity")
    fun getAll(): List<FavoriteStationEntity>
}