package com.bcoding.fooddeliveryappui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bcoding.fooddeliveryappui.R

val gilroy = FontFamily(
    listOf(
        Font(R.font.gilroy_regular, FontWeight.Normal),
        Font(R.font.gilroy_medium, FontWeight.Medium),
        Font(R.font.gilroy_bold, FontWeight.Bold),
        Font(R.font.gilroy_extrabold, FontWeight.ExtraBold),
        Font(R.font.gilroy_light, FontWeight.Light),
        Font(R.font.gilroy_semibold, FontWeight.SemiBold),
    )
)

// Set of Material typography styles to start with
val Typography = Typography(

    h1 = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    ),

    h2 = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),

    body1 = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    body2 = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    subtitle1 = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),

    subtitle2 = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),

    button = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),

    caption = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
    )