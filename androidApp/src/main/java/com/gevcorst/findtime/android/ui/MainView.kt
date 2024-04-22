package com.gevcorst.findtime.android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.gevcorst.findtime.android.theme.AppTheme

sealed class Screen(val title: String) {
    object TimeZonesScreen : Screen("Timezones")
    object FindTimeScreen : Screen("Find Time")
}

data class BottomNavigationItem(
    val route: String,
    val icon: ImageVector,
    val iconContentDescription: String
)

val bottomNavigationItems = listOf(
    BottomNavigationItem(
        Screen.TimeZonesScreen.title,
        Icons.Filled.Info,
        "Timezones"
    ),
    BottomNavigationItem(
        Screen.FindTimeScreen.title,
        Icons.Filled.Place,
        "Find Time"
    )
)

// 1
@OptIn(ExperimentalMaterial3Api::class)
@Composable
// 2
fun MainView(actionBarFun: topBarFun = { EmptyComposable() }) {
    val showAddDialog = remember { mutableStateOf(false) }
    val currentTimezoneStrings = remember { SnapshotStateList<String>() }
    val selectedIndex = remember { mutableStateOf(0) }
    AppTheme {
        Scaffold(
            topBar = {
                actionBarFun(selectedIndex.value)
            },
            floatingActionButton = {
                // TODO: Add Floating action button
                if (selectedIndex.value == 0) {

                    FloatingActionButton(
                        modifier = Modifier
                            .padding(16.dp),
                        onClick = {
                            showAddDialog.value = true
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null
                        )
                    }
                }
            },
            bottomBar = {
                NavigationBar {
                    bottomNavigationItems.forEachIndexed { i, bottomNavigationItem ->
                        NavigationBarItem(selected = selectedIndex.value == i,
                            onClick = { selectedIndex.value = i },
                            colors = NavigationBarItemDefaults.colors(
                                unselectedIconColor = Color.Black,
                                selectedIconColor = Color.White
                            ),
                            label = {
                                Text(
                                    bottomNavigationItem.route,
                                    style = MaterialTheme.typography.titleSmall
                                )
                            },
                            icon = {
                                Icon(
                                    bottomNavigationItem.icon,
                                    contentDescription = bottomNavigationItem.iconContentDescription
                                )
                            })
                    }
                }

            }
        ) {
            it.toString()
            // TODO: Replace with Dialog
            when (selectedIndex.value) {
                0 -> TimeZoneScreen(currentTimezoneStrings)
                // 1 -> FindMeetingScreen(currentTimezoneStrings)
            }
        }
    }
}
