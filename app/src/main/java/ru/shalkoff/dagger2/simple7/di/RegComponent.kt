package ru.shalkoff.dagger2.simple7.di

import dagger.Component
import ru.shalkoff.dagger2.dagger.AppComponent
import ru.shalkoff.dagger2.simple7.RegStepOneActivity
import ru.shalkoff.dagger2.simple7.RegStepTwoActivity

/**
 * Этот компонент помечет скоупом @RegistrationScope,
 * тем самым время жизни этого компонента ограничена фичей "Регистрации"
 */
@RegistrationScope
@Component(
    dependencies = [AppComponent::class]
)
interface RegComponent {

    @Component.Builder
    interface Builder {

        fun appComponent(appComponent: AppComponent): Builder

        fun build(): RegComponent
    }

   fun inject(activity: RegStepOneActivity)

   fun inject(activity: RegStepTwoActivity)
}