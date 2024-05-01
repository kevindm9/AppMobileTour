package edu.unicauca.appeasytour.View.LoginScreen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import edu.unicauca.appeasytour.ui.theme.focusedTextFieldText
import edu.unicauca.appeasytour.ui.theme.textFieldContainer
import edu.unicauca.appeasytour.ui.theme.unfocusedTextFieldText

@Composable
fun PasswordInput(modifier: Modifier = Modifier,
                  passwordState: MutableState<String>,
                  labelId: String,
                  passwordVisible: MutableState<Boolean>
) {
    val visualTransformation =if(passwordVisible.value)
        VisualTransformation.None
    else PasswordVisualTransformation()

    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    TextField( modifier = Modifier.fillMaxWidth(),
        value = passwordState.value,
        onValueChange = {passwordState.value=it},
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        label={
            Text(text=labelId, style= MaterialTheme.typography.labelMedium,color= uiColor )
        },
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
            focusedPlaceholderColor= MaterialTheme.colorScheme.focusedTextFieldText,
            unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
            focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer
        ) ,
        visualTransformation =visualTransformation
    )
}



