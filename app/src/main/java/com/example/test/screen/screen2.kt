package com.example.test.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.test.Data.DataProvider3
import com.example.test.navigation.Screens
import com.example.test.topAppBar.topAppBar
import com.example.test.udaraListItem

@Composable
fun screen2(
    navController: NavController
) {
    val udara = remember {
        DataProvider3.udaraList
    }
    Column {
        topAppBar(text = "hewan udara")
        LazyVerticalGrid(
            contentPadding = PaddingValues(40.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                items = udara, key = {it.id},
                itemContent = {
                    udaraListItem(udara = it){
                            UdaraId -> navController.navigate(Screens.detailudara.name+"/${UdaraId}")
                    }
                }
            )
        }
    }
}