package edu.unicauca.appeasytour.Repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.unicauca.appeasytour.Model.HotelEntity
import edu.unicauca.appeasytour.Model.IHotelDao

@Database(entities = [HotelEntity::class], version = 1, exportSchema = false)
abstract class HotelDataBase : RoomDatabase() {

    abstract fun hotelDao(): IHotelDao

    companion object {
        @Volatile
        private var Instance: HotelDataBase? = null

        fun getDatabase(context: Context): HotelDataBase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, HotelDataBase::class.java, "tour_database")
                    /**
                     * Setting this option in your app's database builder means that Room
                     * permanently deletes all data from the tables in your database when it
                     * attempts to perform a migration with no defined migration path.
                     */
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}