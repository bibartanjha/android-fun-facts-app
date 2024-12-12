package com.example.funfactstutorial.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funfactstutorial.ui.FactsComposable
import com.example.funfactstutorial.ui.FactsViewModel
import com.example.funfactstutorial.ui.TextComponent
import com.example.funfactstutorial.ui.TextWithShadow
import com.example.funfactstutorial.ui.TopBar

@Composable
fun WelcomeScreen(username: String?, animalSelected: String?) {
    println("=====INSIDE+WELCOMESCREEN")
    println("=====$username and $animalSelected")
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
           modifier = Modifier
               .fillMaxSize()
               .padding(18.dp)
        ) {
            Spacer(
                modifier = Modifier.size(35.dp)
            )
            TopBar(
                value = "Welcome $username",
                emojiValue = "\uD83D\uDE0D"
            )
            Spacer(
                modifier = Modifier.size(20.dp)
            )
            TextComponent(
                textValue = "Thank you for sharing your data",
                textSize = 24.sp
            )
            Spacer(
                modifier = Modifier.size(60.dp)
            )
            val animalEmoji = if (animalSelected == "Cat") "\uD83D\uDC31" else "\uD83D\uDC36"
            val finalText = "You are a $animalSelected lover $animalEmoji"
            TextWithShadow(finalText)

            val factsViewModel: FactsViewModel = viewModel()
            FactsComposable(
                value = factsViewModel.generateRandomFact(animalSelected!!)
            )
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen("Username", "animalSelected")
}