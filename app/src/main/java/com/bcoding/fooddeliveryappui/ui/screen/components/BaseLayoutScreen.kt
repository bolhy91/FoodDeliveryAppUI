package com.bcoding.fooddeliveryappui.ui.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.bcoding.fooddeliveryappui.Menu
import com.bcoding.fooddeliveryappui.menuItems
import com.bcoding.fooddeliveryappui.ui.theme.colorBlack
import com.bcoding.fooddeliveryappui.ui.theme.white700

@Composable
fun BaseLayoutScreen(
    navController: NavHostController,
    selectedItemIndexMenu: MutableState<Int>,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        content()
        SectionMenuBottom(
            items = menuItems,
            modifier = Modifier.align(Alignment.BottomCenter),
            navController = navController,
            selectedItemIndexMenu = selectedItemIndexMenu
        )
    }
}

@Composable
fun SectionMenuBottom(
    items: List<Menu>,
    initialSelectedItemIndex: Int = 0,
    selectedItemIndexMenu:  MutableState<Int>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    //var selectedItemIndexMenu by remember { mutableStateOf(initialSelectedItemIndex) }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(colorBlack)
    ) {
        items.forEachIndexed { index, menu ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        selectedItemIndexMenu.value = index
                        navController.navigate(menu.url)
                    }
            ) {
                Icon(
                    painter = painterResource(id = menu.icon),
                    contentDescription = menu.title + index,
                    tint = if (index == selectedItemIndexMenu.value) {
                        Color.White
                    } else {
                        white700
                    },
                )
                Text(
                    text = menu.title,
                    style = if (index == selectedItemIndexMenu.value) {
                        MaterialTheme.typography.subtitle2
                    } else {
                        MaterialTheme.typography.body1
                    },
                    color = Color.White,
                )
            }
        }
    }
}