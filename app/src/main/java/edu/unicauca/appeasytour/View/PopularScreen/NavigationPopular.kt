package edu.unicauca.appeasytour.View.PopularScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.unicauca.appeasytour.MapActivity
import edu.unicauca.appeasytour.View.LoginScreen.LoginScreen


@Composable
fun NavigationPopular(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.PopularScreen.route
    ){
        composable(route = Screens.PopularScreen.route){
            Union(navController)
        }

        composable(route = Screens.MapScreen.route){
            val mapActivity = MapActivity()
            mapActivity.MapScreen()
        }
    }
}

sealed class Screens(val route:String){
    object PopularScreen: Screens("PopularScreen")
    object MapScreen: Screens("MapScreen")
}