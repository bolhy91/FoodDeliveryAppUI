package com.bcoding.fooddeliveryappui.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavHostController
import com.bcoding.fooddeliveryappui.ui.screen.components.BaseLayoutScreen

/**
 * Cart Screen
 * @param navController
 * @param selectedItemIndexMenu
 * @return void
 */
@Composable
fun CartScreen(
    navController: NavHostController,
    selectedItemIndexMenu: MutableState<Int>,
) {
    BaseLayoutScreen(
        navController = navController,
        selectedItemIndexMenu = selectedItemIndexMenu
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Cart",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.testTag("textCartScreen")
            )
        }
    }
}