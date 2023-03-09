package ru.shalkoff.dagger2.simple9

import javax.inject.Inject

class Terminator @Inject constructor() : Robot {

    override fun name(): String {
        return "Терминатор"
    }
}