package edu.unicauca.appeasytour.Repository

import android.content.Context

/**
 * App container for Dependency injection.

interface AppContainer {
    val hotelRepository: IHotelRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val hotelRepository: IHotelRepository by lazy {
        HotelRepository(HotelDataBase.getDatabase(context).hotelDao())
    }
}
 */