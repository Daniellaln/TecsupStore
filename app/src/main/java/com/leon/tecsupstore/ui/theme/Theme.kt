package com.leon.tecsupstore.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val EsquemaClaro = lightColorScheme(
    primary = MoradoTecsup,
    onPrimary = Color.White,
    secondary = MoradoTecsup,
    background = Color.White,
    surface = Color.White,
    surfaceVariant = LilaClaro,
    onBackground = TextoOscuro,
    onSurface = TextoOscuro,
    onSurfaceVariant = TextoGris,
    outline = BordeSuave
)

@Composable
fun TecsupStoreTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = EsquemaClaro,
        typography = Typography,
        content = content
    )
}
