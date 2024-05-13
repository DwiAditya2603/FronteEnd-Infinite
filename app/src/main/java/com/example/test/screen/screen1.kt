package com.example.test.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.test.Data.DataProvider1
import com.example.test.Data.DataProvider2
import com.example.test.Data.darat
import com.example.test.daratListItem
import com.example.test.lautListItem
import com.example.test.navigation.Screens
import com.example.test.topAppBar.topAppBar

@Composable
fun screen1(
    navController: NavController
) {
    val darat = remember {
        DataProvider1.daratList
    }
    val laut = remember {
        DataProvider2.lautList
    }
    Column {
        topAppBar(text = "hewan darat-laut")
        LazyRow (
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ){
            items(
                items = darat, key= {it.id},
                itemContent = {
                    daratListItem(darat = it){
                        DaratId -> navController.navigate(Screens.detaildarat.name+"/${DaratId}")
                    }
                }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn (
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ){
            items(
                items = laut, key = {it.id},
                itemContent = {
                    lautListItem(laut = it){
                            LautId -> navController.navigate(Screens.detaillaut.name+"/${LautId}")
                    }
                }
            )
        }
    }

}