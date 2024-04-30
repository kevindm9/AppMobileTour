package edu.unicauca.appeasytour.Repository

import edu.unicauca.appeasytour.Model.Hotel
import edu.unicauca.appeasytour.Model.HotelEntity
import kotlinx.coroutines.flow.Flow

interface IHotelRepository {
    fun getAllItemsStream(): List<Hotel>

    fun getItemStream(id: Int): Hotel
}