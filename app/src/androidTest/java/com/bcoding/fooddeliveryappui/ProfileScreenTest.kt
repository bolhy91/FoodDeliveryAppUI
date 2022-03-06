package com.bcoding.fooddeliveryappui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bcoding.fooddeliveryappui.ui.screen.CartScreen
import com.bcoding.fooddeliveryappui.ui.screen.ProfileScreen
import com.bcoding.fooddeliveryappui.ui.theme.FoodDeliveryAppUITheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test unit ProfileScreen
 */
@RunWith(AndroidJUnit4::class)
class ProfileScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    /**
     * Test CartScreen
     * @return void
     */
    @Test
    fun useTextCartScreen() {
        val selectedItemIndexMenu = mutableStateOf(1)
        lateinit var navController: NavHostController

        composeTestRule.setContent {
            FoodDeliveryAppUITheme{
                navController = rememberNavController()
                ProfileScreen(navController = navController, selectedItemIndexMenu = selectedItemIndexMenu)
            }
        }
        composeTestRule.onNodeWithTag("profileTag").assertIsDisplayed()
    }

}