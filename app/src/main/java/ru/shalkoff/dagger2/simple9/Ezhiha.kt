package ru.shalkoff.dagger2.simple9

import javax.inject.Inject

class Ezhiha @Inject constructor() : Robot {

    override fun name(): String {
        //from Atomic Heart
        return "Ежиха"
    }
}