package edu.unicauca.appeasytour.View


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import edu.unicauca.appeasytour.R
import edu.unicauca.appeasytour.View.PopularScreen.NavigationPopular
import edu.unicauca.appeasytour.View.LoginScreen.LoginNavigation
import edu.unicauca.appeasytour.View.LoginScreen.LoginScreen
import edu.unicauca.appeasytour.View.PopularScreen.NavigationPopular
import edu.unicauca.appeasytour.View.PopularScreen.Union
import edu.unicauca.appeasytour.ui.theme.logoSelect

@Composable
fun NavigationSup(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    var currentScreen by remember { mutableStateOf("Popular") }
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)

    )
    {

        NavigationBarItem(

            icon = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(id = R.string.Popular))
            },
            selected = currentScreen=="Popular",
            onClick = {
                currentScreen="Popular"
            },
            colors = NavigationBarItemDefaults.colors(

                selectedIconColor = MaterialTheme.colorScheme.logoSelect,
                unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                selectedTextColor = MaterialTheme.colorScheme.logoSelect, // Color del texto cuando está seleccionado
                unselectedTextColor = MaterialTheme.colorScheme.onSurface // Color del texto cuando no está seleccionado
            )

        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.hotel__1_),
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(id = R.string.Hotel))
            },
            selected = currentScreen == "Hotel",
            onClick = {
                currentScreen = "Hotel"
            },
            colors = NavigationBarItemDefaults.colors(

                selectedIconColor = MaterialTheme.colorScheme.logoSelect,
                unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                selectedTextColor = MaterialTheme.colorScheme.logoSelect, // Color del texto cuando está seleccionado
                unselectedTextColor = MaterialTheme.colorScheme.onSurface // Color del texto cuando no está seleccionado
            )
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.utensils_crossed__1_),
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(id = R.string.Restaurant))
            },
            selected = currentScreen == "Restaurante",
            onClick = {currentScreen = "Restaurante"},
            colors = NavigationBarItemDefaults.colors(

                selectedIconColor = MaterialTheme.colorScheme.logoSelect,
                unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                selectedTextColor = MaterialTheme.colorScheme.logoSelect, // Color del texto cuando está seleccionado
                unselectedTextColor = MaterialTheme.colorScheme.onSurface // Color del texto cuando no está seleccionado
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.goal__1_),
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(id = R.string.Target))
            },
            selected = currentScreen == "Puntos",
            onClick = {
                currentScreen = "Puntos"
            },
            colors = NavigationBarItemDefaults.colors(

                selectedIconColor = MaterialTheme.colorScheme.logoSelect,
                unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                selectedTextColor = MaterialTheme.colorScheme.logoSelect, // Color del texto cuando está seleccionado
                unselectedTextColor = MaterialTheme.colorScheme.onSurface // Color del texto cuando no está seleccionado
            )
        )



        /*NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.AutoAwesome,
                    contentDescription = null
                )
            },
            label = {
                Text("Cosas \n" +
                        "por hacer")
            },
            selected = false,
            onClick = {}
        )*/
    }
    Column(
        modifier = Modifier.padding(8. dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SearchBar();

    }

    when (currentScreen) {
        "Hotel" -> hotelesView()
        "Puntos" ->  PuntosView()
        "Restaurante"-> RestaurantView()
        "Popular" ->  NavigationPopular(rememberNavController())

        // Agrega casos para otras pantallas si es necesario
    }
}

@Preview
@Composable
fun preNavSup(){
    NavigationSup()
}