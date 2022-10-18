package com.bryanspitz.material3themedemo.ui.main

import android.content.Intent
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bryanspitz.material3themedemo.application.appDependency
import com.bryanspitz.material3themedemo.repository.color.ColorStoreSource
import com.bryanspitz.material3themedemo.repository.mode.ModeStoreSource
import com.bryanspitz.material3themedemo.ui.edit.EditActivity
import com.bryanspitz.material3themedemo.ui.theme.Material3ThemeDemoTheme

class MainActivity : ComponentActivity() {
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

            Material3ThemeDemoTheme(
                darkTheme = isDarkTheme, colorScheme = if (isDarkTheme) darkTheme else lightTheme
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text("Material 3 Theme Demo") }, actions = {
                            IconButton(onClick = { modeStore.setDarkMode(!isDarkTheme) }) {
                                Icon(
                                    imageVector = if (isDarkTheme) Icons.Default.LightMode
                                    else Icons.Default.DarkMode,
                                    contentDescription = "change theme"
                                )
                            }
                        })
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                            startActivity(Intent(this, EditActivity::class.java))
                        }) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "edit theme"
                            )
                        }
                    },
                    bottomBar = {
                        var selectedItem by remember { mutableStateOf(1) }
                        NavigationBar {
                            NavigationBarItem(
                                selected = selectedItem == 1,
                                onClick = { selectedItem = 1 },
                                label = { Text("One") },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "one"
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = selectedItem == 2,
                                onClick = { selectedItem = 2 },
                                label = { Text("Two") },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Remove,
                                        contentDescription = "two"
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = selectedItem == 3,
                                onClick = { selectedItem = 3 },
                                label = { Text("Three") },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.QuestionMark,
                                        contentDescription = "three"
                                    )
                                }
                            )
                        }
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
                        Text(
                            text = "Buttons",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Column(
                            verticalArrangement = spacedBy(8.dp)
                        ) {
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = "Standard")
                            }
                            ElevatedButton(onClick = { /*TODO*/ }) {
                                Text(text = "Elevated")
                            }
                            OutlinedButton(onClick = { /*TODO*/ }) {
                                Text(text = "Outlined")
                            }
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "Text")
                            }
                        }

                        Text(
                            text = "Cards",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Column(
                            verticalArrangement = spacedBy(8.dp)
                        ) {
                            ElevatedCard(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Elevated",
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                            Card(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Filled",
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                            OutlinedCard(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Outlined",
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }

                        Text(
                            text = "Chips",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Row(
                            horizontalArrangement = spacedBy(8.dp)
                        ) {
                            AssistChip(
                                onClick = {},
                                label = { Text(text = "Assist") },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.CalendarMonth,
                                        contentDescription = null
                                    )
                                }
                            )
                            var filterSelected by remember { mutableStateOf(false) }
                            FilterChip(
                                selected = filterSelected,
                                onClick = { filterSelected = !filterSelected },
                                label = { Text(text = "Filter") },
                                leadingIcon = if (filterSelected) {
                                    {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = null
                                        )
                                    }
                                } else null
                            )
                            InputChip(
                                selected = false,
                                onClick = {},
                                label = { Text(text = "Input") },
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = null
                                    )
                                }
                            )
                            SuggestionChip(
                                onClick = {},
                                label = { Text(text = "Suggestion") },
                            )
                        }
                        Column {
                            ElevatedAssistChip(
                                onClick = {},
                                label = { Text(text = "Elevated Assist") },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.CalendarMonth,
                                        contentDescription = null
                                    )
                                }
                            )
                            var filterSelected by remember { mutableStateOf(false) }
                            ElevatedFilterChip(
                                selected = filterSelected,
                                onClick = { filterSelected = !filterSelected },
                                label = { Text(text = "Elevated Filter") },
                                leadingIcon = if (filterSelected) {
                                    {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = null
                                        )
                                    }
                                } else null
                            )
                            ElevatedSuggestionChip(
                                onClick = {},
                                label = { Text(text = "Elevated Suggestion") },
                            )
                        }

                        Text(
                            text = "Alert Dialog",
                            style = MaterialTheme.typography.titleLarge
                        )
                        var showAlert by remember { mutableStateOf(false) }
                        Button(onClick = { showAlert = true }) {
                            Text(text = "Show Alert")
                        }
                        if (showAlert) {
                            AlertDialog(
                                onDismissRequest = { showAlert = false },
                                title = { Text(text = "Alert dialog") },
                                text = { Text(text = "This is an alert dialog.") },
                                confirmButton = {
                                    TextButton(onClick = { showAlert = false }) {
                                        Text("OK")
                                    }
                                }
                            )
                        }

                        Text(
                            text = "Divider",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Divider()

                        Text(
                            text = "Progress Indicators",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Column(
                            verticalArrangement = spacedBy(8.dp)
                        ) {
                            LinearProgressIndicator(progress = 0.5f)
                            CircularProgressIndicator(progress = 0.5f)
                        }

                        Text(
                            text = "Radio Buttons",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Row {
                            var selection by remember { mutableStateOf(0) }
                            RadioButton(selected = selection == 0, onClick = { selection = 0 })
                            RadioButton(selected = selection == 1, onClick = { selection = 1 })
                            RadioButton(selected = selection == 2, onClick = { selection = 2 })
                        }

                        Text(
                            text = "Slider",
                            style = MaterialTheme.typography.titleLarge
                        )
                        var sliderValue by remember { mutableStateOf(0f) }
                        Slider(value = sliderValue, onValueChange = { sliderValue = it })

                        Text(
                            text = "Switch",
                            style = MaterialTheme.typography.titleLarge
                        )
                        var switchValue by remember { mutableStateOf(false) }
                        Switch(checked = switchValue, onCheckedChange = { switchValue = it })

                        Text(
                            text = "Text Fields",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Column(
                            verticalArrangement = spacedBy(8.dp)
                        ) {
                            var filledTextValue by remember { mutableStateOf("") }
                            var outlinedTextValue by remember { mutableStateOf("") }
                            var isError by remember { mutableStateOf(false) }
                            TextField(
                                value = filledTextValue,
                                onValueChange = { filledTextValue = it },
                                label = { Text(text = "Filled") },
                                placeholder = { Text(text = "Filled placeholder") },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null
                                    )
                                },
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = null
                                    )
                                },
                                isError = isError
                            )
                            OutlinedTextField(
                                value = outlinedTextValue,
                                onValueChange = { outlinedTextValue = it },
                                label = { Text(text = "Outlined") },
                                placeholder = { Text(text = "Outlined placeholder") },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null
                                    )
                                },
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = null
                                    )
                                },
                                isError = isError
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Switch(checked = isError, onCheckedChange = { isError = it })
                                Text(text = "Use error colors")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Material3ThemeDemoTheme {
        Greeting("Android")
    }
}