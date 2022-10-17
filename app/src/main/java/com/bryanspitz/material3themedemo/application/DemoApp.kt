package com.bryanspitz.material3themedemo.application

import android.app.Activity
import android.app.Application

class DemoApp : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.factory().create(this)
    }

    inline fun <reified T> dependency() = component as T
}

inline fun <reified T> Activity.appDependency() = (application as DemoApp).dependency<T>()