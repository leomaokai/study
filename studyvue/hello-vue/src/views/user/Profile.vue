<template>
  <div>
    <h1>个人信息</h1>
    {{id}}
  </div>
</template>

<script>
export default {
  props:['id'],
  name: "UserProfile",
  beforeRouteEnter:(to,from,next)=>{
    console.log("进入路由之前");
    next();
  },
  beforeRouteLeave:(to,from,next)=>{
    console.log("进入路由之后");
    next();
  }
}
</script>

<style scoped>

</style>
