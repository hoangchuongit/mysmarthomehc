package com.example.mysmarthomehc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mysmarthomehc.ui.theme.MySmartHomeHCTheme

import com.thingclips.smart.home.sdk.ThingHomeSdk;
import com.thingclips.smart.optimus.sdk.ThingOptimusSdk;

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MySmartHomeHCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android 11",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        ThingHomeSdk.init(application);
        ThingHomeSdk.setDebugMode(true);
        ThingOptimusSdk.init(application);
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MySmartHomeHCTheme {
        Greeting("Android")
    }
}