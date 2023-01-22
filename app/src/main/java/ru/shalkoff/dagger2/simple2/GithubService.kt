package ru.shalkoff.dagger2.simple2

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Сервис, который позволяет преобразовать HTTP запрос в интерфейс Retrofit
 */
interface GithubService {

    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String): List<RepoInfo>
}