package edu.unicauca.appeasytour.View

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.appeasytour.R


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
                        painter = painterResource(R.drawable.sliders_horizontal__1_),
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
                        painter = painterResource(R.drawable.arrow_down_up__1_),
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

@Preview
@Composable
fun FilterAndSortComponentPreview() {
    MaterialTheme {
        FilterAndSortComponent(
        )
    }
}