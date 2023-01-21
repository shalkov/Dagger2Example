package ru.shalkoff.dagger2.simple1.department

class IosDepartment: IDepartment {

    override fun getInfo(): String {
        return "Это айос отдел"
    }
}