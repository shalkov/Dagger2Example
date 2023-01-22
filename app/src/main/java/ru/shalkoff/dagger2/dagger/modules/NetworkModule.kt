package ru.shalkoff.dagger2.dagger.modules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.shalkoff.dagger2.simple2.GithubServiceModule

@Module(
    includes = [
        GithubServiceModule::class
    ]
)
class NetworkModule {

    /**
     * Обычно используются модули, в тех случаях, когда нет возможности добавить в граф
     * зависимость, через конструктор. Например, как тут:
     */
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}