package com.example.notify.presentation.screens.main

import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notify.R
import com.example.notify.presentation.theme.NotifyTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    navController: NavController
) {
    val pagerState = rememberPagerState()
    val pages = listOf(
        painterResource(id = R.drawable.ic_outline_book_24),
        painterResource(id = R.drawable.ic_outline_fact_check_24),
        painterResource(id = R.drawable.ic_outline_event_24),
    )
    TabRow(
        // Our selected tab is our current page
        selectedTabIndex = pagerState.currentPage,
        // Override the indicator, using the provided pagerTabIndicatorOffset modifier
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        // Add tabs for all of our pages
        pages.forEachIndexed { index, title ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { /* TODO */ },
                icon = { Icon(painter = title, contentDescription = "main_tab") }
            )
        }
    }

    HorizontalPager(
        count = pages.size,
        state = pagerState,
    ) { page ->
        when (page) {
            0 -> {

            }
            1 -> {

            }
            2 -> {

            }
            else -> {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotifyTheme {
        MainScreen(navController = rememberNavController())
    }
}