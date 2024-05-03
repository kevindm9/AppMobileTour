package edu.unicauca.appeasytour.View.PopularScreen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.unicauca.appeasytour.R

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

private val DestinosTuristicos = listOf(
    R.drawable.parque_caldas to R.string.parque_caldas,
    R.drawable.morro_tulcan to R.string.morro_tulcan,
    R.drawable.puente_humilladero to R.string.puente_humilladero,
    R.drawable.iglesia_santo_domingo to R.string.iglesia_santo_domingo,
    R.drawable.pueblito_patojo to R.string.pueblito_patojo,
).map {DrawableStringPair(it.first, it.second) }

private val HotelesRecomendados = listOf(
    R.drawable.hotel_danm_monasterio to R.string.hotel_danm_monasterio,
    R.drawable.hotel_san_martin to R.string.hotel_san_martin,
    R.drawable.hotel_torre_real to R.string.hotel_torre_real,
).map {DrawableStringPair(it.first, it.second) }

@Composable
fun Tarjetas(
    @DrawableRes drawable: Int,
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(
            horizontalAlignment= Alignment.Start

        ) {
            Image(
                painterResource(id= drawable),
                contentDescription = null,
                contentScale= ContentScale.FillBounds,
                modifier = Modifier
                    .size(300.dp)

            )
            Text(
                stringResource(id = title),
                fontStyle= FontStyle.Italic,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 24.dp)
                    .padding(horizontal = 2.dp)

            )
        }
    }
}

@Composable
fun Button(onClick: () -> Unit){
    androidx.compose.material3.Button(
        onClick = onClick,
        modifier = Modifier
            .padding(top=16.dp,start=16.dp)
            .background(color = Color.Blue, shape = RoundedCornerShape(percent = 50)),
    ) {
        Text(text = "Mapa", color = Color.White, fontSize = 16.sp)
    }
}


@Composable
fun FilaInteres(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement= Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(horizontal=20.dp),
        modifier=modifier
    ){
        items (DestinosTuristicos){
                item->Tarjetas(
            drawable= item.drawable,
            title= item.text
        )
        }

    }
}

@Composable
fun FilaHoteles(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement= Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(horizontal=20.dp),
        modifier=modifier
    ){
        items (HotelesRecomendados){
                item->
            Tarjetas(
                drawable= item.drawable,
                title= item.text
            )
        }

    }
}

@Composable
fun FirstSession(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column() {
        Text(text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp))
        content()
    }
}

@Composable
fun Union( modifier: Modifier = Modifier){
    Surface(){
        Column (modifier= Modifier
            .verticalScroll(rememberScrollState())) {
            Button(onClick = {})
            FirstSession(R.string.te_puede_interesar) {
                FilaInteres()
            }
            FirstSession(R.string.hoteles_recomendados) {
                FilaHoteles()
            }
        }
    }
}