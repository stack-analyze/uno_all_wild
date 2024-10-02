package com.stackanlyze.unoallwild.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.stackanlyze.unoallwild.ui.components.Rule
import com.stackanlyze.unoallwild.ui.rules

@Composable
fun RulesView() {
    LazyColumn { items(rules) { Rule(rule = it) } }
}
