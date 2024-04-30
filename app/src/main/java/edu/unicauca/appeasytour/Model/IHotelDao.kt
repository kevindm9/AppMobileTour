package edu.unicauca.appeasytour.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface IHotelDao {

    @Query("SELECT * from HotelEntity ORDER BY id ASC")
    fun getAllItems(): List<HotelEntity>

    @Query("SELECT * from HotelEntity WHERE id = :id")
    fun getItem(id: Int): HotelEntity

}