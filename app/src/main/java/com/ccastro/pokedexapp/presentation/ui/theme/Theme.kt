package com.ccastro.pokedexapp.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFE3350D), // Rojo (En referencia a la Pokébola)
    onPrimary = Color(0xFFFDFDF6), // Blanco (Texto sobre el color primario)
    primaryContainer = Color(0xFFE3350D), // Rojo (TopBar Color)
    onPrimaryContainer = Color(0xFF459A20), // Verde Oscuro (Texto en TopBar)
    inversePrimary = Color(0xFF5A63FD), // Azul (Color inverso, pendiente variar)

    secondary = Color(0xFF459A20), // Verde Oscuro (En referencia a la naturaleza y la hierba)
    onSecondary = Color(0xFFCFF2C0), // Verde Claro (Texto sobre el color secundario)
    secondaryContainer = Color(0xFF459A20), // Verde Oscuro (Botones llenos)
    onSecondaryContainer = Color(0xFFFAFEF3), // Blanco (Texto en botones llenos)

    tertiary = Color(0xFFFE7F09), // Naranja (En referencia a fuego y electricidad)
    onTertiary = Color(0xFFFEEEDE), // Naranja Claro (Texto sobre el color terciario)
    tertiaryContainer = Color(0xFFFE7F09), // Naranja (Contenedores de elementos terciarios)
    onTertiaryContainer = Color(0xFFFEAE63), // Naranja Oscuro (Texto en contenedores terciarios)

    background = Gray700,
    onBackground = White200,
    surface = Gray500,
    onSurface = White200,
    surfaceVariant = Gray80,
    onSurfaceVariant = White200,
    surfaceTint = Green500,

    error = Red500,
    errorContainer = Red700,

    outline = Blue200,
    outlineVariant = Blue200,

    scrim = Gray700
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFE3350D), // Rojo (En referencia a la Pokébola)
    onPrimary = Color(0xFFFDFDF6), // Blanco (Texto sobre el color primario)
    primaryContainer = Color(0xFFE3350D), // Rojo (TopBar Color)
    onPrimaryContainer = Color(0xFF459A20), // Verde Oscuro (Texto en TopBar)
    inversePrimary = Color(0xFF5A63FD), // Azul (Color inverso, pendiente variar)

    secondary = Color(0xFF459A20), // Verde Oscuro (En referencia a la naturaleza y la hierba)
    onSecondary = Color(0xFFCFF2C0), // Verde Claro (Texto sobre el color secundario)
    secondaryContainer = Color(0xFF459A20), // Verde Oscuro (Botones llenos)
    onSecondaryContainer = Color(0xFFFAFEF3), // Blanco (Texto en botones llenos)

    tertiary = Color(0xFFFE7F09), // Naranja (En referencia a fuego y electricidad)
    onTertiary = Color(0xFFFEEEDE), // Naranja Claro (Texto sobre el color terciario)
    tertiaryContainer = Color(0xFFFE7F09), // Naranja (Contenedores de elementos terciarios)
    onTertiaryContainer = Color(0xFFFEAE63), // Naranja Oscuro (Texto en contenedores terciarios)

    background = Color.White,
    onBackground = Gray500,

    surface = GreenVariant40,         // elevatedButtons, Superficies, Cards,
    onSurface = Gray700,        // Color de Letra
    surfaceVariant = White200,
    onSurfaceVariant = BlueVariant700,
    surfaceTint = Blue80,

    error = Red500,
    errorContainer = Red700,

    outline = Gray80,
    outlineVariant = Blue200,

    scrim = Gray700,
)

@Composable
fun PokedexAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}