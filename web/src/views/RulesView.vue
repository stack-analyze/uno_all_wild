<script setup lang="ts">
import Rule from '@/components/Rule.vue'

interface Rule {
  title: string;
  desc: string;
  card?: string;
}

const rules: Rule[] = [
  {
    title: 'decir uno',
    desc: 'si te queda una carta debe decir ¡UNO! o de lo contrario recibes dos cartas como castigo.',
  },
  {
    title: 'como ganar',
    desc: 'la unica forma de ganar es deshacer todas las cartas',
  },
  {
    title: 'comodín multicolor',
    desc: 'para este uno se usa para descarta de su mano es opcional decir el color.',
    card: '/img/comodin_multicolor.webp',
  },
  {
    title: 'comodín reversa',
    desc: `en esta carta tiene dos condiciones:
      condición 1: si estas en una partida de 2 jugadores actua como una carta. 
      condición 2: cambia la dirección del juego.
    `,
    card: '/img/comodin_reversa.webp',
  },
  {
    title: 'comodín salta',
    desc: 'el siguiente jugador pierde el turno',
    card: '/img/comodin_salta.webp',
  },
  {
    title: 'comodín salta dos',
    desc: 'los siguientes dos jugadores pierde su turno',
    card: '/img/comodin_salta2.webp',
  },
  {
    title: 'comodín toma 2',
    desc: 'toma dos cartas y pierde el turno',
    card: '/img/comodin_toma2.webp',
  },
  {
    title: 'comodín toma 4',
    desc: 'toma cuatro cartas y pierde el turno',
    card: '/img/comodin_toma4.webp',
  },
  {
    title: 'comodín elige y toma 2',
    desc: 'eliges un jugador aleatorio para dos cartas "no pierdes turno"',
    card: '/img/comodin_elige_toma2.webp',
  },
  {
    title: 'comodín intercambio obligatorio',
    desc: 'eliges un jugador al azar para cambiar sus cartas',
    card: '/img/comodin_intercambio.webp',
  },
];
</script>

<template>
  <main class="container-fluid vh-75 overflow-auto">
    <Rule v-for="({ desc, title, card }) of rules" :title :desc :card />
  </main>
</template>
