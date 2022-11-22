<script>
import {mapActions } from "vuex";
import feather from 'feather-icons';
import Button from '../reusable/Button.vue';
const memberStore = "memberStore";
export default {
	props: ['registModal','modal1', 'categories'],
	components: { Button },
	data() {
		return {
			user: {
				userid: null,
				username:null,
				userpwd: null,
				useremail: null
			},


		};
	},
	mounted() {
		feather.replace();
	},
	updated() {
		feather.replace();
	},
	methods: {

		...mapActions(memberStore, ["joinUser"]),

		async submit() {
			console.log(this.user.userid+" "+this.user.username+" "+this.user.userpwd+" "+this.user.useremail+" ");
			await this.joinUser(this.user);
			this.$router.push({ name: "Home" });
			this.registModal();
		}
	}
};
</script>


<template>
	<transition name="fade">
		<div v-show="modal1" class="font-general-regular fixed inset-0 z-30">
			<!-- Modal body background as backdrop -->
			<div v-show="modal1" @click="registModal()"
				class="bg-filter bg-black bg-opacity-50 fixed inset-0 w-full h-full z-20"></div>
			<!-- Modal content -->
			<main class="flex flex-col items-center justify-center h-full w-full">
				<transition name="fade-up-down">
					<div v-show="modal1" class="modal-wrapper flex items-center z-30">
						<div
							class="modal max-w-md mx-5 xl:max-w-xl lg:max-w-xl md:max-w-xl bg-secondary-light dark:bg-primary-dark max-h-screen shadow-lg flex-row rounded-lg relative">
							<div
								class="modal-header flex justify-between gap-10 p-5 border-b border-ternary-light dark:border-ternary-dark">
								<h5 class=" text-primary-dark dark:text-primary-light text-xl">
									Sign in
								</h5>
								<button class="px-4 text-primary-dark dark:text-primary-light" @click="registModal()">
									<i data-feather="x"></i>
								</button>
							</div>
							<div class="modal-body p-5 w-full h-full">
								<form class="max-w-xl m-4 text-left">
									<div class="mt-0">
										<input
											class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-md text-md bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
											id="id" name="id" type="text" v-model="user.userid" required="text" placeholder="ID" aria-label="Name" />
									</div>
									<div class="mt-6">
										<input
											class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-md text-md bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
											id="name" name="name" type="text" v-model="user.username" required="text" placeholder="Name" aria-label="Name" />
									</div>
									<div class="mt-6">
										<input
											class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-md text-md bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
											id="email" name="email" type="email" v-model="user.useremail" required="email" placeholder="Email" aria-label="Email" />
									</div>

									<div class="mt-6">
										<input
											class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-md text-md bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
											id="password" name="password" type="password" v-model="user.userpwd" required="password" placeholder="Password"
											aria-label="Password" />
									</div>

									<div class="mt-6 pb-4 sm:pb-1">
										<Button title="SignIn" class="px-4
											sm:px-6
											py-2
											sm:py-2.5
											text-white
											bg-indigo-500
											hover:bg-indigo-600
											rounded-md
											focus:ring-1 focus:ring-indigo-900 duration-500" @click.prevent="submit" aria-label="SignIn" />
									</div>
								</form>
							</div>
							<div class="modal-footer mt-2 sm:mt-0 py-5 px-8 border0-t text-right">
								<Button title="Close" class=" px-4
									sm:px-6
									py-2 bg-gray-600 text-primary-light hover:bg-ternary-dark dark:bg-gray-200 dark:text-secondary-dark dark:hover:bg-primary-light
									rounded-md
									focus:ring-1 focus:ring-indigo-900 duration-500" @click="registModal()" aria-label="Close Modal" />
							</div>
						</div>
					</div>
				</transition>
			</main>
		</div>
	</transition>
</template>

<style scoped>
.modal-body {
	max-height: 500px;
}

.bg-gray-800-opacity {
	background-color: #2d374850;
}

@media screen and (max-width: 768px) {
	.modal-body {
		max-height: 400px;
	}
}

.fade-up-down-enter-active {
	transition: all 0.3s ease;
}

.fade-up-down-leave-active {
	transition: all 0.3s ease;
}

.fade-up-down-enter {
	transform: translateY(10%);
	opacity: 0;
}

.fade-up-down-leave-to {
	transform: translateY(10%);
	opacity: 0;
}

.fade-enter-active {
	-webkit-transition: opacity 2s;
	transition: opacity 0.3s;
}

.fade-leave-active {
	transition: opacity 0.3s;
}

.fade-enter,
.fade-leave-to {
	opacity: 0;
}
</style>
