package com.example.piano

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Teclas(generadorDeSonido: GeneradorDeSonido) {
    var set1 by remember { mutableStateOf(true) }

    val notasSet1 = listOf(
        Pair("1", R.raw.do2),
        Pair("2", R.raw.re),
        Pair("3", R.raw.mi),
        Pair("4", R.raw.fa),
        Pair("5", R.raw.sol),
        Pair("6", R.raw.la),
        Pair("7", R.raw.si)
    )

    val notasSet2 = listOf(
        Pair("1", R.raw.x1),
        Pair("2", R.raw.x2),
        Pair("3", R.raw.x3),
        Pair("4", R.raw.x4),
        Pair("5", R.raw.x5),
        Pair("6", R.raw.x6),
        Pair("7", R.raw.x7)
    )

    val notas = if (set1) notasSet1 else notasSet2

    val buttonColorsSet1 = Color.White
    val buttonColorsSet2 = listOf(Color.Red, Color(0xFFFFA500), Color.Yellow, Color.Green, Color.Blue, Color.Cyan, Color.Magenta)

    Row(
        modifier = Modifier
            .background(Color.Black)
            .padding(vertical = 50.dp)
    ) {
        Button(onClick = {

            set1 = !set1
            generadorDeSonido.cambiarSonidos()
        },
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            colors = buttonColors(containerColor = Color.Red)) {
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.Black),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            notas.forEachIndexed { index, (nota, soundResId) ->
                val buttonColor = if (set1) buttonColorsSet1 else buttonColorsSet2[index % buttonColorsSet2.size]
                Tecla(nota = nota, soundResId = soundResId, generadorDeSonido = generadorDeSonido, buttonColor = buttonColor)
            }
        }
    }
}

@Composable
fun Tecla(
    nota: String,
    generadorDeSonido: GeneradorDeSonido,
    soundResId: Int,
    buttonColor: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            generadorDeSonido.reproducirNota(nota)
        },
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(0),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
    ) {}
}
