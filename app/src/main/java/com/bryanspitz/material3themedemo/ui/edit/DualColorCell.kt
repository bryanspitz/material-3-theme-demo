package com.bryanspitz.material3themedemo.ui.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp

@Composable
fun DualColorCell(
    backgroundName: String,
    foregroundName: String,
    background: Color,
    foreground: Color,
    onBackgroundChanged: (Color) -> Unit,
    onForegroundChanged: (Color) -> Unit
) {
    var backgroundText by remember(background) {
        mutableStateOf(background.toArgb().toUInt().toString(16))
    }
    var foregroundText by remember(background) {
        mutableStateOf(foreground.toArgb().toUInt().toString(16))
    }

    Row {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            TextField(
                value = backgroundText,
                onValueChange = {
                    backgroundText = it
                    try {
                        onBackgroundChanged(Color(it.toUInt(16).toInt()))
                    } catch (e: Exception) {
                    }
                },
                label = { Text(backgroundName) }
            )
            TextField(
                value = foregroundText,
                onValueChange = {
                    foregroundText = it
                    try {
                        onForegroundChanged(Color(it.toUInt(16).toInt()))
                    } catch (e: Exception) {
                    }
                },
                label = { Text(foregroundName) }
            )
        }
        Surface(
            modifier = Modifier
                .size(width = 180.dp, height = 100.dp)
                .fillMaxHeight(),
            color = background,
            contentColor = foreground
        ) {
            Text(text = backgroundName)
        }
    }
}