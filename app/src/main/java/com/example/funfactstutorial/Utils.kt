package com.example.funfactstutorial

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object Utils {

    fun generateRandomColor(): Color {
        return Color(
            // RGB:
            red = Random.nextFloat(),
            green = Random.nextFloat(),
            blue = Random.nextFloat(),
            alpha = 1f // full opacity
        )
    }
}