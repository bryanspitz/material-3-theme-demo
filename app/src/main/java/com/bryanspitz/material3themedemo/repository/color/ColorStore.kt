package com.bryanspitz.material3themedemo.repository.color

import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.content.edit
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class ColorStore @Inject constructor(
    private val prefs: SharedPreferences
) {

    fun observeLightColors(): Flow<ColorScheme> {
        return callbackFlow {
            val listener = OnSharedPreferenceChangeListener { _, key ->
                if (key.endsWith("Light"))
                    trySendBlocking(lightColors())
            }
            prefs.registerOnSharedPreferenceChangeListener(listener)
            send(lightColors())
            awaitClose { prefs.unregisterOnSharedPreferenceChangeListener(listener) }
        }
    }

    fun observeDarkColors(): Flow<ColorScheme> {
        return callbackFlow {
            val listener = OnSharedPreferenceChangeListener { _, key ->
                if (key.endsWith("Dark"))
                    trySendBlocking(darkColors())
            }
            prefs.registerOnSharedPreferenceChangeListener(listener)
            send(darkColors())
            awaitClose { prefs.unregisterOnSharedPreferenceChangeListener(listener) }
        }
    }

    fun updateLightColors(scheme: ColorScheme) {
        prefs.edit {
            putInt("primaryLight", scheme.primary.toArgb())
            putInt("onPrimaryLight", scheme.onPrimary.toArgb())
            putInt("primaryContainerLight", scheme.primaryContainer.toArgb())
            putInt("onPrimaryContainerLight", scheme.onPrimaryContainer.toArgb())
            putInt("inversePrimaryLight", scheme.inversePrimary.toArgb())
            putInt("secondaryLight", scheme.secondary.toArgb())
            putInt("onSecondaryLight", scheme.onSecondary.toArgb())
            putInt("secondaryContainerLight", scheme.secondaryContainer.toArgb())
            putInt("onSecondaryContainerLight", scheme.onSecondaryContainer.toArgb())
            putInt("tertiaryLight", scheme.tertiary.toArgb())
            putInt("onTertiaryLight", scheme.onTertiary.toArgb())
            putInt("tertiaryContainerLight", scheme.tertiaryContainer.toArgb())
            putInt("onTertiaryContainerLight", scheme.onTertiaryContainer.toArgb())
            putInt("backgroundLight", scheme.background.toArgb())
            putInt("onBackgroundLight", scheme.onBackground.toArgb())
            putInt("surfaceLight", scheme.surface.toArgb())
            putInt("onSurfaceLight", scheme.onSurface.toArgb())
            putInt("surfaceTintLight", scheme.surfaceTint.toArgb())
            putInt("surfaceVariantLight", scheme.surfaceVariant.toArgb())
            putInt("onSurfaceVariantLight", scheme.onSurfaceVariant.toArgb())
            putInt("inverseSurfaceLight", scheme.inverseSurface.toArgb())
            putInt("inverseOnSurfaceLight", scheme.inverseOnSurface.toArgb())
            putInt("errorLight", scheme.error.toArgb())
            putInt("onErrorLight", scheme.onError.toArgb())
            putInt("errorContainerLight", scheme.errorContainer.toArgb())
            putInt("onErrorContainerLight", scheme.onErrorContainer.toArgb())
            putInt("outlineLight", scheme.outline.toArgb())
        }
    }

    fun updateDarkColors(scheme: ColorScheme) {
        prefs.edit {
            putInt("primaryDark", scheme.primary.toArgb())
            putInt("onPrimaryDark", scheme.onPrimary.toArgb())
            putInt("primaryContainerDark", scheme.primaryContainer.toArgb())
            putInt("onPrimaryContainerDark", scheme.onPrimaryContainer.toArgb())
            putInt("inversePrimaryDark", scheme.inversePrimary.toArgb())
            putInt("secondaryDark", scheme.secondary.toArgb())
            putInt("onSecondaryDark", scheme.onSecondary.toArgb())
            putInt("secondaryContainerDark", scheme.secondaryContainer.toArgb())
            putInt("onSecondaryContainerDark", scheme.onSecondaryContainer.toArgb())
            putInt("tertiaryDark", scheme.tertiary.toArgb())
            putInt("onTertiaryDark", scheme.onTertiary.toArgb())
            putInt("tertiaryContainerDark", scheme.tertiaryContainer.toArgb())
            putInt("onTertiaryContainerDark", scheme.onTertiaryContainer.toArgb())
            putInt("backgroundDark", scheme.background.toArgb())
            putInt("onBackgroundDark", scheme.onBackground.toArgb())
            putInt("surfaceDark", scheme.surface.toArgb())
            putInt("onSurfaceDark", scheme.onSurface.toArgb())
            putInt("surfaceTintDark", scheme.surfaceTint.toArgb())
            putInt("surfaceVariantDark", scheme.surfaceVariant.toArgb())
            putInt("onSurfaceVariantDark", scheme.onSurfaceVariant.toArgb())
            putInt("inverseSurfaceDark", scheme.inverseSurface.toArgb())
            putInt("inverseOnSurfaceDark", scheme.inverseOnSurface.toArgb())
            putInt("errorDark", scheme.error.toArgb())
            putInt("onErrorDark", scheme.onError.toArgb())
            putInt("errorContainerDark", scheme.errorContainer.toArgb())
            putInt("onErrorContainerDark", scheme.onErrorContainer.toArgb())
            putInt("outlineDark", scheme.outline.toArgb())
        }
    }

    private fun lightColors(): ColorScheme {
        val defaultLight = lightColorScheme()

        return lightColorScheme(
            primary = getColor("primaryLight", defaultLight.primary),
            onPrimary = getColor("onPrimaryLight", defaultLight.onPrimary),
            primaryContainer = getColor("primaryContainerLight", defaultLight.primaryContainer),
            onPrimaryContainer = getColor(
                "onPrimaryContainerLight",
                defaultLight.onPrimaryContainer
            ),
            inversePrimary = getColor("inversePrimaryLight", defaultLight.inversePrimary),
            secondary = getColor("secondaryLight", defaultLight.secondary),
            onSecondary = getColor("onSecondaryLight", defaultLight.onSecondary),
            secondaryContainer = getColor(
                "secondaryContainerLight",
                defaultLight.secondaryContainer
            ),
            onSecondaryContainer = getColor(
                "onSecondaryContainerLight",
                defaultLight.onSecondaryContainer
            ),
            tertiary = getColor("tertiaryLight", defaultLight.tertiary),
            onTertiary = getColor("onTertiaryLight", defaultLight.onTertiary),
            tertiaryContainer = getColor("tertiaryContainerLight", defaultLight.tertiaryContainer),
            onTertiaryContainer = getColor(
                "onTertiaryContainerLight",
                defaultLight.onTertiaryContainer
            ),
            background = getColor("backgroundLight", defaultLight.background),
            onBackground = getColor("onBackgroundLight", defaultLight.onBackground),
            surface = getColor("surfaceLight", defaultLight.surface),
            onSurface = getColor("onSurfaceLight", defaultLight.onSurface),
            surfaceTint = getColor("surfaceTintLight", defaultLight.surfaceTint),
            surfaceVariant = getColor("surfaceVariantLight", defaultLight.surfaceVariant),
            onSurfaceVariant = getColor("onSurfaceVariantLight", defaultLight.onSurfaceVariant),
            inverseSurface = getColor("inverseSurfaceLight", defaultLight.inverseSurface),
            inverseOnSurface = getColor("inverseOnSurfaceLight", defaultLight.inverseOnSurface),
            error = getColor("errorLight", defaultLight.error),
            onError = getColor("onErrorLight", defaultLight.onError),
            errorContainer = getColor("errorContainerLight", defaultLight.errorContainer),
            onErrorContainer = getColor("onErrorContainerLight", defaultLight.onErrorContainer),
            outline = getColor("outlineLight", defaultLight.outline),
        )
    }

    private fun darkColors(): ColorScheme {
        val defaultDark = darkColorScheme()

        return darkColorScheme(
            primary = getColor("primaryDark", defaultDark.primary),
            onPrimary = getColor("onPrimaryDark", defaultDark.onPrimary),
            primaryContainer = getColor("primaryContainerDark", defaultDark.primaryContainer),
            onPrimaryContainer = getColor("onPrimaryContainerDark", defaultDark.onPrimaryContainer),
            inversePrimary = getColor("inversePrimaryDark", defaultDark.inversePrimary),
            secondary = getColor("secondaryDark", defaultDark.secondary),
            onSecondary = getColor("onSecondaryDark", defaultDark.onSecondary),
            secondaryContainer = getColor("secondaryContainerDark", defaultDark.secondaryContainer),
            onSecondaryContainer = getColor(
                "onSecondaryContainerDark",
                defaultDark.onSecondaryContainer
            ),
            tertiary = getColor("tertiaryDark", defaultDark.tertiary),
            onTertiary = getColor("onTertiaryDark", defaultDark.onTertiary),
            tertiaryContainer = getColor("tertiaryContainerDark", defaultDark.tertiaryContainer),
            onTertiaryContainer = getColor(
                "onTertiaryContainerDark",
                defaultDark.onTertiaryContainer
            ),
            background = getColor("backgroundDark", defaultDark.background),
            onBackground = getColor("onBackgroundDark", defaultDark.onBackground),
            surface = getColor("surfaceDark", defaultDark.surface),
            onSurface = getColor("onSurfaceDark", defaultDark.onSurface),
            surfaceTint = getColor("surfaceTintDark", defaultDark.surfaceTint),
            surfaceVariant = getColor("surfaceVariantDark", defaultDark.surfaceVariant),
            onSurfaceVariant = getColor("onSurfaceVariantDark", defaultDark.onSurfaceVariant),
            inverseSurface = getColor("inverseSurfaceDark", defaultDark.inverseSurface),
            inverseOnSurface = getColor("inverseOnSurfaceDark", defaultDark.inverseOnSurface),
            error = getColor("errorDark", defaultDark.error),
            onError = getColor("onErrorDark", defaultDark.onError),
            errorContainer = getColor("errorContainerDark", defaultDark.errorContainer),
            onErrorContainer = getColor("onErrorContainerDark", defaultDark.onErrorContainer),
            outline = getColor("outlineDark", defaultDark.outline),
        )
    }

    private fun getColor(key: String, default: Color): Color {
        return if (prefs.contains(key)) {
            Color(prefs.getInt(key, 0))
        } else {
            default
        }
    }
}

interface ColorStoreSource {
    fun colorStore(): ColorStore
}