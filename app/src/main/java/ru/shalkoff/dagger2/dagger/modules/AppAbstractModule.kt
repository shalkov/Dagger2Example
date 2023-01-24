package ru.shalkoff.dagger2.dagger.modules

import dagger.Binds
import dagger.Module
import ru.shalkoff.dagger2.simple3.AnalyticsRepository
import ru.shalkoff.dagger2.simple3.FirebaseRepositoryImpl
import ru.shalkoff.dagger2.simple3.MindboxRepositoryImpl
import javax.inject.Named

/**
 * В одном модуле не могут находиться в перемешку и абстпрактные и обычные методы.
 * Поэтому нужно выделять отдельный бастрактный модуль
 * и включать его напрямую в компонент или другой модуль, как удобно.
 */
@Module
abstract class AppAbstractModule {

    /**
     * Для оптимизации был введён @Binds, он работает так же как и @Provider,
     * но использовать @Binds можно только в случаях, когда можно сопоставить интерфейс и его реализацию.
     * Если есть несколько реализаций этого интерфейса, надо использовать @Named.
     *
     * В общем @Binds предпочтительнее использовать, так как он генерирует где-то на 40% меньше кода,
     * следовательно сборка будет быстрее и сам .apk содержать меньше кода.
     *
     * @Bind можно вешать только на абстактные методы
     */
    @Binds
    @Named("firebase")
    abstract fun bindFirebaseAnalyticsRepository(
        firebaseRepositoryImpl: FirebaseRepositoryImpl
    ): AnalyticsRepository

    @Binds
    @Named("mindbox")
    abstract fun bindMindboxAnalyticsRepository(
        mindboxRepositoryImpl: MindboxRepositoryImpl
    ): AnalyticsRepository
}