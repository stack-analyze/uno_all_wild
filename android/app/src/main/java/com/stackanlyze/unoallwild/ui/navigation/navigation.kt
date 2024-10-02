package com.stackanlyze.unoallwild.ui.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.stackanlyze.unoallwild.R.drawable.ic_rules
import com.stackanlyze.unoallwild.R.drawable.ic_counter
import com.stackanlyze.unoallwild.R.drawable.ic_about
import com.stackanlyze.unoallwild.ui.screens.*

sealed class NavScreen(
    val title: String,
    val route: String,
    val icon: Int,
) {
    data object Rules : NavScreen(
        title = "reglas",
        route = "rules",
        icon = ic_rules
    )

    data object Counter : NavScreen(
        title = "contador",
        route = "counter",
        icon = ic_counter
    )

    data object About : NavScreen(
        title = "acerca de",
        route = "about",
        icon = ic_about
    )
}

val screens = listOf(
    NavScreen.Rules,
    NavScreen.Counter,
    NavScreen.About
)

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController, NavScreen.Rules.route,
        modifier = modifier
    ) {
        composable(NavScreen.Rules.route) { RulesView() }
        composable(NavScreen.Counter.route) { CounterView() }
        composable(NavScreen.About.route) { AboutView() }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach { screen -> AddItem(screen, currentDestination, navController) }
    }
}

@Composable
fun RowScope.AddItem(
    screen: NavScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val colors = NavigationBarItemDefaults.colors(
        unselectedIconColor = Color(MaterialTheme.colorScheme.onBackground.toArgb()),
        selectedIconColor = Color(MaterialTheme.colorScheme.secondary.toArgb())
    )

    NavigationBarItem(
        icon = { Icon(painterResource(screen.icon), "navigation icon") },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        label = { Text(text = screen.title) },
        colors = colors,
        onClick = {
            navController.navigate(screen.route) {
                launchSingleTop = true
            }
        }
    )
}
