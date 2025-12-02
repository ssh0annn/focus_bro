package com.sojann.focusbro.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sojann.focusbro.ui.theme.FocusBroTheme

@Composable
fun CustomButtom(
    modifer: Modifier = Modifier,
    text: String,
    textColor: Color,
    btnColor: Color,
    onTap: () -> Unit ={}
){

    Button(
        { onTap},
        modifer
            .height(FocusBroTheme.dimens.buttonHeightNormal),
        shape = RoundedCornerShape(FocusBroTheme.dimens.roundedShapeNormal),
        colors = ButtonDefaults.buttonColors(
            containerColor = btnColor
        ),
    ) {

        Text(text, Modifier
            .fillMaxWidth()
            .align(Alignment.CenterVertically),
            style = MaterialTheme.typography.bodyLarge,
            color = textColor)

    }

}