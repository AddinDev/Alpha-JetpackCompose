package com.addindev.alphacompose

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.addindev.alphacompose.ui.theme.AlphaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

data class Post(
    @DrawableRes val image: Int,
    val name: String,
    val hour: Int
)

val posts = listOf<Post>(
    Post(R.drawable.g, "udin", 1),
    Post(R.drawable.s, "addin", 3),
    Post(R.drawable.r, "satria", 4)
)

@Composable
fun Content() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())

        ) {
            for (post in posts) {
                PostCard(post = post)
            }
        }
}

@Composable
fun PostCard(post: Post) {
    Column(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(post.name, style = MaterialTheme.typography.h4, fontWeight = FontWeight.Bold)
            Text("Posted ${post.hour} hour ago", style = TextStyle(color = Color.Gray))
        }
        Card(
            elevation = 4.dp,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = post.image),
                contentDescription = "Post",
                contentScale = ContentScale.FillBounds
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    Content()
}