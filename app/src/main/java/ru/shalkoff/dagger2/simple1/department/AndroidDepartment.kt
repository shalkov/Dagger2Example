package ru.shalkoff.dagger2.simple1.department

import javax.inject.Inject

class AndroidDepartment @Inject constructor(
    val juniorGroup: AndroidJuniorGroup
) : IDepartment {

    override fun getInfo(): String {
        return "Это андройд отдел"
    }
}