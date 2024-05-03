package edu.unicauca.appeasytour.View

import edu.unicauca.appeasytour.R
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MenuItem(
    val title: String,
    val description: String,
    val rating: Float,
    val imageUrl: Int
)

val menuItems = listOf(
    MenuItem("Mora Castilla", "Latina Colombiana",3.5f, R.drawable.photo1jpg),
    MenuItem("La cosecha Parrillada", "Especial en Carnes",3.5f, R.drawable.piatto_di_carne),
    MenuItem("Paccos", "Comida Rapida",3.5f, R.drawable.descarga),
)

val popularItems = listOf(
    PopularItem("Carantanta", "Vivir momentos especiales, en un lugar magico \uD83D\uDE0D y deliciosa comida", R.drawable.descarga__2_,3.5f),
    PopularItem("El Quijote", "Tiene asientos al aire libre,Ofrece platos vegetarianos,Tiene música en vivo",
        R.drawable.entrada_del_restaurante,3.5f),
    PopularItem("Loncheria Caldas", "Explora un mundo de sabores tentadores y descubre nuestro paraíso gastronómico.", R.drawable.descarga__1_,3.5f)
)

data class PopularItem(
    val title: String,
    val description: String,
    val imageUrl: Int,
    val rating: Float
)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantView() {
    RestaurantScreen()
}


@Composable
fun RestaurantScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Los Imperdibles",
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
            ,fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            onTextLayout = {}
        )
        RestaurantMenu(menuItems,modifier = Modifier.weight(1f))
        Text(text = "Los Mas Populares",
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
            ,fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            onTextLayout = {}
        )
        PopularItemsList(popularItems)

    }
}
@Composable
fun RestaurantMenu(menuItems: List<MenuItem>,modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier.padding(end = 8.dp) ) {
        items(menuItems) { menuItem ->
            RestaurantMenuItem(
                restaurantItem = menuItem ,
                modifier = Modifier.padding(end = 16.dp)

            )
        }
    }
}

@Composable
fun RestaurantMenuItem(restaurantItem: MenuItem,
                       modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,

        ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = restaurantItem.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = restaurantItem.title, style = MaterialTheme.typography.titleSmall, onTextLayout = {})
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = restaurantItem.description, style = MaterialTheme.typography.bodyMedium, onTextLayout = {})
            Rating(rating = restaurantItem.rating)
        }
    }
}

@Composable
fun PopularItemsList(popularItems: List<PopularItem>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(popularItems) { popularItem ->
            PopularItemRow(popularItem = popularItem)
        }
    }
}


@Composable
fun PopularItemRow(popularItem: PopularItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = popularItem.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = popularItem.title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    onTextLayout = {}
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = popularItem.description,
                    style = MaterialTheme.typography.bodyLarge,
                    onTextLayout = {}
                )
                Rating(rating = popularItem.rating)
            }
        }
    }
}


@Composable
fun Rating(rating: Float) {
    Row {
        repeat(5) { index ->
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = if (rating >= index + 1) Color.Red else Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RestaurantView()

}
