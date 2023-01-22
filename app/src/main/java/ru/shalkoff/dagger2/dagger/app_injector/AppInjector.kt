package ru.shalkoff.dagger2.dagger.app_injector

import ru.shalkoff.dagger2.dagger.AppComponent
import ru.shalkoff.dagger2.dagger.DaggerAppComponent

/**
 * Делаем так, чтобы AppComponent был доступен в любом месте приложения.
 * Чтобы можно было бы заинжектить граф зависимостей в любой необходимый для нас класс.
 */
object AppInjector {

    private var _appComponent: AppComponent? = null

    internal val appComponent: AppComponent
        get() {
            return checkNotNull(_appComponent) {
                "AppComponent = null, такого не должно быть"
            }
        }

    fun initDaggerAppComponent() {
       _appComponent = DaggerAppComponent.create()
    }
}