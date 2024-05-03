package edu.unicauca.appeasytour.View



import edu.unicauca.appeasytour.R
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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


data class Puntos(
    val title: String,
    val description: String,
    val rating: Float,
    val imageUrl: Int
)

val puntos = listOf(
    Puntos("Noche de Museos", "Viernes 25",3.5f, R.drawable.noche_de_museos),
    Puntos("Concierto Libre", "Agrupaciones locales",3.5f, R.drawable.concierto_libre),
    Puntos("Caminata la Torre", "24 julio",3.5f, R.drawable.caminata),
    Puntos("Concierto Coliceo Estancia", "2 marzo",3.5f, R.drawable.concierto1),
)

val popularPuntos = listOf(
    PopularPuntos("Museo Natural", "Museo de historia natural", R.drawable.museo_natural,3.5f),
    PopularPuntos("Museo Guillermo Valencia", "lugar lleno de cultura y arte, la conservación arquitectónica es única.", R.drawable.m_guillermo,3.5f),
    PopularPuntos("Morro de Tulcan", "La pirámide indígena construida sobre Popayán.", R.drawable.morro,3.5f),
    PopularPuntos("Museo Nacional", "Se trata de una gran casona de interesante arquitectura y un bonito patio interior que la hace muy interesante.", R.drawable.museo,3.5f)
)

data class PopularPuntos(
    val title: String,
    val description: String,
    val imageUrl: Int,
    val rating: Float
)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PuntosView() {
    PuntosScreen()
}


@Composable
fun PuntosScreen(){
    Column(modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Proximos Eventos",
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
            ,fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            onTextLayout = {}
        )
        PuntosHor(puntos,modifier = Modifier.weight(1f))
        Text(text = "Lugares más Populares",
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
            ,fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            onTextLayout = {}
        )
        PopularItemsList(popularPuntos)

    }
}
@Composable
fun PuntosHor(menuItems: List<Puntos>, modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier.padding(end = 8.dp) ) {
        items(menuItems) { menuItem ->
            PuntosItem(
                puntosItem = menuItem ,
                modifier = Modifier.padding(end = 16.dp)

            )
        }
    }
}

@Composable
fun PuntosItem(puntosItem: Puntos,
                       modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,

        ) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment =Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = puntosItem.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(150.dp)
                    .height(100.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
            Text(text = puntosItem.title, style = MaterialTheme.typography.titleSmall, onTextLayout = {})
            Text(text = puntosItem.description, style = MaterialTheme.typography.bodyMedium, onTextLayout = {})
            Rating(rating = puntosItem.rating)
        }
    }
}

@Composable
fun PopularItemsList(popularItems: List<PopularPuntos>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(popularItems) { popularItem ->
            PopularItemRow(popularItem = popularItem)
        }
    }
}


@Composable
fun PopularItemRow(popularItem: PopularPuntos) {
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

@Preview
@Composable
fun PrevPuntos(){
    PuntosView()
}
