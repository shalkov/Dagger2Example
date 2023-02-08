package ru.shalkoff.dagger2.dagger.injectors

import ru.shalkoff.dagger2.simple7.di.DaggerRegComponent
import ru.shalkoff.dagger2.simple7.di.RegComponent

/**
 * Класс инкапсулирует логику работы с компонентом фичи регистрации
 */
object RegistrationFeatureInjector {

    private var regComponent: RegComponent? = null

    fun getRegComponent(): RegComponent {
        val currentRegComponent = regComponent
        return if (currentRegComponent != null) {
            currentRegComponent
        } else {
            val regComponent = DaggerRegComponent.builder()
                .appComponent(AppInjector.appComponent)
                .build()
            RegistrationFeatureInjector.regComponent = regComponent
            regComponent
        }
    }

    fun clearRegComponent() {
        regComponent = null
    }
}