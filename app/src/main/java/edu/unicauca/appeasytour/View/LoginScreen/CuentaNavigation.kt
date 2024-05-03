package edu.unicauca.appeasytour.View.LoginScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import edu.unicauca.appeasytour.View.CommentScreen.Views.AddScreen
import edu.unicauca.appeasytour.View.CommentScreen.Views.CommentsScreen
import edu.unicauca.appeasytour.View.CommentScreen.Views.UpdateScreen

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

    }
}

sealed class Screens(val route:String){
    data object CuentaView:Screens("CuentaView")
    data object LoginScreen:Screens("loginScreen")

}
