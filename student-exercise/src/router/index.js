import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home'
import MyBooks from '@/views/MyBooks'
import NewBook from '@/views/NewBook'

Vue.use(VueRouter);

const routes = [
  { 
  path: '/',
  name: "home",
  component: Home
  },
  {
    path: '/myBooks',
    name: 'my-books',
    component: MyBooks
  },
  {
    path: '/addBook',
    name: 'new-book',
    component: NewBook
  }
];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
