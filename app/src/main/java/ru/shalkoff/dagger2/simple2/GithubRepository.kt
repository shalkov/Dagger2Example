package ru.shalkoff.dagger2.simple2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val githubService: GithubService
) {

    suspend fun getRepos(user: String): List<RepoInfo> {
        return withContext(Dispatchers.IO) {
            githubService.listRepos(user)
        }
    }
}