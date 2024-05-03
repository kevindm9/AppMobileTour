package edu.unicauca.appeasytour.View

import androidx.activity.ComponentActivity
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.unicauca.appeasytour.Repository.RestauranteRepository
import androidx.compose.runtime.*
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import edu.unicauca.appeasytour.Model.RestaurantEntity

@Composable
fun RestaurantView(activity: ComponentActivity, restauranteRepository: RestauranteRepository) {
    var menuItems by remember { mutableStateOf(emptyList<RestaurantEntity>()) }
    var popularItems by remember { mutableStateOf(emptyList<RestaurantEntity>()) }

    LaunchedEffect(restauranteRepository) {
        val menuItemsResult = restauranteRepository.getAllRestaurantes()
        val popularItemsResult = restauranteRepository.getAllRestaurantes()

        menuItems = menuItemsResult
        popularItems = popularItemsResult
    }

    MyApp(menuItems, popularItems)
}

@Composable
private fun MyApp(menuItems: List<RestaurantEntity>, popularItems: List<RestaurantEntity>) {
    RestaurantScreen(menuItems, popularItems)
}

@Composable
private fun RestaurantScreen(menuItems: List<RestaurantEntity>, popularItems: List<RestaurantEntity>) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Restaurantes",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = colorScheme.tertiary,
            onTextLayout = {}
        )
        Text(
            text = "Los Imperdibles",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            onTextLayout = {}
        )
        RestaurantMenu(menuItems, modifier = Modifier.weight(1f))
        Text(
            text = "Los Mas Populares",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            onTextLayout = {}
        )
        PopularItemsList(popularItems)
    }
}

@Composable
private fun RestaurantMenu(menuItems: List<RestaurantEntity>, modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier.padding(end = 8.dp)) {
        itemsIndexed(menuItems) { index, menuItem ->
            RestaurantMenuItem(
                restaurantItem = menuItem,
                modifier = Modifier.padding(end = 16.dp)
            )
        }
    }
}

@Composable
private fun RestaurantMenuItem(
    restaurantItem: RestaurantEntity,
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
            Text(
                text = restaurantItem.nombre,
                style = MaterialTheme.typography.titleSmall,
                onTextLayout = {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = restaurantItem.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                onTextLayout = { }
            )
            Rating(rating = restaurantItem.rating)

        }
    }
}

@Composable
private fun PopularItemsList(popularItems: List<RestaurantEntity>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(popularItems) { index, popularItem ->
            PopularItemRow(popularItem = popularItem)
        }
    }
}

@Composable
private fun PopularItemRow(popularItem: RestaurantEntity) {
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
                    text = popularItem.nombre,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    onTextLayout = { }
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = popularItem.descripcion,
                    style = MaterialTheme.typography.bodyLarge,
                    onTextLayout = { }

                )
                Rating(rating = popularItem.rating)
            }
        }
    }
}

@Composable
private fun Rating(rating: Float) {
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
