package ru.shalkoff.dagger2.dagger.modules

import dagger.Module
import dagger.Provides
import ru.shalkoff.dagger2.simple1.department.AndroidJuniorGroup

/**
 * Нет необходимости провайдить какие-то классы, через модули, если есть возможность
 * проставить аннтотацию @Inject в конструктор, например как в классах:
 * - Company
 * - AndroidDepartment
 * - FlutterDepartment
 * - IosDepartment
 *
 * Для примера, класс AndroidJuniorGroup, запровайжен через этот модуль, но это не обязательно.
 * Можно просто написать @Inject constructor() в AndroidJuniorGroup и класс DepartmentModule можно удалить.
 */
@Module
class DepartmentModule {

    @Provides
    fun provideAndroidJuniorGroup(): AndroidJuniorGroup {
        return AndroidJuniorGroup()
    }
}