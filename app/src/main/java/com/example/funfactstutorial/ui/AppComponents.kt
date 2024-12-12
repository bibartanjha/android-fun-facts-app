package com.example.funfactstutorial.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfactstutorial.Utils

@Composable
fun TopBar(value: String, emojiValue: String) {
    Row (modifier = Modifier.fillMaxWidth()) {
        Text(
            text = value,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = emojiValue,
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("Hello There", "\uD83D\uDE0A")
}

@Composable
fun TextComponent(
    textValue: String,
    textSize: TextUnit,
    colorValue: Color = Color.Black
) {
   Text(
       text = textValue,
       fontSize = textSize,
       color = colorValue,
       fontWeight = FontWeight.Light
   )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(
        textValue = "Bib's app",
        textSize = 24.sp
    )
}

@Composable
fun TextFieldComponent(
    onTextChanged: (name: String) -> Unit
) {
    var currentValue by remember{
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChanged(it)
        },
        placeholder = {
            Text(text = "Enter your name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),

    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponent(onTextChanged = {})
}

@Composable
fun AnimalCard(
    animalName: String,
    selected: Boolean,
    animalSelected: (animalName: String) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable {
                    animalSelected(animalName)
                }
            ,
            contentAlignment = Alignment.Center
        ) {
            Text(text = animalName, fontSize = 18.sp)
        }

    }
}

@Preview
@Composable
fun AnimalCardPreview() {
    AnimalCard(animalName = "Dog", selected = false, animalSelected = {})
}

@Composable
fun ButtonComponent(
    textValue: String,
    onClicked: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClicked
    ) {
        TextComponent(
            textValue = textValue,
            textSize = 18.sp

        )
    }
}

@Preview
@Composable
fun ButtonComponentPreview() {
    ButtonComponent(textValue = "Go to details screen", onClicked = {})
}

@Composable
fun TextWithShadow(value: String) {
    val shadowOffset = Offset(x = 1f, y = 2f)
    Text(
        text = value,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(
                Utils.generateRandomColor(),
                shadowOffset,
                2f
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun TextWithShadowPreview() {
    TextWithShadow("Sample text")
}

@Composable
fun FactsComposable(value: String) {
    Card(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp, 24.dp)
        ) {
            Spacer(
                modifier = Modifier.size(24.dp)
            )
            TextWithShadow(value = value)
            Spacer(
                modifier = Modifier.size(24.dp)
            )
        }
    }

}

@Preview
@Composable
fun FactsComposablePreview() {
    FactsComposable(value = "ABCDEFG")
}