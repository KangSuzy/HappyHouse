<template>
  <b-row
    class="m-2"
    @click="selectHouse"
    @mouseover="colorChange(true)"
    @mouseout="colorChange(false)"
    :class="{ 'mouse-over-bgcolor': isColor }"
  >
    <b-col cols="2" class="text-center align-self-center">
      <b-img
        thumbnail
        src="data:image/png;base64,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"
        alt="Image 1"
      ></b-img>
    </b-col>
    <b-col cols="10" class="align-self-center"> [{{ house.일련번호 }}] {{ house.아파트 }} </b-col>
  </b-row>
</template>

<script>
import { mapActions } from "vuex";

const houseStore = "houseStore";

export default {
  name: "HouseListItem",
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    house: Object,
  },
  methods: {
    ...mapActions(houseStore, ["detailHouse"]),
    selectHouse() {
      // console.log("listRow : ", this.house);
      // this.$store.dispatch("getHouse", this.house);
      this.detailHouse(this.house);
    },
    colorChange(flag) {
      this.isColor = flag;
    },
  },
};
</script>

<style scoped>
.apt {
  width: 50px;
}
.mouse-over-bgcolor {
  background-color: lightblue;
}
</style>
