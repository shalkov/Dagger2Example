package ru.shalkoff.dagger2.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.shalkoff.dagger2.MainActivity
import ru.shalkoff.dagger2.dagger.modules.AppModule
import ru.shalkoff.dagger2.dagger.modules.DepartmentModule
import ru.shalkoff.dagger2.dagger.modules.NetworkModule
import ru.shalkoff.dagger2.simple5.ResourceModule
import ru.shalkoff.dagger2.simple6.AppDependency
import ru.shalkoff.dagger2.simple6.PayModule
import javax.inject.Singleton

/**
 * Это основной компонент приложения (создание графа зависимостей)
 * Граф зависимостей, это то место, где содержаться и разрешаються все зависипости.
 * Из компонента, можно получать зависимости
 */
@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DepartmentModule::class,
        ViewModelModule::class,
        ResourceModule::class,
        PayModule::class
    ],
    dependencies = [
        AppDependency::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder

        fun appDependency(appDependency: AppDependency): Builder

        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}