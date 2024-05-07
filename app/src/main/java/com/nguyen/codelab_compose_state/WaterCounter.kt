package com.nguyen.codelab_compose_state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguyen.codelab_compose_state.ui.theme.CodeLabComposeStateTheme

@Composable
fun WaterCounter2(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by remember { mutableStateOf(0) }

        // if the button has been clicked
        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }
            // determine whether to show the WellnessTaskItem
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today?",
                    checked = true,
                    onCheckedChange = {},
                    onClose = { showTask = false },
                )
            }
            Text("You've had $count glasses.")
        }

        Row(Modifier.padding(top = 8.dp)) {
            // enable Button as long as count is < 10
            Button(onClick = { count++ }, enabled = count < 10) {
                Text("Add one")
            }
            Button(
                onClick = { count = 0 },
                Modifier.padding(start = 8.dp)
            ) {
                Text("Clear water count")
            }
        }
    }
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

// display the count and call a function when you increment the count
@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

// own the state: hold the count state and modify it when calling the StatelessCounter function
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    CodeLabComposeStateTheme {
        WaterCounter()
    }
}