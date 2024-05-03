package edu.unicauca.appeasytour.View
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource


@Composable
fun about(){
    val context = LocalContext.current
    val versionName = context.packageManager.getPackageInfo(context.packageName, 0).versionName
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(edu.unicauca.appeasytour.R.drawable.logo), contentDescription = "Descripción de la imagen")
            Text(text ="ColTour una plataforma que tiene como objetivo promover el turismo, y guiar a las personas que " +
                    "visitan la ciudad haciendo uso de una interfaz llamativa, fácil de comprender.")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text ="Version App: $versionName")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text ="Desarrolladores:\n" +
                    "Julia Sofia Garcia Gaviria\n" +
                    "Jose Julian Avirama Valencia\n"+
                    "Steben David Higidio\n"+
                    "Kevin Daryany Morales Cruz"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text ="Tutor:\n " +
                    "Dr. Cristhian N Figueroa M"
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(text =" © all right reserved"
            )
        }
    }
}

@Preview
@Composable
fun PrevAbout(){
    about()
}