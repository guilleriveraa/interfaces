package com.example.myapplication.venanciob.practica10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.venanciob.practica10.ui.theme.Practica10Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica10Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    com.example.myapplication.venanciob.practica10.PantallaBotones(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaBotones(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(
            text = "TIPOS DE BOTON",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {}
        ) {
            Text("Accion principal")
        }

        Spacer(modifier = Modifier.height(32.dp))

        ElevatedButton(
            onClick = {}
        ) {
            Text("Boton elevado")
        }

        Spacer(modifier = Modifier.height(32.dp))

        FilledTonalButton(
            onClick = {}
        ) {
            Text("Accion secundaria")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PantallaBotonesPreview() {
    Practica10Theme {
        com.example.myapplication.venanciob.practica10.PantallaBotones()
    }
}