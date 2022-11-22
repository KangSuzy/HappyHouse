<template>
  <b-container class="bv-example-row mt-3">
    <b-row class="mb-1">
      <b-col class="text-right">
        <b-button variant="outline-primary" @click="moveWrite()">Post</b-button>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-table striped hover :items="articles" :fields="fields" @row-clicked="viewArticle">
          <template #cell(subject)="data">
            <router-link :to="{ name: 'boardview', params: { articleno: data.item.articleno } }">
              {{ data.item.subject }}
            </router-link>
          </template>
        </b-table>
        <!-- <table class="table">
          <t-body>
            <tr v-for="(item, index) in articles" :key="index">
              <td>{{ item.articleno }}</td>
              <td>{{ item.subject }}</td>
              <td>{{ item.userid }}</td>
              <td>{{ item.regtime }}</td>
            </tr>
          </t-body>
        </table> -->

        <b-pagination
          v-model="currentPage"
          :per-page="5"
          :total-rows="totalPage"
          align="center"
        ></b-pagination>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
//import http from "@/api/http";
import { listArticle, getTotalCount } from "@/api/board";

export default {
  name: "BoardList",
  created() {
    let param = {
      pg: this.currentPage,
      spp: 5,
      key: null,
      word: null,
    };

    listArticle(
      param,
      ({ data }) => {
        //console.log(data);
        this.articles = data;
        // this.totalPage = data.length;
      },
      (error) => {
        alert(error);
      }
    );

    getTotalCount(
      param,
      ({ data }) => {
        //console.log(data);
        this.totalPage = data;
        // this.totalPage = data.length;
      },
      (error) => {
        alert(error);
      }
    );
    // http.get(`/board`).then(({ data }) => {
    //   this.articles = data;
    //   this.pageCount = (this.articles.length % 5) - 1; // ?
    // });
  },
  data() {
    return {
      currentPage: 1,
      totalPage: 0,
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

  watch: {
    currentPage: {
      deep: true,
      handler() {
        //alert(this.currentPage + "가 선택되었습니다.");
        let param = {
          pg: this.currentPage,
          spp: 5,
          key: null,
          word: null,
        };
        listArticle(
          param,
          ({ data }) => {
            //console.log(data);
            this.articles = data;
          },
          (error) => {
            alert(error);
          }
        );
      },
    },
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
a {
  text-decoration: none;
}

.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
</style>
