<script>

import { defineComponent } from 'vue'
import { Carousel, Pagination, Slide } from 'vue3-carousel'

import 'vue3-carousel/dist/carousel.css'

export default defineComponent({
	components: {
	Carousel,
    Slide,
    Pagination,
	},

	data: ()=>{
		return{
			items : [
				{
					id: 1,
					img: require('@/assets/images/a1.jpg'),
				},
				{
					id: 2,
					img: require('@/assets/images/a2.jpg'),
				},
				{
					id: 3,
					img: require('@/assets/images/a3.jpg'),
				},
				{
					id: 4,
					img: require('@/assets/images/a4.jpg'),
				},
			]
		}
	}
})
</script>

<template>
	<Carousel :autoplay="3000" :wrap-around="true">

    <Slide v-for="item in items" :key="item.id" :item="item">
		<!-- <div class="carousel__item"> -->
		<img :src="item.img">
		<!-- </div> -->
    </Slide>

		<template #addons>
		<Pagination />
		<br>

		<!-- <img src="@/assets/images/a4.jpg"> -->

		<h4 style="color: green; font-weight: bold;"> " 전국 1등 부동산 커뮤니티 "</h4>
		<p> 언제 어디서든 부동산의 궁금증 해결이 가능한 사이트 !</p>
		</template>
	</Carousel>
</template>

<style scoped>
	/* img{
		display: block; margin: 0px auto;
	} */

	.carousel__item {
		min-height: 200px;
		width: 100%;
		background-color: var(--vc-clr-primary);
		color: var(--vc-clr-white);
		font-size: 20px;
		border-radius: 8px;
		display: flex;
		justify-content: center;
		align-items: center;
	}
</style>