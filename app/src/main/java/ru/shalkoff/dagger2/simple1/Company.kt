package ru.shalkoff.dagger2.simple1

import ru.shalkoff.dagger2.simple1.department.AndroidDepartment
import ru.shalkoff.dagger2.simple1.department.FlutterDepartment
import ru.shalkoff.dagger2.simple1.department.IosDepartment
import javax.inject.Inject

class Company @Inject constructor(
    val androidDep: AndroidDepartment,
    val iosDepartment: IosDepartment,
    val flutterDepartment: FlutterDepartment,
)