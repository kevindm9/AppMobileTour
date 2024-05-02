package edu.unicauca.appeasytour.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import edu.unicauca.appeasytour.R
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import edu.unicauca.appeasytour.ui.theme.logoSelect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    var currentScreen by remember { mutableStateOf("Home") }

    Scaffold(
        topBar={
            Column{
                TopAppBar(

                    navigationIcon = {
                        IconButton(onClick = { currentScreen = "Home" }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    title = {
                        Text(
                            "Easy Tour",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    actions = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                painter = painterResource(R.drawable.logo),
                                contentDescription = "Localized description"
                            )
                        }
                    },

                    )


            }


        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                stringResource(id = R.string.Home)
                            )
                        },
                        selected = currentScreen == "Home",
                        onClick = { currentScreen = "Home" },
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
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(stringResource(id = R.string.Search))
                        },
                        selected = false,
                        onClick = {}
                    )
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                stringResource(id = R.string.Quality)
                            )
                        },
                        selected = false,
                        onClick = {},
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
                                painter = painterResource(R.drawable.calendar_days),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                stringResource(id = R.string.To_plan)
                            )
                        },
                        selected = false,
                        onClick = {},
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
                                imageVector = Icons.Rounded.AccountCircle,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                stringResource(id = R.string.Account)
                            )
                        },
                        selected = currentScreen == "Account" ,
                        onClick = {currentScreen = "Account" },
                        colors = NavigationBarItemDefaults.colors(

                            selectedIconColor = MaterialTheme.colorScheme.logoSelect,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                            selectedTextColor = MaterialTheme.colorScheme.logoSelect, // Color del texto cuando está seleccionado
                            unselectedTextColor = MaterialTheme.colorScheme.onSurface // Color del texto cuando no está seleccionado
                        )
                    )

                },

                )
        },
    ) {innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            when (currentScreen) {
                "Home" -> {
                    NavigationSup()
                }

                "Account" -> AppCuenta()
            }
        }

    }

}