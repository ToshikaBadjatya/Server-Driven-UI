package com.example.server_driven_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ComposeRenderer
import com.example.server_driven_ui.ui.theme.ServerDrivenUiTheme

class ComposeMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ServerDrivenUiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RenderUi(modifier= Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RenderUi(modifier: Modifier) {
    ComposeRenderer.Builder()
       .setJsonString("")
       .setMultiPage(true)
       .setJsonString("")
       .build()

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ServerDrivenUiTheme {
        RenderUi(modifier = Modifier)
    }
}