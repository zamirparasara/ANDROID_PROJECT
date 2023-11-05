package com.example.quiziapp.utils

import com.example.quiziapp.R

object IconPicker {
    val icons = arrayOf(
        R.drawable.ic_icon1,
        R.drawable.ic_icon2,
        R.drawable.ic_icon3,
        R.drawable.ic_icon4,
        R.drawable.ic_book
    )

    var currentIcon = 0

    fun getIcon(): Int{
        currentIcon = (currentIcon+1)% icons.size
        return icons[currentIcon]
    }
}