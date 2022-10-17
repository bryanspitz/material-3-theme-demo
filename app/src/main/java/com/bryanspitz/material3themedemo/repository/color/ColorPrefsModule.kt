package com.bryanspitz.material3themedemo.repository.color

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.bryanspitz.material3themedemo.application.AppComponent
import dagger.Module
import dagger.Provides

private const val FILE_COLORS = "colors"

@Module
class ColorPrefsModule {

    @AppComponent.AppScope
    @Provides
    fun colorPrefs(
        context: Context
    ): SharedPreferences = context.getSharedPreferences(FILE_COLORS, MODE_PRIVATE)
}