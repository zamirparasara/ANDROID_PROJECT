package com.example.quiziapp.utils

object ColorPicker {
    val colors = arrayOf(
        "#FFBB86FC",
        "#FF6200EE",
        "#FF3700B3",
        "#FF03DAC5",
        "#FF018786",
        "#18206F"
    )

    var currentColor = 0

    fun getColor(): String {
        currentColor = (currentColor+1)% colors.size
        return colors[currentColor]
    }
}