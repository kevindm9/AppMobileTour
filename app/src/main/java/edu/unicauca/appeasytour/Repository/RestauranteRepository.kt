package edu.unicauca.appeasytour.Repository

import edu.unicauca.appeasytour.Model.IRestauranteDao
import edu.unicauca.appeasytour.Model.RestaurantEntity

class RestauranteRepository(private val restauranteDao: IRestauranteDao) {

    suspend fun getAllRestaurantes(): List<RestaurantEntity> {
        return restauranteDao.getAllRestaurantes()
    }

    suspend fun insertRestaurante(restaurante: RestaurantEntity) {
        restauranteDao.insertRestaurante(restaurante)
    }
}