package com.sojann.focusbro.ui.theme

import android.app.Activity
import android.os.Build
import androidx.annotation.Size
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = primaryWhite,
    secondary =gray,
    tertiary = ligthGray,
    surface = primaryBlack,
    background = primaryBlack
)

private val LightColorScheme = lightColorScheme(
    primary = primaryBlack,
    secondary =gray,
    tertiary = ligthGray,
    surface = primaryWhite,
    background = primaryWhite
)
val LocalDimens = staticCompositionLocalOf { defaultDimens  }

@Composable
fun provideDimens(
    dimens : Dimens,
    content: @Composable () -> Unit
){
    val dimensionSet = remember { dimens }
    CompositionLocalProvider(LocalDimens provides dimensionSet,content = content)
}

@Composable
fun FocusBroTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    windowsSize: WindowWidthSizeClass = WindowWidthSizeClass.Compact, //
        /*
        * El Compact: Es el Size que utilizan las mayorias de los telefonos
        *las tablest;: son medieum
        * los expanded: To do lo pase de 839
        *esto es lo que utlizamos para decirle a unesra dimencion en base al dispositivo que se esta corriendo en ese momento
        * */
    content: @Composable () -> Unit,

) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val dimension =
        if (windowsSize > WindowWidthSizeClass.Compact)
        tabletDimens
    else
            defaultDimens

    provideDimens(dimension){
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }


}

object FocusBroTheme{
    val dimens: Dimens
        @Composable
        @ReadOnlyComposable
        get() = LocalDimens.current
}
