package com.bryanspitz.material3themedemo.repository.mode

import com.bryanspitz.material3themedemo.application.AppComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@AppComponent.AppScope
class ModeStore @Inject constructor() {

    private val _isDarkMode = MutableStateFlow(false)
    val darkMode: Flow<Boolean> = _isDarkMode

    fun setDarkMode(darkMode: Boolean) {
        _isDarkMode.value = darkMode
    }
}

interface ModeStoreSource {
    fun modeStore(): ModeStore
}