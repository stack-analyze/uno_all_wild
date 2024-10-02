<script setup lang="ts">
import { ref, reactive, computed } from 'vue';
import Player from '../components/Player.vue';
import {
  BModal, BFormSelect, BFormSelectOption, BFormInput,
  BRow, BCol
} from 'bootstrap-vue-next'
import type { Numberish } from 'node_modules/bootstrap-vue-next/dist/src/types/CommonTypes';

const playerList = [0, 2, 3, 4, 5, 6, 7, 8, 9, 10];

const state = reactive({
  playerSwapCards: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
})

const totalPlayers = ref(0);
const toggleModal = ref(false);

const positionA = ref(0);
const positionB = ref(0);

const swapCardsA = ref(0);
const swapCardsB = ref(0);

const playerA = computed(() => positionA.value + 1)
const playerB = computed(() => positionB.value + 1)

const openModal = () => {
  toggleModal.value = !toggleModal.value
}

const okModal = () => {
  state.playerSwapCards[positionA.value] = swapCardsB.value;
  state.playerSwapCards[positionB.value] = swapCardsA.value;

  console.info(state.playerSwapCards);

  positionA.value = 0;
  swapCardsA.value = 0;
  positionB.value = 0;
  swapCardsB.value = 0;

  toggleModal.value = !toggleModal.value
};

const cancelModal = () => {
  toggleModal.value = !toggleModal.value
}
</script>

<template>
  <section class="mx-2">
    <BFormSelect v-model="totalPlayers">
      <BFormSelectOption v-for="opt in playerList" :value="opt">
        {{ opt === 0 ? 'sin' : opt }} jugadores
      </BFormSelectOption>
    </BFormSelect>
  </section>

  <section class="mx-2">
    <Player 
      v-for="(player, i) in totalPlayers" 
      :position="player" 
      :changeCards="state.playerSwapCards[i]"
      @open="openModal" 
    />
  </section>

  <BModal 
    v-model="toggleModal" 
    centered 
    title="Cambio de cartas" 
    @hide.prevent 
    cancelTitle="Cancelar" 
    hide-header-close
    cancelVariant="outline-danger" 
    okVariant="outline-success" 
    @ok="okModal" 
    @cancel="cancelModal"
    :ok-disabled="positionB === positionA"
  >

    <BRow>
      <BCol cols="12">jugador {{ positionA + 1 }}</BCol>
      <BCol cols="6">
        <BFormInput type="number" min="0" :max="totalPlayers - 1" v-model.number="positionA" />
      </BCol cols="6">
      <BCol>
        <BFormInput 
          type="number" min="0" v-model.number="swapCardsA" 
        />
      </BCol>

      <BCol cols="12">
        <span class="subtitle">jugador {{ positionB + 1 }}</span>
      </BCol>
      <BCol cols="6">
        <BFormInput 
          type="number" 
          min="0" 
          :max="totalPlayers - 1" 
          v-model.number="positionB" 
        />
      </BCol>
      <BCol cols="6">
        <BFormInput 
          type="number" min="0" v-model.number="swapCardsB" 
        />
      </BCol>
    </BRow>


    <p class="has-text-danger" v-show="positionB === positionA">el intercambio no es valido para el mismo jugador</p>
  </BModal>
</template>