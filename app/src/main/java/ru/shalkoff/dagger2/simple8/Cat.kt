package ru.shalkoff.dagger2.simple8

import javax.inject.Inject

class Cat @Inject constructor() : Animal {

    override fun name(): String {
        return "Кисулькен"
    }
}