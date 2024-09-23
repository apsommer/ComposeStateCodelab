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

    // MutableState is automatically tracked by compose
    // remember inline function is similar to private val
    // 'by' keyword defines 'delegate' allowing indirect reference to getter and setter, reduces code
    var count by remember { mutableStateOf(0) }

    Column(modifier = modifier.padding(16.dp)) {

        if (count > 0) {

            // show task is forgotten when count = 0 as this line is not called
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today?",
                    onClose = { showTask = false }
                )
            }
            Text("You've had $count glasses.")
        }
        Row(Modifier.padding(top = 8.dp)) {
            Button(
                enabled = count < 10,
                onClick = { count ++ }) {
                Text(text = "Add one")
            }
            Button(
                onClick = { count = 0 },
                modifier = Modifier.padding(start = 8.dp)) {
                Text(text = "Clear water counter")
            }
        }
    }
}