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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import edu.unicauca.appeasytour.R

@Composable
fun NavigationSup(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("Hotel") }
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
                Text("Popular")
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.hotel__1_),
                    contentDescription = null
                )
            },
            label = {
                Text("hoteles")
            },
            selected = true,
            onClick = {
                currentScreen = "Hotel"
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.utensils_crossed__1_),
                    contentDescription = null
                )
            },
            label = {
                Text("Restaurante")
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.goal__1_),
                    contentDescription = null
                )
            },
            label = {
                Text("Puntos")
            },
            selected = false,
            onClick = {}
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
        modifier = Modifier.padding(16. dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        SearchBar();
        FilterAndSortComponent();
    }

    when (currentScreen) {
        "Hotel" -> hotelesView()
        // Agrega casos para otras pantallas si es necesario
    }
}

@Preview
@Composable
fun preNavSup(){
    NavigationSup()
}