package com.imnstudios.koo.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imnstudios.koo.data.Repo
import com.imnstudios.koo.models.RandomUser
import com.imnstudios.koo.models.Result
import com.imnstudios.koo.util.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UIState(
    val loading: Boolean = true,
    val result: List<Result> = emptyList(),
    val error: Boolean = false //todo
)

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val repository: Repo,
) : ViewModel() {

    private val _uiState = mutableStateOf(UIState())
    val uiSate: State<UIState> = _uiState

    fun attemptAPICall() = viewModelScope.launch {

        _uiState.value = _uiState.value.copy(
            loading = true,
        )
        val list = mutableListOf<Result>()

        _uiState.value.result.let { list.addAll(it) }

        when (val res = repository.getRepos(10)) {
            is ResultWrapper.Success -> {

                list.addAll(res.value.results)
                _uiState.value = _uiState.value.copy(
                    loading = false,
                    result = list,
                )
            }
            is ResultWrapper.NetworkError -> {
                _uiState.value = _uiState.value.copy(
                    loading = false,
                    error = true
                )
            }
            is ResultWrapper.GenericError -> {
                _uiState.value = _uiState.value.copy(
                    loading = false,
                    error = true
                )
            }
        }
    }

}