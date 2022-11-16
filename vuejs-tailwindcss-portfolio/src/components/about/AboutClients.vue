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
	</div>
</template>

<style scoped>
	img{
		display: block; margin: 0px auto;
	}
</style>