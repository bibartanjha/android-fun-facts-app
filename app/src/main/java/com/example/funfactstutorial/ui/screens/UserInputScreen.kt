package com.example.funfactstutorial.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.funfactstutorial.data.UserDataUiEvents
import com.example.funfactstutorial.ui.AnimalCard
import com.example.funfactstutorial.ui.ButtonComponent
import com.example.funfactstutorial.ui.TextComponent
import com.example.funfactstutorial.ui.TextFieldComponent
import com.example.funfactstutorial.ui.TopBar
import com.example.funfactstutorial.ui.UserInputViewModel

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
    showWelcomeScreen: (valuesPair: Pair<String, String>) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
//            .clickable {
//                navController.navigate(Routes.WELCOME_SCREEN)
//            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            Spacer(
                modifier = Modifier.size(35.dp)
            )
            TopBar("Hello from Bib's app", "\uD83D\uDE0A")
            Spacer(
                modifier = Modifier.size(20.dp)
            )
            TextComponent(
                textValue = "Let's learn about you!",
                textSize = 24.sp
            )
            Spacer(
                modifier = Modifier.size(12.dp)
            )
            TextComponent(
                textValue = "This app will prepare a details page based on input provided by you!",
                textSize = 18.sp
            )
            Spacer(
                modifier = Modifier.size(60.dp)
            )
            TextComponent(
                textValue = "Name",
                textSize = 18.sp
            )
            Spacer(
                modifier = Modifier.size(10.dp)
            )
            TextFieldComponent(
                onTextChanged = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.UserNameEntered(it)
                    )
                }
            )
            Spacer(
                modifier = Modifier.size(20.dp)
            )
            TextComponent(
                textValue = "What do you like ",
                textSize = 18.sp
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                val animals = listOf("Cat", "Dog")
                animals.forEach { animal ->
                    AnimalCard(
                        animalName = animal,
                        selected = userInputViewModel.uiState.value.animalSelected == animal,
                        animalSelected = {
                            userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))
                        }
                    )
                }
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            if (userInputViewModel.isValidState()) {
                ButtonComponent(
                    textValue = "Go to details screen",
                    onClicked = {
                        showWelcomeScreen(
                            Pair(
                                userInputViewModel.uiState.value.nameEntered,
                                userInputViewModel.uiState.value.animalSelected
                            )
                        )
                    }
                )
            }
        }
//        Text(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(80.dp),
//            text = Routes.USER_INPUT_SCREEN
//        )
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel(), {})
}