package edu.unicauca.appeasytour

import edu.unicauca.appeasytour.MapActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.libraries.places.api.Places
import dagger.hilt.android.AndroidEntryPoint
import edu.unicauca.appeasytour.View.CommentScreen.Navigation.AppNavigation
import edu.unicauca.appeasytour.View.CommentScreen.Views.CommentsScreen
import edu.unicauca.appeasytour.View.LoginScreen.LoginScreen
import edu.unicauca.appeasytour.View.Navigation
import edu.unicauca.appeasytour.ui.theme.AppEasyTourTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppEasyTourTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Call MyGoogleMaps function from MapActivity
                    //val mapActivity = MapActivity()
                    // Llamar a MapScreen
                    //mapActivity.MapScreen()
                    //MapActivity().MyGoogleMaps()
                    Navigation()
                    //LoginScreen()
                }
            }
        }
    }
}


