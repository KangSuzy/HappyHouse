<template>
  <div>
    <div id="map"></div>
  </div>
</template>

<script>
import { mapState } from "vuex";

const houseStore = "houseStore";

export default {
  name: "KakaoMap",
  data() {
    return {
      map: null,
      marker: null,
    };
  },
  watch: {
    house(val) {
      if (val) {
        this.detailMap();
      }
    },
  },

  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = process.env.VUE_APP_KAKAOMAP_URL;
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      let latLng = new kakao.maps.LatLng(37.5013068, 127.0396597);
      const container = document.getElementById("map");
      const options = {
        center: latLng,
        level: 5,
      };

      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);
    },
    detailMap() {
      var map = this.map;
      // 주소-좌표 변환 객체를 생성합니다
      var geocoder = new kakao.maps.services.Geocoder();

      let address = `${this.house.법정동} ${this.house.법정동본번코드}-${this.house.법정동부번코드}`;
      // 주소로 좌표를 검색합니다
      geocoder.addressSearch(address, function (result, status) {
        // 정상적으로 검색이 완료됐으면
        if (status === kakao.maps.services.Status.OK) {
          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
          // 결과값으로 받은 위치를 마커로 표시합니다
          var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
          });

          // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
          map.setCenter(coords);
          marker.setMap(map);
        }
      });
    },
  },
  computed: {
    ...mapState(houseStore, ["house", "houses"]),
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#map {
  width: 620px;
  height: 550px;
}

/* .button-group {
  margin: 10px 0px;
}

button {
  margin: 0 3px;
} */
</style>
