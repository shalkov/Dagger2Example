package ru.shalkoff.dagger2.simple5

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Пример поставления зависимости в модуль, через конструктор.
 *
 * Этот способ не лучшее решение, так как если нам нужен будет контекст
 * в 2 и более модулях, нужно будет его везде прокидывать, это будет больше шаблонного кода
 * Нужно использовать @BindsInstance)
 */
//@Module
//class ResourceModule(
//    private val context: Context
//) {
//
//    @Provides
//    fun provideResourceManager() = ResourceManager(context)
//}

/**
 * поставка зависимости context реализована в компоненте с помощью @BindsInstance
 */
@Module
class ResourceModule {

    @Provides
    fun provideResourceManager(context: Context) = ResourceManager(context)
}