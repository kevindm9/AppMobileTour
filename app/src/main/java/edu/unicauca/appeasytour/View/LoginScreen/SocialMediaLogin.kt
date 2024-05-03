package com.example.aplicacionesmoviles

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import edu.unicauca.appeasytour.View.LoginScreen.LoginScreenViewModel
import edu.unicauca.appeasytour.ui.theme.BlueGray
import edu.unicauca.appeasytour.ui.theme.LightBlueWhite


@Composable
fun SocialMediaLogin(
    viewModel: LoginScreenViewModel = viewModel(),
    modifier: Modifier =Modifier,
    @DrawableRes icon:Int,
    text:String,
    onclick:()->Unit
) {
    val launcher= rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
        val task= GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val account= task.getResult(ApiException::class.java)
            val credential= GoogleAuthProvider.getCredential(account.idToken, null)
            viewModel.signInWithGoogleCredential(credential){
                Log.d("FB","Ingreso con google")
            }
        }catch (ex:Exception){
            Log.d("FB","Error")
        }


    }
    val token="161501915446-cbot3ashbnbj17ig1j4rkr9m991h1psi.apps.googleusercontent.com"
    val context= LocalContext.current
    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(4.dp))
            .socialMedia()
            .clickable { onclick() }
            .height(40.dp)
            .clickable { val opciones= GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN
            )
                .requestIdToken(token)
                .requestEmail()
                .build()
                       val googleSignInClient = GoogleSignIn.getClient(context,opciones)
                launcher.launch(googleSignInClient.signInIntent)
                       },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter= painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = text,
            style=MaterialTheme.typography.labelMedium.copy(color=Color(0xFF64748B)))
    }
}

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.socialMedia() : Modifier = composed {
    if (isSystemInDarkTheme()){
        background(Color.Transparent).border(
            width= 1.dp,
            color= BlueGray,
            shape= RoundedCornerShape(4.dp)
        )
    }else{
            background(LightBlueWhite)
    }}