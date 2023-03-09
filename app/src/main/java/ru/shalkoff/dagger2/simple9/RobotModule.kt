package ru.shalkoff.dagger2.simple9

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.Multibinds

@Module
interface RobotModule {

    @Multibinds
    fun bindRobots(): Map<Class<*>, Robot>

    @Binds
    @IntoMap
    @ClassKey(Terminator::class)
    fun bindTerminator(terminator: Terminator): Robot

    @Binds
    @IntoMap
    @ClassKey(Ezhiha::class)
    fun bindEzhiha(ezhiha: Ezhiha): Robot
}