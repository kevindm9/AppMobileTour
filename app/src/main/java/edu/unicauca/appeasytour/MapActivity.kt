package edu.unicauca.appeasytour

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState

class MapActivity {

    @Composable
    fun MyGoogleMaps(){
        val marker=LatLng(2.1213132,5.32424)
        GoogleMap(modifier = Modifier.fillMaxSize(), properties = MapProperties(mapType = MapType.HYBRID)){
            Marker(rememberMarkerState(position = marker), title = "prueba marker",
                snippet = "este es un marcador de prueba ")
        }

    }


    }