package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                    LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableIntStateOf(1) }
    var squeezeCount by remember { mutableIntStateOf(0) }

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color = Color.Yellow)
            .fillMaxWidth()
            .height(60.dp)
        
    ){
        Text(
            text = "Lemonade",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
    
        when(currentStep){
            1 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box (
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(color = Color(0xffC3ECD2))
                            .padding(40.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.lemon_tree),
                            contentDescription = R.string.lemon_tree_content_description.toString(),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    currentStep = 2
                                    squeezeCount = (2..4).random()
                                }
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = R.string.lemon_tree),
                        fontSize = 18.sp
                    )

                }
            }

            2 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Box (
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(color = Color(0xffC3ECD2))
                            .padding(40.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.lemon_squeeze),
                            contentDescription = R.string.lemon_content_description.toString(),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    squeezeCount--
                                    if(squeezeCount == 0){
                                        currentStep = 3
                                    }
                                }
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = R.string.lemon),
                        fontSize = 18.sp
                    )
                }
            }

            3 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Box (
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(color = Color(0xffC3ECD2))
                            .padding(40.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.lemon_drink),
                            contentDescription = R.string.glass_of_lemonade_content_description.toString(),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable { currentStep = 4 }
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = R.string.glass_of_lemonade),
                        fontSize = 18.sp
                    )
                }
            }

            4 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Box (
                        modifier = Modifier.clip(RoundedCornerShape(30.dp))
                            .background(color = Color(0xffC3ECD2))
                            .padding(40.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.lemon_restart),
                            contentDescription = R.string.empty_glass_content_description.toString(),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable { currentStep = 1 }
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = R.string.empty_glass),
                        fontSize = 18.sp
                    )
                }
            }



        }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonApp()
    }
}