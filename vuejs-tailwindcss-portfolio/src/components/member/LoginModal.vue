

<template>
	<transition name="fade">
		<div  id="login" v-show="modal" class="font-general-regular fixed inset-0 z-30">
			<!-- Modal body background as backdrop -->
			<div v-show="modal" @click="loginModal()"
				class="bg-filter bg-black bg-opacity-50 fixed inset-0 w-full h-full z-20"></div>
			<!-- Modal content -->
			<main class="flex flex-col items-center justify-center h-full w-full">
				<transition name="fade-up-down">
					<div v-show="modal" class="modal-wrapper flex items-center z-30">
						<div
							class="modal max-w-md mx-5 xl:max-w-xl lg:max-w-xl md:max-w-xl bg-secondary-light dark:bg-primary-dark max-h-screen shadow-lg flex-row rounded-lg relative">
							<div
								class="modal-header flex justify-between gap-10 p-5 border-b border-ternary-light dark:border-ternary-dark">
								<h5 class=" text-primary-dark dark:text-primary-light text-xl">
									Login
								</h5>
								<button class="px-4 text-primary-dark dark:text-primary-light" @click="loginModal()">
									<i data-feather="x"></i>
								</button>
							</div>
							<div class="modal-body p-5 w-full h-full">
								<form class="max-w-xl m-4 text-left">
									<div class="mt-0">
										<input
											class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-md text-md bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
											id="id" name="id" type="text" required="" placeholder="id" v-model="user.userid" @keyup.enter="confirm"
											aria-label="Name" />
									</div>

									<div class="mt-6">
										<input
											class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-md text-md bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
											id="password" name="password" type="password" required="" v-model="user.userpwd" @keyup.enter="confirm"
											placeholder="Password" aria-label="Password" />
									</div>

									<div class="mt-6 pb-4 sm:pb-1">
										<Button title="login" class="px-4
											sm:px-6
											py-2
											sm:py-2.5
											text-white
											bg-indigo-500
											hover:bg-indigo-600
											rounded-md
											focus:ring-1 focus:ring-indigo-900 duration-500"
											@click.prevent="confirm" aria-label="logIn" />
									</div>
								</form>
							</div>
							<div class="modal-footer mt-2 sm:mt-0 py-5 px-8 border0-t text-right">
								<Button title="Close" class=" px-4
									sm:px-6
									py-2 bg-gray-600 text-primary-light hover:bg-ternary-dark dark:bg-gray-200 dark:text-secondary-dark dark:hover:bg-primary-light
									rounded-md
									focus:ring-1 focus:ring-indigo-900 duration-500" @click="loginModal()" aria-label="Close Modal" />
							</div>
						</div>
					</div>
				</transition>
			</main>
		</div>
	</transition>
</template>


<script>
import { mapState, mapActions } from "vuex";
import feather from 'feather-icons';
import Button from '../reusable/Button.vue';
const memberStore = "memberStore";

export default {
  name: "UserLogin",
	props: ['loginModal','modal', 'categories'],
	components: { Button },
	mounted() {
		feather.replace();
	},
	updated() {
		feather.replace();
	},
  data() {
    return {
      // isLoginError: false,
      user: {
        userid: null,
        userpwd: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {

		


    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
			
      await this.userConfirm(this.user);
			
      let token = sessionStorage.getItem("access-token");
      // console.log("1. confirm() token >> " + token);
      if (this.isLogin) {
        await this.getUserInfo(token);
        // console.log("4. confirm() userInfo :: ", this.userInfo);
				

        this.$router.push({ name: "Home" });
				this.loginModal();
      }
    },
  },
};
</script>


<style scoped>

#login {
    
    width :600px;
    height : 1000px;

  }

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
