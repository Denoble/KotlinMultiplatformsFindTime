package com.gevcorst.findtime.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gevcorst.findtime.TimeZoneHelper
import kotlinx.coroutines.delay
import com.gevcorst.findtime.TimeZoneHelperImpl

const val timeMillis = 1000 * 60L // 1 second

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeZoneScreen(
    currentTimezoneStrings: SnapshotStateList<String>
) {
    val timezoneHelper: TimeZoneHelper = TimeZoneHelperImpl()
    val listState = rememberLazyListState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        var time by remember { mutableStateOf(timezoneHelper.currentTime()) }
        LaunchedEffect(Unit) {
            while (true) {
                time = timezoneHelper.currentTime()
                delay(timeMillis) // Every minute
            }
        }
        LocalTimeCard(
            city = timezoneHelper.currentTimeZone(),
            time = time,
            date = timezoneHelper.getDate(timezoneHelper.currentTimeZone())
        )
        Spacer(modifier = Modifier.size(16.dp))
        LazyColumn(
            state = listState,
        ) {
            items(currentTimezoneStrings.size,
                key = { timezone ->
                    timezone
                }) { timezoneString ->
                AnimatedSwipeDismiss(
                    item = timezoneString,
                    // 5
                    background = { _ ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .height(50.dp)
                                .background(Color.Red)
                                .padding(
                                    start = 20.dp,
                                    end = 20.dp
                                )
                        ) {
                            val alpha = 1f
                            Icon(
                                Icons.Filled.Delete,
                                contentDescription = "Delete",
                                modifier = Modifier
                                    .align(Alignment.CenterEnd),
                                tint = Color.White.copy(alpha = alpha)
                            )
                        }
                    },
                    content = {
                        TimeCard(
                            timezone = timezoneString.toString(),
                            hours = timezoneHelper.hoursFromTimeZone(timezoneString.toString()),
                            time = timezoneHelper.getTime(timezoneString.toString()),
                            date = timezoneHelper.getDate(timezoneString.toString())
                        )
                    },
                    onDismiss = { zone ->
                        if (currentTimezoneStrings.contains(zone.toString())) {
                            currentTimezoneStrings.removeAt(zone)
                        }
                    }
                )
            }
        }
    }
}