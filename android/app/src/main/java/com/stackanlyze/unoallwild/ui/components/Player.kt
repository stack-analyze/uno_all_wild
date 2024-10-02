package com.stackanlyze.unoallwild.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.stackanlyze.unoallwild.R.drawable.ic_counter

@Composable
fun Player(
    position: Int,
    changeCards: Int,
    openDialog: () -> Unit,
    resetChangeCards: () -> Unit,
) {
    // state
    var reciverCards by remember { mutableIntStateOf(changeCards) }
    var cards by remember { mutableIntStateOf(7) }

    val toggleWord = if (cards == 1) "carta" else "cartas"
    val isEnabled = cards == 0

    // watch
    if (reciverCards != 0) {
        cards = changeCards
        reciverCards = 0
    }


    // layout
    ListItem(
        headlineContent = { Text(text = "Jugador $position: $cards $toggleWord") },
        supportingContent = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(
                    onClick = openDialog,
                    enabled = !isEnabled,
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = MaterialTheme.colorScheme.tertiary
                    )
                ) {
                    Icon(painter = painterResource(id = ic_counter), contentDescription = "swap cards")
                }
                TextButton(onClick = { cards-- }, enabled = !isEnabled) { Text(text = "-1") }

                TextButton(
                    onClick = { cards++ },
                    enabled = !isEnabled,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.error
                    ),
                ) { Text(text = "+1") }


                TextButton(
                    onClick = { cards += 2 },
                    enabled = !isEnabled,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.error
                    ),
                ) { Text(text = "+2") }
                TextButton(
                    onClick = { cards += 4 },
                    enabled = !isEnabled,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.error
                    ),
                ) { Text(text = "+4") }
                IconButton(
                    onClick = {
                        cards = 7
                        resetChangeCards()
                    }, enabled = isEnabled,
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = MaterialTheme.colorScheme.secondary
                    )
                ) { Icon(Icons.Outlined.Refresh, contentDescription = "swap cards") }
            }
        },
    )
    HorizontalDivider()
}