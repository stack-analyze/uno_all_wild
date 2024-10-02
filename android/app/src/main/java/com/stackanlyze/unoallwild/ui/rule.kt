package com.stackanlyze.unoallwild.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.stackanlyze.unoallwild.R.drawable.comodin_multicolor
import com.stackanlyze.unoallwild.R.drawable.comodin_reversa
import com.stackanlyze.unoallwild.R.drawable.comodin_salta
import com.stackanlyze.unoallwild.R.drawable.comodin_toma2
import com.stackanlyze.unoallwild.R.drawable.comodin_toma4
import com.stackanlyze.unoallwild.R.drawable.comodin_salta2
import com.stackanlyze.unoallwild.R.drawable.comodin_elige_toma2
import com.stackanlyze.unoallwild.R.drawable.comodin_intercambio

data class Rule(
    val name: String,
    val desc: String,
    val image: (@Composable () -> Unit)? = null,
)

val rules = listOf(
    Rule(
        name = "decir uno",
        desc = "si te queda una carta debe decir ¡UNO! o de lo contrario recibes dos cartas como castigo.",
    ),
    Rule(
        name = "como ganar",
        desc = "la unica forma de ganar es deshacer todas las cartas.",
    ),
    Rule(
        name = "comodín multicolor",
        desc = "para este uno se usa para descarta de su mano \"es opcional decir el color\".",
    ) {
        Image(
            painter = painterResource(id = comodin_multicolor),
            contentDescription = "card",
            modifier = Modifier.size(80.dp)
        )
    },
    Rule(
        name = "comodín reversa",
        desc = """
        en esta carta tiene dos condiciones:
            1): si estas en una partida de 2 jugadores actua como una carta salta.
            2): cambia la dirección del juego.
        """.trimIndent(),
    ) {
        Image(
            painter = painterResource(id = comodin_reversa),
            contentDescription = "card",
            modifier = Modifier.size(80.dp)
        )
    },
    Rule(
        name = "comodín salta",
        desc = "el siguiente jugador pierde el turno.",
    ) {
        Image(
            painter = painterResource(id = comodin_salta),
            contentDescription = "card",
            modifier = Modifier.size(80.dp)
        )
    },
    Rule(
        name = "comodín salta dos",
        desc = "los siguientes 2 jugadores pierde su turno.",
    ) {
        Image(
            painter = painterResource(id = comodin_salta2),
            contentDescription = "card",
            modifier = Modifier.size(80.dp)
        )
    },
    Rule(
        name = "comodín toma 2",
        desc = "toma dos cartas y pierde el turno.",
    ) {
        Image(
            painter = painterResource(id = comodin_toma2),
            contentDescription = "card",
            modifier = Modifier.size(80.dp)
        )
    },
    Rule(
        name = "comodín toma 4",
        desc = "toma cuatro cartas y pierde el turno.",
    ) {
        Image(
            painter = painterResource(id = comodin_toma4),
            contentDescription = "card",
            modifier = Modifier.size(80.dp)
        )
    },
    Rule(
        name = "comodín elige y toma 2",
        desc = "eliges un jugador aleatorio para dos cartas \"no pierdes turno\".",
    ) {
        Image(
            painter = painterResource(id = comodin_elige_toma2),
            contentDescription = "card",
            modifier = Modifier.size(80.dp)
        )
    },
    Rule(
        name = "comodín intercambio obligatorio",
        desc = "eliges un jugador al azar para cambiar sus cartas.",
    ) {
        Image(
            painter = painterResource(id = comodin_intercambio),
            contentDescription = "card",
            modifier = Modifier.size(80.dp)
        )
    },
)
