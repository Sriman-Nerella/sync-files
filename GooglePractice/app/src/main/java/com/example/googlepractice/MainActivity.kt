package com.example.googlepractice

import android.graphics.Paint.Align
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.googlepractice.ui.theme.GooglePracticeTheme
import android.widget.Button as Button

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GooglePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   //AppPreview(given= stringResource(R.string.intro),content = stringResource(R.string.content))
//                    DiceGame()
//                    FactorialCalculator()
                    Lemonade();
                }
            }
        }
    }
}

@Composable
fun AppPreview(given:String, content:String ,modifier: Modifier = Modifier){
    Column(
        //verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
    ) {
        Image(painter = painterResource(id = R.drawable.bg_compose_background), contentDescription = null)
        Text(text = "Jetpack Compose tutorial", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(text = given,modifier = Modifier.padding(16.dp), textAlign = TextAlign.Justify)
        Text(text = content,modifier = Modifier.padding(16.dp), textAlign = TextAlign.Justify)
    }
}

@Composable
fun TaskManager(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.ic_task_completed), contentDescription = "Task is successful")
        Text(text="All tasks completed", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top=24.dp, bottom = 8.dp))
        Text(text="Nice Work!", fontSize = 18.sp)

    }
}

@Composable
fun BusinessUI(
    name: String,
    Profession: String,
    PhoneNum: String,
    id: String,
    mailid: String
){
    Column(
        modifier = Modifier.background(Color(0xc2,0xf0,0xc2,0xF1)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
        Text(text = "Jennifer Doe", fontSize = 36.sp)
        Text(text= "Android Developer Extramanage", color = Color(0x00,0x33,0x00,0xFF), fontWeight = FontWeight.Bold)
    }

    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.padding(8.dp, vertical = 40.dp)){
        Column {
            Row(modifier = Modifier.padding(10.dp)) {
                Icon(Icons.Rounded.Call, tint = Color(0xFF3ddc84),contentDescription = "Call me")
                Text(text = "1234567890",modifier = Modifier.padding(start = 20.dp))
            }
            Row(modifier = Modifier.padding(10.dp)) {
                Icon(Icons.Rounded.Share, tint = Color(0xFF3ddc84),contentDescription = "share me")
                Text(text = "my id", modifier = Modifier.padding(start=20.dp))
            }
            Row(modifier = Modifier.padding(10.dp)) {
                Icon(Icons.Rounded.Email, tint = Color(0xFF3ddc84),contentDescription = "Call me")
                Text(text = "srimannerella@gmail.com",  modifier = Modifier.padding(start = 20.dp))
            }
        }
    }
}

@Composable
fun DiceGame(modifier: Modifier = Modifier){
    var result by remember {
        mutableStateOf(1)
    }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = imageResource), contentDescription = result.toString())
        Button(onClick = {result = (1..6).random()}) {
            Text(text = stringResource(id = R.string.roll), fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text="The roll on the dice is $result")
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactorialCalculator(modifier:Modifier = Modifier){
    var ip = 1
    fun calcFactorial(num:Int):Int{
        var result = 1
        if (num == 0) {return result}
        for (i in 1..num) {
            result *= i
        }
        return result
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Factorial Guesser", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = {Text(text="Enter the number")},
            label = { Text("Label") },

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun FactorialPreview(){
    FactorialCalculator(modifier = Modifier.fillMaxSize())
}


