package com.stackanlyze.unoallwild.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.stackanlyze.unoallwild.ui.navigation.BottomBar
import com.stackanlyze.unoallwild.ui.navigation.NavGraph

@Composable
fun App() {
    val modifier = Modifier
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = { BottomBar(navController) }
    ) { innerPadding -> NavGraph(navController, modifier.padding(innerPadding)) }
}
