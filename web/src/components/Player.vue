<script setup lang="ts">
import { ref, computed, onUpdated, watchEffect } from 'vue';
import { BButtonGroup, BButton } from 'bootstrap-vue-next'

interface Props {
  position: number;
  changeCards: number;
}

const { position, changeCards } = defineProps<Props>();

const emit = defineEmits<{
  (e: 'open'): void
}>()

const cards = ref(7);
const tempCards = ref(changeCards);

const toggleWord = computed(() => (cards.value === 1 ? 'carta' : 'cartas'));
const isDisabled = computed(() => cards.value === 0);

watchEffect(() => {
  if (changeCards !== 0) {
    cards.value = changeCards
  }
})
</script>

<template>
  <section class="d-flex justify-content-between mt-2">
    <BButtonGroup class="gap-2">
      <BButton variant="outline-warning" @click="emit('open')" :disabled="isDisabled">&#8645;</BButton>
      <BButton variant="outline-success" @click="cards--" :disabled="isDisabled">-1</BButton>
      <BButton variant="outline-danger" @click="cards++" :disabled="isDisabled">+1</BButton>
    </BButtonGroup>

    <p>Jugador {{ position }}: {{ cards }} {{ toggleWord }} </p>
    
    <BButtonGroup class="gap-2">
      <BButton variant="outline-danger" @click="cards += 2" :disabled="isDisabled">+2</BButton>
      <BButton variant="outline-danger" @click="cards += 4" :disabled="isDisabled">+4</BButton>
      <BButton variant="outline-secondary" @click="cards = 7" :disabled="!isDisabled">&#10227;</BButton>
    </BButtonGroup>
  </section>
</template>
