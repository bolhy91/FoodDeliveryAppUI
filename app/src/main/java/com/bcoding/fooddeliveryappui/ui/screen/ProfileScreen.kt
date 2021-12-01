package com.bcoding.fooddeliveryappui.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.bcoding.fooddeliveryappui.ui.screen.components.BaseLayoutScreen

@Composable
fun ProfileScreen(
    navController: NavHostController,
    selectedItemIndexMenu: MutableState<Int>,
) {
    BaseLayoutScreen(
        navController = navController,
        selectedItemIndexMenu
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Profile",
                style = MaterialTheme.typography.h4
            )
        }
    }
}