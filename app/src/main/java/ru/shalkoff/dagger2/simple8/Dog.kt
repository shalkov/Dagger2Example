package ru.shalkoff.dagger2.simple8

import javax.inject.Inject

class Dog @Inject constructor() : Animal {

    override fun name(): String {
        return "Собакен"
    }
}