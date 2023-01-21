package ru.shalkoff.dagger2.dagger.modules

import dagger.Module
import dagger.Provides
import ru.shalkoff.dagger2.simple1.department.AndroidDepartment
import ru.shalkoff.dagger2.simple1.Company
import ru.shalkoff.dagger2.simple1.department.FlutterDepartment
import ru.shalkoff.dagger2.simple1.department.IosDepartment

/**
 * Модули используются для того, чтобы добавить зависимости в граф(в компонент)
 */
@Module
object DepartmentModule {

    @Provides
    fun provideCompany(
        androidDep: AndroidDepartment,
        iosDep: IosDepartment,
        flutterDep: FlutterDepartment
    ): Company {
        return Company(
            androidDep,
            iosDep,
            flutterDep
        )
    }

    @Provides
    fun provideAndroidDep(): AndroidDepartment {
        return AndroidDepartment()
    }

    @Provides
    fun provideIosDep(): IosDepartment {
        return IosDepartment()
    }

    @Provides
    fun provideFlutterDep(): FlutterDepartment {
        return FlutterDepartment()
    }
}