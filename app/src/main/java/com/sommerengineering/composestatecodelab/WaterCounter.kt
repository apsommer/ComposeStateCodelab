package com.sommerengineering.composestatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(16.dp)) {

        // MutableState is automatically tracked by compose
        // remember inline function is similar to private val
        // 'by' keyword defines 'delegate' allowing indirect reference to getter and setter, reduces code
        var count by remember { mutableStateOf(0) }

        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(
            enabled = count < 10,
            onClick = { count ++ }) {
            Text(text = "Add one")
        }
    }
}