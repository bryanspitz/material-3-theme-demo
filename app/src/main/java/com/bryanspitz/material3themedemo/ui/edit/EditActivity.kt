package com.bryanspitz.material3themedemo.ui.edit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.bryanspitz.material3themedemo.application.appDependency
import com.bryanspitz.material3themedemo.repository.color.ColorStoreSource
import com.bryanspitz.material3themedemo.repository.mode.ModeStoreSource
import com.bryanspitz.material3themedemo.ui.theme.Material3ThemeDemoTheme

class EditActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colorStore = remember { appDependency<ColorStoreSource>().colorStore() }
            val modeStore = remember { appDependency<ModeStoreSource>().modeStore() }
            val isDarkTheme by modeStore.darkMode.collectAsState(initial = false)
            val darkTheme by remember { colorStore.observeDarkColors() }
                .collectAsState(initial = darkColorScheme())
            val lightTheme by remember { colorStore.observeLightColors() }
                .collectAsState(initial = lightColorScheme())

            val colorScheme = if (isDarkTheme) darkTheme else lightTheme

            Material3ThemeDemoTheme(
                darkTheme = isDarkTheme,
                colorScheme = colorScheme
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Edit Colors") },
                            navigationIcon = {
                                IconButton(onClick = { finish() }) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = "back"
                                    )
                                }
                            },
                            actions = {
                                IconButton(onClick = { modeStore.setDarkMode(!isDarkTheme) }) {
                                    Icon(
                                        imageVector = if (isDarkTheme) Icons.Default.LightMode
                                        else Icons.Default.DarkMode,
                                        contentDescription = "change theme"
                                    )
                                }
                                IconButton(onClick = {
                                    if (isDarkTheme) {
                                        colorStore.updateDarkColors(darkColorScheme())
                                    } else {
                                        colorStore.updateLightColors(lightColorScheme())
                                    }
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Refresh,
                                        contentDescription = "reset theme"
                                    )
                                }
                            }
                        )
                    }
                ) {
                    Column(
                        verticalArrangement = spacedBy(16.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                            .padding(horizontal = 16.dp)
                            .verticalScroll(
                                state = rememberScrollState()
                            )
                    ) {
                        DualColorCell(
                            backgroundName = "primary",
                            foregroundName = "onPrimary",
                            background = colorScheme.primary,
                            foreground = colorScheme.onPrimary,
                            onBackgroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(primary = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(primary = it))
                                }
                            },
                            onForegroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(onPrimary = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(onPrimary = it))
                                }
                            }
                        )
                        DualColorCell(
                            backgroundName = "primaryContainer",
                            foregroundName = "onPrimaryContainer",
                            background = colorScheme.primaryContainer,
                            foreground = colorScheme.onPrimaryContainer,
                            onBackgroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(primaryContainer = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(primaryContainer = it))
                                }
                            },
                            onForegroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(onPrimaryContainer = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(onPrimaryContainer = it))
                                }
                            }
                        )
                        DualColorCell(
                            backgroundName = "secondary",
                            foregroundName = "onSecondary",
                            background = colorScheme.secondary,
                            foreground = colorScheme.onSecondary,
                            onBackgroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(secondary = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(secondary = it))
                                }
                            },
                            onForegroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(onSecondary = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(onSecondary = it))
                                }
                            }
                        )
                        DualColorCell(
                            backgroundName = "secondaryContainer",
                            foregroundName = "onSecondaryContainer",
                            background = colorScheme.secondaryContainer,
                            foreground = colorScheme.onSecondaryContainer,
                            onBackgroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(secondaryContainer = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(secondaryContainer = it))
                                }
                            },
                            onForegroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(
                                        colorScheme.copy(
                                            onSecondaryContainer = it
                                        )
                                    )
                                } else {
                                    colorStore.updateLightColors(
                                        colorScheme.copy(
                                            onSecondaryContainer = it
                                        )
                                    )
                                }
                            }
                        )
                        DualColorCell(
                            backgroundName = "tertiary",
                            foregroundName = "onTertiary",
                            background = colorScheme.tertiary,
                            foreground = colorScheme.onTertiary,
                            onBackgroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(tertiary = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(tertiary = it))
                                }
                            },
                            onForegroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(onTertiary = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(onTertiary = it))
                                }
                            }
                        )
                        DualColorCell(
                            backgroundName = "tertiaryContainer",
                            foregroundName = "onTertiaryContainer",
                            background = colorScheme.tertiaryContainer,
                            foreground = colorScheme.onTertiaryContainer,
                            onBackgroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(tertiaryContainer = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(tertiaryContainer = it))
                                }
                            },
                            onForegroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(onTertiaryContainer = it))
                                } else {
                                    colorStore.updateLightColors(
                                        colorScheme.copy(
                                            onTertiaryContainer = it
                                        )
                                    )
                                }
                            }
                        )
                        DualColorCell(
                            backgroundName = "background",
                            foregroundName = "onBackground",
                            background = colorScheme.background,
                            foreground = colorScheme.onBackground,
                            onBackgroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(background = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(background = it))
                                }
                            },
                            onForegroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(onBackground = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(onBackground = it))
                                }
                            }
                        )
                        DualColorCell(
                            backgroundName = "surface",
                            foregroundName = "onSurface",
                            background = colorScheme.surface,
                            foreground = colorScheme.onSurface,
                            onBackgroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(surface = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(surface = it))
                                }
                            },
                            onForegroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(onSurface = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(onSurface = it))
                                }
                            }
                        )

                        var surfaceTintText by remember(colorScheme.surfaceTint) {
                            mutableStateOf(colorScheme.surfaceTint.toArgb().toUInt().toString(16))
                        }

                        Row {
                                TextField(
                                    value = surfaceTintText,
                                    onValueChange = {
                                        surfaceTintText = it
                                        try {
                                            val color = Color(it.toUInt(16).toInt())
                                            if (isDarkTheme) {
                                                colorStore.updateDarkColors(
                                                    colorScheme.copy(surfaceTint = color)
                                                )
                                            } else {
                                                colorStore.updateLightColors(
                                                    colorScheme.copy(surfaceTint = color)
                                                )
                                            }
                                        } catch (e: Exception) {
                                        }
                                    },
                                    label = { Text("surfaceTint") },
                                    modifier = Modifier.weight(1f)
                                )

                            Column {
                                Surface(
                                    modifier = Modifier.width(180.dp),
                                    color = colorScheme.surface,
                                    contentColor = colorScheme.onSurface,
                                    tonalElevation = 1.dp
                                ) {
                                    Text(text = "surface elevation 1")
                                }
                                Surface(
                                    modifier = Modifier.width(180.dp),
                                    color = colorScheme.surface,
                                    contentColor = colorScheme.onSurface,
                                    tonalElevation = 3.dp
                                ) {
                                    Text(text = "surface elevation 3")
                                }
                                Surface(
                                    modifier = Modifier.width(180.dp),
                                    color = colorScheme.surface,
                                    contentColor = colorScheme.onSurface,
                                    tonalElevation = 9.dp
                                ) {
                                    Text(text = "surface elevation 9")
                                }
                            }
                        }

                        DualColorCell(
                            backgroundName = "surfaceVariant",
                            foregroundName = "onSurfaceVariant",
                            background = colorScheme.surfaceVariant,
                            foreground = colorScheme.onSurfaceVariant,
                            onBackgroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(surfaceVariant = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(surfaceVariant = it))
                                }
                            },
                            onForegroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(onSurfaceVariant = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(onSurfaceVariant = it))
                                }
                            }
                        )
                        DualColorCell(
                            backgroundName = "error",
                            foregroundName = "onError",
                            background = colorScheme.error,
                            foreground = colorScheme.onError,
                            onBackgroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(error = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(error = it))
                                }
                            },
                            onForegroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(onError = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(onError = it))
                                }
                            }
                        )
                        DualColorCell(
                            backgroundName = "errorContainer",
                            foregroundName = "onErrorContainer",
                            background = colorScheme.errorContainer,
                            foreground = colorScheme.onErrorContainer,
                            onBackgroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(errorContainer = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(errorContainer = it))
                                }
                            },
                            onForegroundChanged = {
                                if (isDarkTheme) {
                                    colorStore.updateDarkColors(colorScheme.copy(onErrorContainer = it))
                                } else {
                                    colorStore.updateLightColors(colorScheme.copy(onErrorContainer = it))
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}