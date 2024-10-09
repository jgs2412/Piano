package com.example.piano

import android.content.Context
import android.media.MediaPlayer

class GeneradorDeSonido(private val context: Context) {
    private var set1 = true
    private var mediaPlayer: MediaPlayer? = null

    fun reproducirNota(nota: String) {
        val soundResId = if (set1) {
            when (nota) {
                "1" -> R.raw.do2
                "2" -> R.raw.re
                "3" -> R.raw.mi
                "4" -> R.raw.fa
                "5" -> R.raw.sol
                "6" -> R.raw.la
                "7" -> R.raw.si
                else -> 0
            }
        } else {
            when (nota) {
                "1" -> R.raw.x1
                "2" -> R.raw.x2
                "3" -> R.raw.x3
                "4" -> R.raw.x4
                "5" -> R.raw.x5
                "6" -> R.raw.x6
                "7" -> R.raw.x7
                else -> 0
            }
        }

        if (soundResId != 0) {
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(context, soundResId)
            mediaPlayer?.start()
        }
    }

    fun cambiarSonidos() {
        set1 = !set1
    }
}
