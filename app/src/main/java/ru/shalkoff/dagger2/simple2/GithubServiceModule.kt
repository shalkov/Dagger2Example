package ru.shalkoff.dagger2.simple2

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class GithubServiceModule {

    @Provides
    fun provideGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }
}