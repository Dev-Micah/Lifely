package com.micahnyabuto.lifely

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.micahnyabuto.lifely.core.navigation.AppNavHost
import com.micahnyabuto.lifely.core.navigation.BottomNavigation
import com.micahnyabuto.lifely.core.navigation.Destinations
import com.micahnyabuto.lifely.ui.theme.LifelyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifelyTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                    ?: Destinations.Splash::class.qualifiedName.orEmpty()
                val showBottomNavigation = currentRoute !in listOf(
                    Destinations.Splash::class.qualifiedName,


                    )
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets.navigationBars.only(WindowInsetsSides.Horizontal),
                    bottomBar = {
                        if (showBottomNavigation) {
                            Column {
                                HorizontalDivider(thickness = 1.dp)
                                NavigationBar(
                                    tonalElevation = 0.dp,
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                ) {
                                    BottomNavigation.entries.forEachIndexed { index, navigationItem ->
                                        val isSelected by remember(currentRoute) {
                                            derivedStateOf { currentRoute == navigationItem.route }
                                        }

                                        NavigationBarItem(
                                            selected = isSelected,
                                            onClick = {
                                                navController.navigate(navigationItem.route)
                                            },
                                            icon = {
                                                Icon(
                                                    imageVector = if (isSelected) navigationItem.selectedIcon else navigationItem.unselectedIcon,
                                                    contentDescription = navigationItem.label,
                                                    modifier = Modifier.size(24.dp)
                                                )
                                            },
                                            label = {
                                                Text(
                                                    text = navigationItem.label,
                                                    fontSize = 10.sp,
                                                    fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                                                )
                                            },
                                            colors = NavigationBarItemDefaults.colors(
                                                indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                                                    elevation = 0.dp
                                                    ),
                                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                                unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                                                unselectedTextColor = MaterialTheme.colorScheme.onSurface
                                            )
                                        )
                                    }
                                }

                            }
                        }
                    }
                ){innerpadding ->
                    AppNavHost(
                        modifier = Modifier.padding(innerpadding),
                        navController = navController
                    )
                }
            }
        }
    }
}

