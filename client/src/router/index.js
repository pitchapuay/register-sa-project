import Vue from 'vue'
import Router from 'vue-router';
import Register from '../components/Register';
import ViewRegister from '../components/ViewRegister';

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            component: Register
        },
        {
            path: '/viewreg',
            component: ViewRegister
        }
    ]
});