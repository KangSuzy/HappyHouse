<script>
export default {
  name: "Board",
};
</script>
<style scoped>
  .underline-color {
    display: inline-block;
    background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%, rgba(62, 106, 250, 0.3) 30%);
  }
</style>

<template>
	<div>
    <h1 class="container mx-auto">Board</h1>
    
    <router-view></router-view>
  </div>
</template>

<style scoped></style>
