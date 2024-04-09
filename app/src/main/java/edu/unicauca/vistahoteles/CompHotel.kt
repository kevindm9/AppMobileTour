package edu.unicauca.vistahoteles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun hotelesView(){

    val hoteles = listOf(
        Hotel("Hotel Camino Real", "COP 282.683", "Desayuno incluido","\u2764 ❤ ❤ ", R.drawable.hotel_camino_real),
        Hotel("Hotel La Herreria Colonial", "COP 350.000", "Desayuno incluido","\u2764 ❤ ❤", R.drawable.hotel_la_herreria_colonial),
        Hotel("Hotel SM", "COP 150.000", "Desayuno incluido","\u2764 ❤ ❤ ❤", R.drawable._93597221),
        Hotel("Hotel Dann Monasterio", "COP 150.000", "Desayuno incluido","\u2764 ❤ ❤ ❤ ❤" , R.drawable.hotel_dann_monasterio__popay_n_01)
    )
    LazyColumn {
        items(hoteles) { hotel -> HotelCardView(
            hotel=hotel)
        }
    }

}
@Composable
fun HotelCardView(hotel: Hotel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),

        ) {
        Column(modifier = Modifier.padding(all = 16.dp)) {
            Image(
                painter = painterResource(id = hotel.imagenId),
                contentDescription = "Hotel Image",
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = hotel.nombre,
                    modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium

                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = hotel.precio,
                    modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = hotel.calificacion,
                    modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(8.dp))
            }
            Text(text = hotel.desayunoIncluido,
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
                style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}