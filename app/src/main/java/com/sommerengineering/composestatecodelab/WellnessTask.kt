package com.sommerengineering.composestatecodelab

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
) {

    // mutable state observed by compose
    var isChecked by mutableStateOf(initialChecked)
}