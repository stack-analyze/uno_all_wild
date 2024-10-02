package com.stackanlyze.unoallwild.ui.components

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.stackanlyze.unoallwild.ui.Rule

@Composable
fun Rule(rule: Rule) {
    ListItem(
        headlineContent = { Text(rule.name) },
        supportingContent = { Text(rule.desc) },
        leadingContent = rule.image
    )
    HorizontalDivider()
}