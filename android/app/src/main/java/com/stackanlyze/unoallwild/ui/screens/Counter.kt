package com.stackanlyze.unoallwild.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.core.text.isDigitsOnly
import com.stackanlyze.unoallwild.ui.components.Player

@SuppressLint("UnrememberedMutableState", "MutableCollectionMutableState")
@Composable
fun CounterView(modifier: Modifier = Modifier) {
    // static
    val playersList = listOf(0, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // states
    var totalPlayers by rememberSaveable { mutableIntStateOf(0) }

    var expandedDropdown by remember { mutableStateOf(false) }
    var expandedModal by remember { mutableStateOf(false) }

    var positionA by remember { mutableStateOf("") }
    var swapCardsA by remember { mutableStateOf("") }

    var positionB by remember { mutableStateOf("") }
    var swapCardsB by remember { mutableStateOf("") }

    val playerSwapCards = remember { mutableStateListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0) }

    // computer
    val dropdownIcon =
        if (expandedDropdown) Icons.Outlined.KeyboardArrowUp else Icons.Outlined.KeyboardArrowDown
    val isManyPlayers = { value: Int -> if (value == 0) "Sin" else value }
    val resetSwapCards = {
        for (i in 0..9) {
            playerSwapCards[i] = 0
        }
    }

    // styles
    val dropdownStyles = modifier
        .clickable { expandedDropdown = true }
        .fillMaxWidth()
        .wrapContentSize(Alignment.TopStart)

    // dialog
    if (expandedModal) AlertDialog(
        onDismissRequest = { expandedModal = !expandedModal },
        title = { Text(text = "intercambio de cartas") },
        text = {
            Column {
                TextField(
                    value = positionA,
                    onValueChange = {
                        if (it.isDigitsOnly() && it.length == 1) positionA = it
                    },
                    label = {
                        val validate =
                            if (positionA.length == 1) "Jugador ${positionA.toInt() + 1}" else "solo un digito"
                        Text(text = validate)
                    },
                    visualTransformation = VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
                )

                TextField(
                    value = swapCardsA,
                    label = {
                        Text(text = "cartas para intercambiar $swapCardsA")
                    },
                    onValueChange = { if (it.isDigitsOnly()) swapCardsA = it },
                    visualTransformation = VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
                )

                TextField(
                    value = positionB,
                    onValueChange = {
                        if (it.isDigitsOnly() && it.length == 1) positionB = it
                    },
                    label = {
                        val validate =
                            if (positionB.length == 1) "Jugador ${positionB.toInt() + 1}" else "solo un digito"
                        Text(text = validate)
                    },
                    visualTransformation = VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
                )

                TextField(
                    value = swapCardsB,
                    label = {
                        Text(text = "cartas para intercambiar $swapCardsB")
                    },
                    onValueChange = { if (it.isDigitsOnly()) swapCardsB = it },
                    visualTransformation = VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    playerSwapCards[positionA.toInt()] = swapCardsB.toInt()
                    playerSwapCards[positionB.toInt()] = swapCardsA.toInt()

                    expandedModal = false

                    positionA = ""
                    positionB = ""
                    swapCardsA = ""
                    swapCardsB = ""
                },
                enabled = positionB != positionA && swapCardsB != swapCardsA,
            ) { Text(text = "Finish") }
        },
        dismissButton = {
            TextButton(onClick = {
                expandedModal = false
                positionA = ""
                positionB = ""
                swapCardsA = ""
                swapCardsB = ""
            }) { Text(text = "Cancel") }
        }
    )

    // layout
    Column {
        Box(modifier = dropdownStyles) {
            ListItem(
                headlineContent = { Text(text = "${isManyPlayers(totalPlayers)} Jugadores") },
                trailingContent = { Icon(dropdownIcon, contentDescription = null) }
            )

            DropdownMenu(
                expandedDropdown, onDismissRequest = { expandedDropdown = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                playersList.forEach { index ->
                    DropdownMenuItem(
                        text = { Text(text = "${isManyPlayers(index)} Jugadores") },
                        onClick = {
                            expandedDropdown = false
                            totalPlayers = index
                        }
                    )
                }
            }
        }
        
        LazyColumn(state = rememberLazyListState()) {
            items(totalPlayers) {
                Player(
                    position = it + 1,
                    changeCards = playerSwapCards[it],
                    openDialog = { expandedModal = true },
                    resetChangeCards = resetSwapCards
                )
            }
        }
    }
}