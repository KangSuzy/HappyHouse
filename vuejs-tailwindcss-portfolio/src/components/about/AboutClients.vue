<script>
// import AboutClientSingle from './AboutClientSingle.vue';

export default {
	components: {
		// AboutClientSingle,
	},
	data: () => {
		return {
			clientsHeading: 'About US',
			clients: [
				// {
				// 	id: 1,
				// 	title: 'ssafy',
				// 	img: require('@/assets/images/ssafy.png'),
				// },
				{
					id: 1,
					title: 'minsu&suzy',
					img: require('@/assets/images/profile_about.jpg'),
				},
			],
		};
	},
};
</script>

<template>
	<div class="mt-10 sm:mt-20">
		<p
			class="font-general-medium text-2xl sm:text-3xl text-primary-dark dark:text-primary-light"
		>
			{{ clientsHeading }}
		</p>
		<div class="grid grid-cols-1mt-10 sm:mt-14 gap-2" style="center">
			<!-- <AboutClientSingle
				v-for="client in clients"
				:key="client.id"
				:client="client"
			/> -->
			<img src="@/assets/images/profile_about.jpg"/>
		</div>

		<p
			class="font-general-medium text-2xl sm:text-2xl text-primary-dark dark:text-primary-light"
		>
		Seoul 19 MinSu & SooJi
		</p>

		<img src="@/assets/images/profile_about.jpg"/>

		<p
			class="font-general-medium text-2xl sm:text-2xl text-primary-dark dark:text-primary-light"
		>
		" 전국 1등 부동산 커뮤니티 " 언제 어디서든, 빠르고 쉬운 부동산 실거래가 검색가능 !
		국토교통부 아파트매매 실거래 데이터 사용으로 신뢰도 있는 정보 제공 !
		챗봇을 통해 24시간 궁금증 해결이 가능한 사이트 !
		</p>
	</div>
</template>

<style scoped>
	img{
		display: block; margin: 0px auto;
	}
</style>