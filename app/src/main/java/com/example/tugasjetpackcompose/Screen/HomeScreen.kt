package com.example.tugasjetpackcompose.Screen

import com.example.tugasjetpackcompose.TopBar
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onItemClick: (String, Int, String) -> Unit = { _, _, _ -> }
) {
    Column(modifier = Modifier.fillMaxSize()
        .background(Color(0xff8f9562)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var mylist = AllJenisHewan()

        LazyRow (
            contentPadding = PaddingValues(13.dp),
            content = {
                itemsIndexed(mylist) { index, item ->
                    HewanItem(
                        item = item,
                        onItemClick = onItemClick
                    )
                }
            }
        )
        LazyColumn (
            contentPadding = PaddingValues(13.dp),
            content = {
            itemsIndexed(mylist) { index, item ->
                HewanItem(
                    item = item,
                    onItemClick = onItemClick
                )
            }
        })
    }
}

@Composable
fun HewanItem(
    item : JenisHewan,
    onItemClick: (String, Int, String) -> Unit = { _, _, _ -> }
) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                onItemClick(item.name, item.image, item.namaIlmiah)
            },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp)
                .clickable {
                    onItemClick(item.name, item.image, item.namaIlmiah)
                }
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = item.name,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(64.dp)
                    .scale(1.0f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = item.namaIlmiah, fontSize = 14.sp, color = Color.Black)
            }
        }
    }
}

@Composable
fun listVertical() {
    var scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for (i in 1..15) {
            Text(text = "Item $i")
        }
    }
}

@Composable
fun ColumnList(text: String) {
    Text(text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.Center,
        fontSize = 20.sp
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}

@Preview(showBackground = true)
@Composable
fun PreviewListVertical() {
    listVertical()
}

@Preview(showBackground = true)
@Composable
fun PreviewColumnList() {
    ColumnList(text = "Preview ColumnList")
}