package ru.shalkoff.dagger2.simple6

import dagger.Module
import dagger.Provides

@Module
class PayModule {

    /**
     * payManager в параметре мотода, поставляется в граф зависимостей,
     * через компонент, путём указания dependencies [AppComponent]
     */
    @Provides
    fun providePayProcess(payManager: PayManager): PayProcess {
        return PayProcess(payManager)
    }
}