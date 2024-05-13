package com.example.test.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.test.Data.DataProvider1
import com.example.test.Data.DataProvider3
import com.example.test.Data.DataProvider3.udara
import com.example.test.Data.darat
import com.example.test.Data.udara
import com.example.test.topAppBar.topAppback

@Composable
fun detailudara(
    modifier : Modifier = Modifier,
    navController: NavController,
    UdaraId : Int?
)
{
    val newudaraList = DataProvider3.udaraList.filter { udara ->
        udara.id == UdaraId
    }
    Column(
        modifier = Modifier
    ) {
        DetailudaraContent(newudaraList = newudaraList,navController = navController )
    }
}

@Composable
fun DetailudaraContent(
    newudaraList: List<udara>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        if (newudaraList.isNotEmpty()) {
            topAppback(
                text = newudaraList.first().title,
                navController = navController,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                newudaraList.forEach { udara ->
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = udara.udaraImageid),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                                .width(300.dp)
                                .height(200.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Nama : ${udara.title}")
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Deskripsi : ${udara.description}")
                    }
                }
            }
        } else {
            Text(text = "Tidak ada hewan udara untuk ditampilkan", modifier = Modifier.fillMaxWidth().padding(16.dp))
        }
    }
}