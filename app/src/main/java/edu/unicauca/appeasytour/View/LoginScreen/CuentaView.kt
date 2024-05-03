package edu.unicauca.appeasytour.View.LoginScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import edu.unicauca.appeasytour.R


@Composable
fun cuentaView(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
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
                Text("Inicia sesión para gestionar tus reservas y planificar fácilmente tu próximo viaje")
                Button(
                    onClick = { navHostController.navigate(Screens.LoginScreen.route) },
                    modifier = Modifier
                        .width(200.dp)
                        .height(56.dp)
                        .padding(5.dp)
                ) {
                    Text("Iniciar Sesión")
                }
            }
        }

        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape= RectangleShape

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(R.drawable.settings),
                    contentDescription = null
                )
                Text("Preferencias")
            }
        }
        Button(
            onClick = { /* Handle preferences here */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape= RectangleShape

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(R.drawable.circle_help),
                    contentDescription = null
                )
                Text("Acerca de")
            }
        }
    }
}

