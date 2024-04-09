package edu.unicauca.vistahoteles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    Scaffold(
        topBar={
            Column{
                TopAppBar(

                    navigationIcon = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    title = {
                        Text(
                            "Hospedaje",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },

                    )
                NavigationSup();
                SearchBar();
                FilterAndSortComponent();
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
                                text = "Inicio"
                            )
                        },
                        selected = true,
                        onClick = {}
                    )
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = "Buscar"
                            )
                        },
                        selected = true,
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
                                text = "Editar"
                            )
                        },
                        selected = true,
                        onClick = {}
                    )
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.CalendarMonth,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = "Planificar"
                            )
                        },
                        selected = true,
                        onClick = {}
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
                                text = "Mi cuenta"
                            )
                        },
                        selected = true,
                        onClick = {}
                    )

                },

                )
        },
        ) {innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            hotelesView()
        }

    }

}
