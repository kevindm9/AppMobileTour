package edu.unicauca.appeasytour.View.LoginScreen

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class LoginScreenViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    /*    fun LoginWithGoogle(activity:Activity){
           val gso= GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
               .requestEmail()
               .build()

           val client= GoogleSignIn.getClient(activity,gso)
           val signInIntend: Intent = client.signInIntent
           activity.startActivityForResult(signInIntend,1)
       }*/
    fun signInWithGoogleCredential(credential: AuthCredential, home: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithCredential(credential)
                    .addOnSuccessListener { authResult ->
                        Log.d("FB", "Logueado con Google")
                    }
                    .addOnFailureListener { ex ->
                        // código cuando falla
                        // Tienes acceso a la excepción
                        Log.d("FB", "Fallo al loguear con google")
                        //errorLogueo()
                    }
            } catch (ex: Exception) {
                Log.d("FB", "" + "excepcion al loguear con google ${ex.localizedMessage}")
            }
        }

    fun signInWithEmailandPassword(email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener { authResult ->
                        Log.d(
                            "FB", "" +
                                    "singInWithEmailAndPassword Logueado!!!: ${authResult}"
                        )
                    }
                    .addOnFailureListener { ex ->
                        // código cuando falla
                        // Tienes acceso a la excepción
                        Log.d(
                            "FB", "" +
                                    "singInWithEmailAndPassword Falló!!!: ${ex.localizedMessage}"
                        )
                        //errorLogueo()
                    }
            } catch (ex: Exception) {
                Log.d("FB", "" + "singInWithEmailAndPassword: ${ex.message}")
            }
        }

    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        home: () -> Unit
    ) {
        if (_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        home()
                    } else {
                        Log.d("TAG", "createUserWithEmailAndPassword: ${task.exception}")
                    }
                    _loading.value = false
                }
        }
    }
}
