package ru.shalkoff.dagger2

import android.app.Application
import ru.shalkoff.dagger2.dagger.injectors.AppInjector

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppInjector.initDaggerAppComponent(this)
    }
}