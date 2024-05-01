package com.example.aplicacionesmoviles

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import edu.unicauca.appeasytour.ui.theme.focusedTextFieldText
import edu.unicauca.appeasytour.ui.theme.textFieldContainer
import edu.unicauca.appeasytour.ui.theme.unfocusedTextFieldText

@Composable
fun UsuarioInput(
    usuarioState: MutableState<String>,
    labelId: String
) {
    InputField(
        modifier = Modifier,
        valueState= usuarioState,
        labelId=labelId,
        KeyboardType= KeyboardType.Email
    )
}

@Composable
fun InputField(modifier: Modifier = Modifier,
               valueState: MutableState<String>,
               labelId: String,
               isSingleLine:Boolean= true,
               KeyboardType: KeyboardType
) {
    val email= rememberSaveable {
        mutableStateOf("")
    }
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    TextField( modifier = Modifier.fillMaxWidth(),
        value = valueState.value,
        onValueChange = {valueState.value=it},
        singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType
        ),
        label={
            Text(text=labelId, style= MaterialTheme.typography.labelMedium,color= uiColor )
        },
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
            focusedPlaceholderColor= MaterialTheme.colorScheme.focusedTextFieldText,
            unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
            focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer
        )
    )
}