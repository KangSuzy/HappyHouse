<template>
  <b-container class="bv-example-row mt-3 text-center">
    <h1> House Search</h1>
    <b-row>
      <b-col>
        <b-img alt="Happy House" :src="require('@/assets/images/apt.png')" />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <house-search-bar></house-search-bar>
      </b-col>
    </b-row>
    <b-row>
      <b-col cols="6" align="left">
        <house-list />
      </b-col>
      <b-col cols="6">
        <house-detail></house-detail>
      </b-col>
    </b-row>
  </b-container>
</template>
<script>
import HouseSearchBar from "@/components/house/HouseSearchBar.vue";
import HouseList from "@/components/house/HouseList.vue";
import HouseDetail from "@/components/house/HouseDetail.vue";

export default {
  name: "AppHouse",
  components: {
    HouseSearchBar,
    HouseList,
    HouseDetail,
  },
};
</script>
<style scoped>
</style>
