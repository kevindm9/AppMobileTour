package edu.unicauca.appeasytour.View.LoginScreen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class LoginScreenViewModel: ViewModel() {
    private val auth: FirebaseAuth= Firebase.auth
    private val _loading= MutableLiveData(false)
    fun signInWithEmailandPassword(email:String, password:String, home:()-> Unit)
            = viewModelScope.launch{
        try{
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {authResult->
                    Log.d("FB", "" +
                            "singInWithEmailAndPassword Logueado!!!: ${authResult.toString()}")
                    home()
                }
                .addOnFailureListener{ex->
                    // código cuando falla
                    // Tienes acceso a la excepción
                    Log.d("FB", "" +
                            "singInWithEmailAndPassword Falló!!!: ${ex.localizedMessage}")
                    //errorLogueo()
                }
        }
        catch(ex:Exception) {
            Log.d("FB", "" + "singInWithEmailAndPassword: ${ex.message}")
        }
    }
}
