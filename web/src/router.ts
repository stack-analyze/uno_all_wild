import { 
    createWebHistory, 
    createRouter, 
    type RouteRecordRaw 
} from 'vue-router'

const routes: RouteRecordRaw[] = [
    {
        path: '/',
        component: () => import('@/views/RulesView.vue')
    },
    {
        path: '/counter',
        component: () => import('@/views/CounterView.vue')
    },
    {
        path: '/about',
        component: () => import('@/views/AboutView.vue')
    },
]

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
})

export default router
