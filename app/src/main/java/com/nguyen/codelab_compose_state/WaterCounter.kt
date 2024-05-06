package com.nguyen.codelab_compose_state

import androidx.compose.foundation.layout.Column
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
    // add the Button below the Text.
    // * use a Column to vertically align the Text with the Button.
    // * move the external padding from the Text to the Column.
    // * add some extra padding to the top of the Button to separate it from the Text
    // * change count from val to var so it becomes mutable
    Column(modifier = modifier.padding(16.dp)) {
        // MutableState: changes to count are now tracked by Compose
        // A value calculated by remember is stored in the Composition during the initial
        // composition, and the stored value is kept across recompositions
        // Usually remember and mutableStateOf are used together in composable functions
        // val count: MutableState<Int> = remember { mutableStateOf(0) }
        var count by remember { mutableStateOf(0) }

        Text("You've had $count glasses.")
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp)) {
            Text("Add one")
        }
    }
}