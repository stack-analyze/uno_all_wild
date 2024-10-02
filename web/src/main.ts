import { createApp } from 'vue'

import { library } from '@fortawesome/fontawesome-svg-core'
import { faGithub } from '@fortawesome/free-brands-svg-icons'
import { faSquareShareNodes } from '@fortawesome/free-solid-svg-icons'
import { createBootstrap } from 'bootstrap-vue-next'

import App from './App.vue'
import router from './router'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-next/dist/bootstrap-vue-next.css'

library.add(faGithub, faSquareShareNodes)

const rootElement = document.documentElement
const isDarkmode = matchMedia('(prefers-color-scheme: dark)')

isDarkmode.addEventListener('change', () => {
  rootElement.dataset.bsTheme = isDarkmode.matches ? 'dark' : 'light'
})

rootElement.dataset.bsTheme = isDarkmode.matches ? 'dark' : 'light'

const app = createApp(App)

app
  .use(createBootstrap())
  .use(router)
  .mount('body')

