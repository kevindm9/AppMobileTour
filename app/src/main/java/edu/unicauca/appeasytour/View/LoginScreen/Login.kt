/*package edu.unicauca.appeasytour.View.LoginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.navigation.NavHostController
import com.example.aplicacionesmoviles.UsuarioInput
import edu.unicauca.appeasytour.R
import edu.unicauca.appeasytour.ui.theme.Black
import edu.unicauca.appeasytour.ui.theme.BlueGray
import edu.unicauca.appeasytour.ui.theme.Roboto
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginScreenViewModel = viewModel(),
    onDone: (String, String) -> Unit = { usuario, pwd -> }
) {
    val usuario = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val passwordVisible = rememberSaveable { mutableStateOf(false) }
    val valido = remember(usuario.value, password.value) {
        usuario.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }
    val keyBoardController = LocalSoftwareKeyboardController.current

    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            TopSection()
            Spacer(modifier = Modifier.height(36.dp))

            Column(modifier = Modifier.fillMaxSize().padding(horizontal = 30.dp)) {
                UsuarioInput(
                    usuarioState = usuario,
                    labelId = "Usuario",
                )
                Spacer(modifier = Modifier.height(15.dp))
                PasswordInput(
                    passwordState = password,
                    labelId = "Password",
                    passwordVisible = passwordVisible
                )
                Spacer(modifier = Modifier.height(15.dp))
                ButtonConfiguration(
                    TextId = "Ingresar",
                    inputValido = valido,
                    navController = navController,
                    viewModel = viewModel,
                    email = usuario.value,
                    password = password.value
                ) {
                    onDone(usuario.value.trim(), password.value.trim())
                }
                val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black
                Box(
                    modifier = Modifier.fillMaxHeight(fraction = 0.7F).fillMaxWidth(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xFF94A3B8),
                                    fontSize = 14.sp,
                                    fontFamily = Roboto,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append("Olvidaste tu contraseña?")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = uiColor,
                                    fontSize = 14.sp,
                                    fontFamily = Roboto,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append(" ")
                                append("Recuperala")
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ButtonConfiguration(
    viewModel: LoginScreenViewModel,
    navController: NavHostController,
    TextId: String,
    inputValido: Boolean,
    email: String,
    password: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth().height(40.dp),
        onClick = {
            viewModel.signInWithEmailandPassword(email, password) {
                navController.navigate(route = AppScreens.HotelView.route)
            }
            onClick()
        },
        enabled = inputValido,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = TextId,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
            onTextLayout = {}
        )
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.46f),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.padding(top = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(id = R.string.coltour),
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 35.sp),
                color = uiColor,
                onTextLayout ={}
            )
            Spacer(modifier = Modifier.height(5.dp))
            /*  Text(
                  text = stringResource(id = R.string.validacion),
                  style = MaterialTheme.typography.titleMedium,
                  color = uiColor,
                  onTextLayout ={}
              )*/


        }
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.BottomCenter),
            text = stringResource(id = R.string.inicio_sesion),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor,
            onTextLayout ={}
        )

    }
}
@Preview
@Composable
fun PreviewLoginScreen(){
    MaterialTheme{
        LoginScreen(rememberNavController())
    }
}*/