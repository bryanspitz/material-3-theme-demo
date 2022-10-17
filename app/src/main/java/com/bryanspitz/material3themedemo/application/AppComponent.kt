package com.bryanspitz.material3themedemo.application

import android.content.Context
import com.bryanspitz.material3themedemo.repository.color.ColorPrefsModule
import com.bryanspitz.material3themedemo.repository.color.ColorStoreSource
import com.bryanspitz.material3themedemo.repository.mode.ModeStoreSource
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@AppComponent.AppScope
@Component(
    modules = [
        ColorPrefsModule::class
    ]
)
interface AppComponent :
    ColorStoreSource,
    ModeStoreSource {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }

    @Scope
    annotation class AppScope
}