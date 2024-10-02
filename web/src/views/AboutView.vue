<script setup lang="ts">
import { BCard, BCardFooter } from 'bootstrap-vue-next';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
</script>

<template>
  <BCard 
    title="UNO all wild"
    title-tag="h2" 
    subtitle="desarrollado por omega5300" 
    subtitle-tag="p"
    img-src="/img/all_wild.svg" 
    img-alt="logo" 
    class="about mx-auto"
  >
    <BCardFooter>
      <a href="https://github.com/stack-analyze/uno_all_wild" class="card-link" target="_blank">
        <font-awesome-icon class="mr-2" icon="fa-brands fa-github" />
        Github repo
      </a>

      <a href="https://stackshare.io/stack-analyze/uno-all-wild" class="card-link" target="_blank">
        <font-awesome-icon class="mr-2" icon="fa-solid fa-square-share-nodes" />
        tech stack
      </a>
    </BCardFooter>
  </BCard>
</template>

<style scoped>
.about {
  max-width: 50%;
}
</style>
