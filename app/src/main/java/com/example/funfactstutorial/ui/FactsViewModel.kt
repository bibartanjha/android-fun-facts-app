package com.example.funfactstutorial.ui

import androidx.lifecycle.ViewModel

class FactsViewModel: ViewModel() {

    fun generateRandomFact(selectedAnimal: String): String {
        return if (selectedAnimal == "Cat") getCatFact() else getDogFact()
    }

    fun getDogFact(): String {
        return "Dogs have a paw-sitive outlook on life"
    }

    fun getCatFact(): String {
        return "Cats believe laptops were invented as warm napping spots"
    }

}

