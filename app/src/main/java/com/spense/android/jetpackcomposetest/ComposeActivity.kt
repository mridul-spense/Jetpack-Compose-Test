package com.spense.android.jetpackcomposetest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.spense.android.jetpackcomposetest.ui.theme.JetpackComposeTestTheme

class ComposeActivity : ComponentActivity() {

    private var nameGet: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nameGet = intent.getStringExtra("name")

        setContent {
            JetpackComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeScreen(nameGet)
                }
            }
        }
    }
}

fun submitForm(nameValue: String, context: Context) {
    val intent = Intent(context, MainActivity::class.java)
    intent.putExtra("nameValue", nameValue)
    context.startActivity(intent)
    (context as ComposeActivity).finish()
}

@Composable
fun ComposeScreen(nameGet: String?) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var name by remember { mutableStateOf(nameGet) }

        OutlinedTextField(
            value = name!!,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Button(onClick = {
            if (name != null) {
                submitForm(name!!, context)
            }
        }) {
            Text(text = "Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTestTheme {
        ComposeScreen("name")
    }
}