package edu.unicauca.appeasytour.View.LoginScreen


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import edu.unicauca.appeasytour.ui.theme.focusedTextFieldText
import edu.unicauca.appeasytour.ui.theme.textFieldContainer
import edu.unicauca.appeasytour.ui.theme.unfocusedTextFieldText

@Composable
fun LoginTextField(
    modifier: Modifier =Modifier,
    label:String,
) {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    TextField( modifier= modifier,
        value = "",
        onValueChange = {},
        label={
            Text(text=label, style= MaterialTheme.typography.labelMedium,color= uiColor, onTextLayout = {} )
        },
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
            focusedPlaceholderColor= MaterialTheme.colorScheme.focusedTextFieldText,
            unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
            focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer
        )
    )

}