package com.bcoding.fooddeliveryappui.ui.screen


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcoding.fooddeliveryappui.*
import com.bcoding.fooddeliveryappui.R
import com.bcoding.fooddeliveryappui.ui.theme.*

@Composable
fun FoodDeliveryScreen() {
    FoodDeliveryAppUITheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        start = 15.dp,
                        top = 25.dp,
                        bottom = 15.dp,
                        end = 15.dp
                    )
            ) {
                TopBarSection()
                SearchSection()
                Spacer(height = 30)
                SectionCategoryListHorizontal()
                Spacer(height = 30)
                SectionCardFood()
            }
            SectionMenuBottom(
                items = menuItems,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}


@Composable
fun TopBarSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "arrow left",
            tint = colorBlack,
            modifier = Modifier.size(24.dp)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(48.dp)
                .height(48.dp)
                .border(
                    width = 1.dp,
                    color = Color(0x99FF594F),
                    shape = RoundedCornerShape(50.dp)
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier.clip(RoundedCornerShape(50.dp))
            )
        }
    }
}

@Composable
fun SearchSection() {
    Column(modifier = Modifier.padding(top = 20.dp)) {
        Text(
            text = "Enjoy your favourite\n food delicious",
            modifier = Modifier.padding(bottom = 10.dp),
            style = MaterialTheme.typography.h1
        )
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = "Search",
                    tint = searchColor
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .border(width = 0.dp, Color.White, shape = RoundedCornerShape(15.dp)),
            shape = RoundedCornerShape(15.dp),
            placeholder = {
                Text(
                    text = "Search...",
                    style = MaterialTheme.typography.caption,
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.White,
            )

        )
    }
}

@Composable
fun SectionCategoryListHorizontal() {
    val selectedIndex = remember { mutableStateOf(0) }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(50.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        itemsIndexed(categories) { index, item ->
            val isSelected = index == selectedIndex.value
            CategoryTitle(
                category = item,
                isSelected = isSelected,
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = isSelected,
                        enabled = true,
                        onClick = {
                            selectedIndex.value = index
                        }
                    ))
        }
    }
}

@Composable
fun CategoryTitle(category: Any, isSelected: Boolean, modifier: Modifier) {
    Box(
        modifier = modifier,
    ) {
        Text(
            text = category.toString(),
            style = if (isSelected) {
                MaterialTheme.typography.subtitle2
            } else {
                MaterialTheme.typography.caption
            },
            color = colorBlack
        )
    }
}

@Composable
fun SectionCardFood() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(foods) { item: Food ->
            FoodItemForCard(item)
        }
    }
}

@Composable
fun FoodItemForCard(food: Food) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .shadow(10.dp, RoundedCornerShape(30.dp), true)
            .clickable { },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = "heart",
                modifier = Modifier
                    .align(Alignment.End),
                tint = heartColor
            )
            Image(
                painter = painterResource(id = food.image),
                contentDescription = "food${food.id}",
                modifier = Modifier
                    .width(142.dp)
                    .height(142.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(height = 10)
            Text(text = food.title, style = MaterialTheme.typography.subtitle2)
            Spacer(height = 10)
            Text(
                text = food.description,
                style = MaterialTheme.typography.body1.copy(fontSize = 10.sp)
            )
            Spacer(height = 10)
            Text(
                text = "$${food.price}",
                style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

@Composable
fun Spacer(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}

@Composable
fun SectionMenuBottom(
    items: List<Menu>,
    initialSelectedItemIndex: Int = 0,
    modifier: Modifier = Modifier
) {
    var selectedItemIndexMenu by remember { mutableStateOf(initialSelectedItemIndex) }
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
                        selectedItemIndexMenu = index
                    }
            ) {
                Icon(
                    painter = painterResource(id = menu.icon),
                    contentDescription = menu.title + index,
                    tint = if (index == selectedItemIndexMenu) {
                        Color.White
                    } else {
                        white700
                    },
                )
                Text(
                    text = menu.title,
                    style = if (index == selectedItemIndexMenu) {
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

@Preview(showBackground = true)
@Composable
fun FoodDeliveryPreview() {
    FoodDeliveryScreen()
}