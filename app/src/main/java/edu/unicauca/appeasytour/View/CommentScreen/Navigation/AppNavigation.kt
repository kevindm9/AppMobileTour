package edu.unicauca.appeasytour.View.CommentScreen.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import edu.unicauca.appeasytour.View.CommentScreen.Views.AddScreen
import edu.unicauca.appeasytour.View.CommentScreen.Views.CommentsScreen
import edu.unicauca.appeasytour.View.CommentScreen.Views.UpdateScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController =navController
        , startDestination = Screens.CommentsScreen.route
    ){
        composable(route = Screens.CommentsScreen.route){
            CommentsScreen(navController)
        }
        composable(route = Screens.AddScreen.route){
            AddScreen(navController)
        }
        composable(
            route = Screens.UpdateScreen.route, arguments = listOf(
                navArgument("id"){
                    type= NavType.IntType
                }
            )
        ){
            UpdateScreen(navController)
        }
    }
}

sealed class Screens(val route:String){
    data object CommentsScreen:Screens("commentscreen")
    data object AddScreen:Screens("addscreen")
    data object UpdateScreen:Screens("update/{id}"){
        fun getById(id:Int)="update/$id"
    }
}


