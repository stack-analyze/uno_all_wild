<script setup lang="ts">
import {
  BNavbar,
  BNavbarBrand,
  BNavbarToggle,
  BCollapse,
  BNavbarNav,
  BNavItem
} from 'bootstrap-vue-next'

interface Link {
  name: string;
  to: string;
}

const links: Link[] = [
  { name: 'Reglas', to: '/' },
  { name: 'Contador', to: '/counter' },
  { name: 'Acerca de', to: '/about' },
]
</script>

<template>
  <BNavbar toggleable="lg">
    <BNavbarBrand tag="h1" class="m-0">uno all wild</BNavbarBrand>
    <BNavbarToggle target="nav-collapse" />
    <BCollapse id="nav-collapse" is-nav>
      <BNavbarNav>
        <BNavItem v-for="({ name, to }) of links" :to>
          {{ name }}
        </BNavItem>
      </BNavbarNav>
    </BCollapse>
  </BNavbar>

  <router-view />
</template>
