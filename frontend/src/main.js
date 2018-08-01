// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import VueRouter from 'vue-router';
import iView from 'iview';
import App from './app';
import routers from './routers';
import request from './utils/request';
import i18n from './utils/i18n';
import 'iview/dist/styles/iview.css';

Vue.config.productionTip = false;
Vue.use(VueRouter);
Vue.use(iView);

Vue.prototype.$http = request;

const router = new VueRouter({
  mode: 'history',
  routes: routers
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  i18n,
  render: h => h(App)
});
