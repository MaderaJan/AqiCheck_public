package cz.muni.aqicheck.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// TODO 6.1 Database
// TODO 6.2 entities
// TODO 6.3 .create přes companion object. Co je companion object?
// TODO 6.4 allowMainThreadQueries
@Database(
    entities = [FavoriteStationEntity::class],
    version = 1
)
abstract class AqiDatabase : RoomDatabase() {

    companion object {
        private const val NAME = "aqi-mock.db"

        fun create(context: Context): AqiDatabase =
            Room.databaseBuilder(context, AqiDatabase::class.java, NAME)
                .allowMainThreadQueries()
                .build()
    }

    abstract fun favoriteStationDao(): FavoriteStationDao
}