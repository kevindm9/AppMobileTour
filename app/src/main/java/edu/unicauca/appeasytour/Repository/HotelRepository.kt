package edu.unicauca.appeasytour.Repository

import edu.unicauca.appeasytour.Model.Hotel
import edu.unicauca.appeasytour.Model.HotelEntity
import edu.unicauca.appeasytour.Model.IHotelDao
import edu.unicauca.appeasytour.Model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HotelRepository (private val hotelDao: IHotelDao) :IHotelRepository  {
   override fun getAllItemsStream(): List<Hotel> {
        val hotel=hotelDao.getAllItems()
       return hotel.map { it.toDomain() }
    }

    override fun getItemStream(id: Int): Hotel {
        val hotel=hotelDao.getItem(id)
        return hotel.toDomain()
    }
}