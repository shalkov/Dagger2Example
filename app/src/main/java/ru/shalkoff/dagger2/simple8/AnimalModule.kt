package ru.shalkoff.dagger2.simple8

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import dagger.multibindings.Multibinds

@Module
interface AnimalModule {

    /**
     * Указываем @Multibinds, чтобы сказать, что этот Set может быть пустым
     * (если не указать, и не будет зависимостей в:
     * @Inject lateinit var animals: Set<@JvmSuppressWildcards Animal>)
     * То даггер выдаст ошибку во время компиляции
     */
    @Multibinds
    fun binAnimals(): Set<Animal>

    @Binds
    @IntoSet
    fun bindCat(cat: Cat): Animal

    @Binds
    @IntoSet
    fun bindDog(dog: Dog): Animal
}