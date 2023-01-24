package ru.shalkoff.dagger2.simple3

/**
 * Интерфейс со всеми событиями аналитики
 */
interface AnalyticsRepository {

    fun showCartEvent(): String
}