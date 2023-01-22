package ru.shalkoff.dagger2.simple1.department

import javax.inject.Inject

class FlutterDepartment @Inject constructor() : IDepartment {

    override fun getInfo(): String {
        return "Это флаттер отдел"
    }
}