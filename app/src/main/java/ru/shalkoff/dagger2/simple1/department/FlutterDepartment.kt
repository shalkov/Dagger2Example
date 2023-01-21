package ru.shalkoff.dagger2.simple1.department

class FlutterDepartment: IDepartment {

    override fun getInfo(): String {
        return "Это флаттер отдел"
    }
}