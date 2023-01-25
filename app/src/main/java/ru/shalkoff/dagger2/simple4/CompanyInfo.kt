package ru.shalkoff.dagger2.simple4

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.shalkoff.dagger2.simple1.department.AndroidDepartment

/**
 * @AssistedInject - позволяет заинжектить объект в граф зависимости,
 * если некоторые из параметров конструктора не запроваджены в граф.
 * Аннотацией @Assisted помечаем объекты, которые нужно будет самостоятельно передать в конструктор
 *
 * Создаётся интерфейс с фабрикой, который как раз и инжектиться куда надо.
 * Метод create() в фабрике вернёт нам нужный объект.
 */
data class CompanyInfo @AssistedInject constructor(
    @Assisted("name") val name: String,
    val androidDepartment: AndroidDepartment
) {

    @AssistedFactory
    interface Factory {

        fun create(@Assisted("name") name: String): CompanyInfo
    }
}