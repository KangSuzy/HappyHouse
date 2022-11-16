<template>
	<div>
		<h2>아파트 목록</h2>
		<input type="number" 
		class="px-4
			sm:px-6
			py-2
			sm:py-2.5
			rounded-md" 
		v-model="lawdCd"
		placeholder="지역코드"
		>
		<input type="number"
		class="px-4
			sm:px-6
			py-2
			sm:py-2.5
			rounded-md" 
		v-model="dealYmd"
		placeholder="계약월"
		>
		<button class="px-4
			sm:px-6
			py-2
			sm:py-2.5
			text-white
			bg-indigo-500
			hover:bg-indigo-600
			rounded-md
			focus:ring-1 focus:ring-indigo-900 duration-500" @click="getAptList">Search</button>
		<table border="1" id="table">
			<colgroup>
				<col style="width :10%" />
				<col style="width :30%" />
				<col style="width :20%" />
				<col style="width :10%" />
				<col style="width :30%" />
			</colgroup>
			<tr>
				<th>일련번호</th>
				<th>아파트명</th>
				<th>법정동</th>
				<th>층</th>
				<th>매매 가격</th>
			</tr>
			<tbody>
				<apt-list-item v-for="apt, index in apts" :key="index" :apt="apt"></apt-list-item>
			</tbody>
		</table>

	</div>
</template>

<script>
import feather from 'feather-icons';
import axios from "axios";
import AptListItem from '@/components/apt/AptListItem';

export default {
	name: 'Search',
	components: {
		AptListItem,
	},
	data: () => {
		return {
			lawdCd: "", //11110
			dealYmd: "", //202207
			apts: [],
		};
	},
	methods: {
		getAptList(){
			// const serviceKey = "tZ8UqExM5yQzKVia7zajh5llesd77DlvLy%2BZ0DMeLmjboacozRdWfK8blEuxSFEwBhoSDNvR4Hwgt0kmSvLRrw%3D%3D";
			// const url = `http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?serviceKey=${serviceKey}&pageNo=1&numOfRows=10&LAWD_CD=${this.lawdCd}&DEAL_YMD=${this.dealYmd}`;
			
			// 서버에서 ... rest 역할만 하는 vue api 를 켜라 . . . 
			const url = `http://localhost:9999/vue/map/aptlist/${this.lawdCd}/${this.dealYmd}`;
			axios.get(url).then((response) => (this.apts = response.data.response.body.items.item));
		},
	},
	mounted() {
		feather.replace();
	},
	updated() {
		feather.replace();
	},
};
</script>

<style scoped>
#table {
    font-family: Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#table td, #table th {
    border: 1px solid #ddd;
    padding: 8px;
}

#table tr:hover {background-color: rgb(198, 198, 234);}

#table th {
    padding-top: 12px;
    padding-bottom: 12px;
    background-color: rgb(147, 147, 151);
    color: white;
}
</style>
