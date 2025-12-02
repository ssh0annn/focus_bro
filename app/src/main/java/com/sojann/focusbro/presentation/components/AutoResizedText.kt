package com.sojann.focusbro.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.sojann.focusbro.ui.theme.FocusBroTheme

@Composable
fun AutoResizedText(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.displayLarge,
){
    var timeTextStyle by remember { mutableStateOf(textStyle) }
    val FontSizeFactor = 0.95
    Text(
        text,
        modifier = modifier.fillMaxWidth(),
        softWrap = false, // para cuaando la pantall a sea muy pequena el calor se quede en la misma linea
         style =  timeTextStyle,
        onTextLayout ={result ->
            if (result.didOverflowWidth){
                timeTextStyle = timeTextStyle.copy(
                    fontSize = timeTextStyle.fontSize * FontSizeFactor
                )
            }
        }  // un call back que recibe una funcion, que se ejecuta cuando se calcula el tamano de ese texto
    )
}



@Preview(
    name = "AutoResizedTextPreview",
    showBackground = true,
)
// 2- Composable for the preview
@Composable
fun AutoResizedTextPreview() {
//    3-Theme
    FocusBroTheme {
//        4-Composable to preview
        AutoResizedText(
            text = "Focus Bro"
        )
    }
}

