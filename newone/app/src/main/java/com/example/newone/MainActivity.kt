package com.example.newone

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newone.ui.theme.NewActivity
import com.example.newone.ui.theme.NewoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row {
                        Text(text = "Choose one among these two",
                            fontSize = 25.sp
                            )
                    }
                    Row (
                        modifier = Modifier.padding(20.dp)
                    ){
                        Button(onClick = {
                            val navigate = Intent(this@MainActivity, NewActivity::class.java)
                            startActivity(navigate)
                        }) {
                            Text(text = "Navigate", fontSize = 18.sp)
                        }
                        Button(onClick = {
                            val navigate = Intent(this@MainActivity,CheckoutActivity::class.java)
                            startActivity(navigate)
                        }) {
                            Text(text = "Press this", fontSize = 18.sp)

                        }
                    }
                }



        }
    }
}

