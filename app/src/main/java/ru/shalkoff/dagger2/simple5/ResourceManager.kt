package ru.shalkoff.dagger2.simple5

import android.content.Context

class ResourceManager(
    private val context: Context
) {

    //просто тестовая функция
    fun getString(): String {
        return "context test"
    }
}