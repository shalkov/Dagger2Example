package ru.shalkoff.dagger2.simple3

import javax.inject.Inject

class MindboxRepositoryImpl @Inject constructor(
    private val analyticsConfig: AnalyticsConfig
) : AnalyticsRepository {

    override fun showCartEvent(): String {
        return "Mindbox: " + analyticsConfig.version.toString()
    }
}