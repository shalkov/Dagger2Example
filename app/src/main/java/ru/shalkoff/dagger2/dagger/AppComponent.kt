package ru.shalkoff.dagger2.dagger

import dagger.Component
import ru.shalkoff.dagger2.MainActivity
import ru.shalkoff.dagger2.dagger.modules.DepartmentModule
import ru.shalkoff.dagger2.dagger.modules.NetworkModule
import javax.inject.Singleton

/**
 * Это основной компонент приложения (создание графа зависимостей)
 * Граф зависимостей, это то место, где содержаться и разрешаються все зависипости.
 * Из компонента, можно получать зависимости
 */
@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DepartmentModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}