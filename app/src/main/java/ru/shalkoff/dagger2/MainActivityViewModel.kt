package ru.shalkoff.dagger2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.shalkoff.dagger2.simple2.GithubRepository
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    val githubRepository: GithubRepository
): ViewModel() {

    fun loadRepos() {
        viewModelScope.launch {
            val result = githubRepository.getRepos("shalkov")
            result.count()
        }
    }
}