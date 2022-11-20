<template>
  <b-container class="bv-example-row mt-3">
    <b-row class="mb-1">
      <b-col class="text-right">
        <b-button variant="outline-primary" @click="moveWrite()">Post</b-button>
      </b-col>
    </b-row>
    <b-row>

      <!-- 페이징 처리 하자 . . . -->
      <b-col>
        <b-table id="itemlist" striped hover 
        :items="articles" 
        :fields="fields"
        :per-page="perPage"
        :current-page="currentPage" 
        @row-clicked="viewArticle">
          <template #cell(subject)="data">
            <router-link :to="{ name: 'boardview', params: { articleno: data.item.articleno } }">
              {{ data.item.subject }}
            </router-link>
          </template>
        </b-table>

        <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        align = "center"
        aria-controls="itemlist">
        </b-pagination>

      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/api/http";

export default {
  name: "BoardList",
  created() {
    http.get(`/board`).then(({ data }) => {
      this.articles = data;
    });
  },
  data() {
    return {
      perPage: 5, // 보여줄 페이지
      currentPage: 1, // 현재 페이지
      articles: [],
      fields: [
        { key: "articleno", label: "글번호", tdClass: "tdClass" },
        { key: "subject", label: "제목", tdClass: "tdSubject" },
        { key: "userid", label: "작성자", tdClass: "tdClass" },
        { key: "regtime", label: "작성일", tdClass: "tdClass" },
        { key: "hit", label: "조회수", tdClass: "tdClass" },
      ],
    };
  },
  methods: {
    moveWrite() {
      this.$router.push({ name: "boardwrite" });
    },
    viewArticle(article) {
      this.$router.push({
        name: "boardview",
        params: { articleno: article.articleno },
      });
    },
  },
  computed:{
    rows(){
          return this.articles.length;
      }
  },
};
</script>

<style scope>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}
a{
	text-decoration: none;
}
</style>
