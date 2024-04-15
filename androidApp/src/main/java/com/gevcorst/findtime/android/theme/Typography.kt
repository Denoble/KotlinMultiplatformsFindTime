package com.gevcorst.findtime.android.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// 1
val typography = Typography(
    // 2
    headlineLarge = TextStyle(
        // 3
        fontFamily = FontFamily.SansSerif,
        // 4
        fontSize = 24.sp,
        // 5
        fontWeight = FontWeight.Bold,
        // 6
        color = Color.White
    ),

    headlineMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        color = Color.White
    ),

    bodyMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 12.sp,
        color = Color.White
    ),

    bodySmall = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 10.sp,
        color = Color.White
    )
)