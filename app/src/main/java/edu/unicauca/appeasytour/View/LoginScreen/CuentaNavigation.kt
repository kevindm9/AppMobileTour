package edu.unicauca.appeasytour.View.LoginScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.unicauca.appeasytour.View.about
import edu.unicauca.appeasytour.View.cuentaView

@Composable
fun LoginNavigation(navController: NavHostController) {
    NavHost(
        navController =navController, startDestination = Screens.CuentaView.route
    ){
        composable(route = Screens.CuentaView.route){
            cuentaView(navController)
        }
        composable(route = Screens.LoginScreen.route){
            LoginScreen(navController)
        }

        composable(route = Screens.about.route){
            about()
        }

    }
}

sealed class Screens(val route:String){
    data object CuentaView:Screens("CuentaView")
    data object LoginScreen:Screens("loginScreen")
    data object about:Screens("about")
}
