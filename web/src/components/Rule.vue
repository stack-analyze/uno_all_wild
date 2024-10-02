<script lang="ts" setup>
import { BCard, BCardImg, BCardSubtitle, BCardTitle } from 'bootstrap-vue-next';

defineProps<{
  title: string;
  desc: string;
  card?: string;
}>()
</script>

<template>
  <BCard body-class="d-flex flex-row gap-2 align-items-center">
    <BCardImg :src="card" class="uno-card" v-show="card" />
    <section>
      <BCardTitle tag="h2">{{ title }}</BCardTitle>
      <BCardSubtitle class="pre-text" tag="p">
        {{ desc }}
      </BCardSubtitle>
    </section>
  </BCard>
</template>

<style scoped>
.uno-card {
  max-width: 5%;
  display: block;
}

.pre-text {
  white-space: pre;
}
</style>