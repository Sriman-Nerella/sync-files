package com.example.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo.data.Feature
import com.example.demo.ui.theme.AquaBlue
import com.example.demo.ui.theme.BlueViolet1
import com.example.demo.ui.theme.BlueViolet2
import com.example.demo.ui.theme.BlueViolet3
import com.example.demo.ui.theme.ButtonBlue
import com.example.demo.ui.theme.DeepBlue
import com.example.demo.ui.theme.LightGreen1
import com.example.demo.ui.theme.LightGreen2
import com.example.demo.ui.theme.LightGreen3
import com.example.demo.ui.theme.LightRed
import com.example.demo.ui.theme.OrangeYellow1
import com.example.demo.ui.theme.OrangeYellow2
import com.example.demo.ui.theme.OrangeYellow3
import com.example.demo.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            Action1()
            ChipSection(
                chips = listOf(
                    "pop",
                    "emo",
                    "melody",
                    "classic",
                    "metal",
                ),
            )
            CurrentTask(color = LightGreen1)
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                ),
            )
        }
    }
}


@Composable
fun Action1(modifier: Modifier = Modifier, name: String = "Sriman") {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Hello $name,", style = MaterialTheme.typography.titleLarge)
            Text(
                text = "Hope you are having a great time",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search bar",
            modifier = modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(chips: List<String>) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow(modifier = Modifier.padding(start = 10.dp)) {
        items(chips.size) {
            Box(modifier = Modifier
                .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                .clip(RoundedCornerShape(10.dp))
                .clickable { selectedChipIndex = it }
                .background(
                    if (selectedChipIndex == it) Color.Cyan
                    else Color.Transparent
                )

                .padding(16.dp),
                contentAlignment = Alignment.Center) {
                Text(text = chips[it])
            }
        }
    }
}


@Composable
fun BottomMenu(
    //items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighLightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(16.dp)
    ) {
        //items.forEachIndexed{index,item ->

    }
}


@Composable
fun CurrentTask(color: Color = Color.LightGray, category: String = "Meditation") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(16.dp)
    ) {
        Column {
            Text(text = "Meditation thoughts", style = MaterialTheme.typography.titleLarge)
            Row {
                Text(text = category, style = MaterialTheme.typography.bodyMedium)
                Text(text = " ~ ")
                Text(text = "3-10 min", style = MaterialTheme.typography.bodyMedium)
            }
        }
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "Play Button",
            tint = Color.White,
            modifier = Modifier
                .size(50.dp)
                .clip(
                    RoundedCornerShape(50.dp)
                )
                .background(LightRed)
                .padding(10.dp)
        )

    }
}

@Composable
fun FeatureSection(features: List<Feature>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Feature",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.DarkGray)

        ) {
            Spacer(modifier = Modifier.height(10.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 100.dp),
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                items(features.size) {
                    BoxWithConstraints(
                        modifier = Modifier
                            .padding(8.dp)
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(features[it].darkColor)
                    ) {
                        val width = constraints.maxWidth
                        val height = constraints.maxHeight
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(15.dp)
                        ) {
                            Text(
                                text = features[it].title,
                                style = MaterialTheme.typography.bodySmall,
                                lineHeight = 26.sp,
                                modifier = Modifier.align(Alignment.TopStart)
                            )
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = features[it].title,
                                tint = Color.White,
                                modifier = Modifier.align(Alignment.BottomStart)
                            )
                            Text(
                                text = "Start",
                                color = TextWhite,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier

                                    .align(Alignment.BottomEnd)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(ButtonBlue)
                                    .clickable {
                                        // Handle the click
                                    }
                                    .padding(vertical = 6.dp, horizontal = 15.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen()
}