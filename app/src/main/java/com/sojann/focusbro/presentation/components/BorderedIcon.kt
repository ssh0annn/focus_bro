package com.sojann.focusbro.presentation.components

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import com.sojann.focusbro.ui.theme.FocusBroTheme

@Composable
fun BorderedIcon(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    onTap: () -> Unit = {}
){
   Icon(
       modifier = modifier
           .size(FocusBroTheme.dimens.iconSizeNormal)
           .border(
               width = FocusBroTheme.dimens.borderNormal,
               color = MaterialTheme.colorScheme.primary,
               shape = CircleShape
           )
           .padding(FocusBroTheme.dimens.paddingSmall)
           .clickable{onTap},
       imageVector = ImageVector.vectorResource(id = icon),
       contentDescription = null,
       tint = MaterialTheme.colorScheme.primary
   )
}

