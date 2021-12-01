package com.bcoding.fooddeliveryappui.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcoding.fooddeliveryappui.Food
import com.bcoding.fooddeliveryappui.R
import com.bcoding.fooddeliveryappui.filterFood
import com.bcoding.fooddeliveryappui.ui.theme.colorBlack
import com.bcoding.fooddeliveryappui.ui.theme.starYellow


@Composable
fun FoodDeliveryDetailScreen(
    foodId: String,
    onBack: () -> Unit
) {
    val food = filterFood(foodId)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(
                    top = 25.dp,
                )
        ) {
            TopBarSectionDetail(onBack)
            Spacer(height = 20)
            if (food != null) SectionFoodDetail(food)
            SectionFoodDescriptionDetail(food?.description ?: "")
        }
    }
}

@Composable
fun TopBarSectionDetail(onBack: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left),
            contentDescription = "arrow left",
            tint = colorBlack,
            modifier = Modifier
                .size(24.dp)
                .clickable { onBack() },
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bag),
            contentDescription = "bag",
            tint = colorBlack,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun SectionFoodDetail(food: Food) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .padding(start = 20.dp, bottom = 15.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.4f)
        ) {
            Text(
                text = food.title,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 25.sp)) {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, fontSize = 14.sp)) {
                        append("Price\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp
                        )
                    ) {
                        append(food.price.toString())
                    }
                }
            })
            Spacer(height = 20)
            ChoiceQuantity()
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset(30.dp),
            contentAlignment = Alignment.BottomEnd,
        ) {
            Image(
                painter = painterResource(id = food.image),
                contentDescription = "food${food.id}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(Color.Transparent)
                    .shadow(20.dp, shape = RoundedCornerShape(100.dp), true)
            )
        }
    }
}

@Composable
fun ChoiceQuantity() {
    val quantity = remember { mutableStateOf(1) }
    Text(
        text = "Choice quantity",
        style = MaterialTheme.typography.body2
    )
    Row(
        modifier = Modifier
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .width(24.dp)
                .height(24.dp)
                .background(Color.White)
                .clickable {
                    if (quantity.value > 0) quantity.value = quantity.value - 1
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painterResource(id = R.drawable.ic_minus),
                contentDescription = "minus"
            )
        }
        Text(
            text = quantity.value.toString(),
            style = MaterialTheme.typography.subtitle1
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .width(24.dp)
                .height(24.dp)
                .background(Color.White)
                .clickable { quantity.value = quantity.value + 1 },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painterResource(
                    id = R.drawable.ic_add
                ),
                contentDescription = "plus",

                )
        }
    }
}

@Composable
fun SectionFoodDescriptionDetail(description: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 40.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.subtitle1
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = "star",
                        tint = starYellow,
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .size(16.dp)
                    )
                    Text(
                        text = "4.9",
                        style = MaterialTheme.typography.subtitle1.copy(
                            fontSize = 16.sp,
                            color = starYellow
                        ),
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }
            Spacer(height = 30)
            Text(
                text = description,
                style = MaterialTheme.typography.body1,
                lineHeight = 25.sp
            )
            Spacer(height = 20)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .clip(RoundedCornerShape(15.dp))
                        .background(colorBlack)
                        .padding(5.dp)
                ) {
                    Text(
                        text = "Order Now",
                        style = MaterialTheme.typography.button,
                        modifier = Modifier
                    )
                }
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(5.dp)
                        .size(45.dp),
                    border = BorderStroke(1.dp, colorBlack),
                    shape = RoundedCornerShape(15.dp)

                ) {
                    Text(
                        text = "Add Cart",
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
        }
    }
}