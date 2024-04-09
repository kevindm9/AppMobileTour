package edu.unicauca.vistahoteles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource


@Composable
fun FilterAndSortComponent(modifier: Modifier = Modifier

) {
    Row(modifier = Modifier.fillMaxWidth() ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            modifier = modifier.fillMaxWidth().padding(8.dp)
        ){
            NavigationBarItem(

                icon = {
                    Icon(
                        painter = painterResource(R.drawable.sliders_horizontal),
                        contentDescription = null
                    )
                },
                label = {
                    Text("Filtro")
                },
                selected = false,
                onClick = {}
            )
            NavigationBarItem(

                icon = {
                    Icon(
                        painter = painterResource(R.drawable.arrow_up_down),
                        contentDescription = null
                    )
                },
                label = {
                    Text("Ordenar")
                },
                selected = false,
                onClick = {}
            )

        }
    }

}

