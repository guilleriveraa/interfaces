package com.example.myapplication.venanciob.practica11

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.venanciob.practica11.ui.theme.Practica11Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica11Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaMensajes(
                        mensajes = listaDeMensajes,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

data class Mensaje(
    val autor: String,
    val texto: String
)

val listaDeMensajes = listOf(
    Mensaje("Laura", "¿Qué tal ha ido la clase?"),
    Mensaje("Mario", "Ya terminé la práctica de Compose. También he añadido las imágenes y he completado todos los ejercicios."),
    Mensaje("Ana", "Mañana llevo el proyecto a primera hora para revisarlo juntos."),
    Mensaje("Pedro", "Nos vemos mañana en el laboratorio."),
    Mensaje("Sara", "He subido el ejercicio al repositorio del grupo.")
)

@Composable
fun TarjetaMensaje(
    mensaje: Mensaje,
    modifier: Modifier = Modifier
) {
    var expandido by remember { mutableStateOf(false) }

    val colorFondo by animateColorAsState(
        targetValue = if (expandido) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface,
        label = "colorMensaje"
    )

    Row(
        modifier = modifier.padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagen),
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.clickable { expandido = !expandido }
        ) {
            Text(
                text = mensaje.autor,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 2.dp,
                color = colorFondo,
                modifier = Modifier.animateContentSize()
            ) {
                Text(
                    text = mensaje.texto,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = if (expandido) Int.MAX_VALUE else 1,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

@Composable
fun PantallaMensajes(
    mensajes: List<Mensaje>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "MENSAJES INTERACTIVOS",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn {
            items(mensajes) { mensaje ->
                TarjetaMensaje(mensaje = mensaje)
            }
        }
    }
}

@Preview(showBackground = true, name = "Modo Claro")
@Composable
fun PreviewClaro() {
    Practica11Theme {
        PantallaMensajes(mensajes = listaDeMensajes)
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Modo Oscuro"
)
@Composable
fun PreviewOscuro() {
    Practica11Theme {
        PantallaMensajes(mensajes = listaDeMensajes)
    }
}