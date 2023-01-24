package ru.shalkoff.dagger2.simple3

import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(
    private val analyticsConfig: AnalyticsConfig
) : AnalyticsRepository {

    override fun showCartEvent(): String {
        return "Firebase: " + analyticsConfig.version.toString()
    }
}