package edu.unicauca.vistahoteles


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Adjust
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NavigationSup(modifier: Modifier = Modifier) {

    NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            modifier = modifier.fillMaxWidth().padding(8.dp)

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
                selected = true,
                onClick = {}
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Hotel,
                        contentDescription = null
                    )
                },
                label = {
                    Text("hoteles")
                },
                selected = false,
                onClick = {}
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Coffee,
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
                        imageVector = Icons.Rounded.Adjust,
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

}