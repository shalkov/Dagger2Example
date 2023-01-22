package ru.shalkoff.dagger2.simple1.department

import javax.inject.Inject

class IosDepartment @Inject constructor() : IDepartment {

    override fun getInfo(): String {
        return "Это айос отдел"
    }
}