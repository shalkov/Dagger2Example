package ru.shalkoff.dagger2.simple7

import ru.shalkoff.dagger2.simple7.di.RegistrationScope
import javax.inject.Inject

/**
 * Этот интерактор создаётся в одном экземпляре в конткетсе фичи "Регистрация"
 * И объект уничтожается, когда мы выходим из флоу фичи "Регистрации"
 * (время жизни объекта, регулируется компонентов в котором он был создан)
 */
@RegistrationScope
class RegInteractor @Inject constructor() {

    fun getName() = "RegInteractor"
}