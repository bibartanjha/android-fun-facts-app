package com.example.funfactstutorial.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.funfactstutorial.data.UserDataUiEvents
import com.example.funfactstutorial.data.UserInputScreenState

class UserInputViewModel: ViewModel() {
    var uiState = mutableStateOf(
        UserInputScreenState()
    )

    fun onEvent(event: UserDataUiEvents) {
        when(event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
            }
        }
    }

    fun isValidState(): Boolean {
        return uiState.value.nameEntered.isNotEmpty() && uiState.value.animalSelected.isNotEmpty()
    }
}