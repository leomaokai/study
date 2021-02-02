import Vue from 'vue'
import App from './App'

//导入上面创建的路由配置目录
import router from './router'
//关闭生产模式下给出的提示
Vue.config.productionTip = false;

new Vue({
  el: '#app',
  //配置路由
  router,
  components: { App },
  template: '<App/>'
})
