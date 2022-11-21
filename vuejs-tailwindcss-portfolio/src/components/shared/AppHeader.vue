<script>
import ThemeSwitcher from '../ThemeSwitcher';
import RegistModal from '../member/RegistModal.vue';
import LoginModal from '../member/LoginModal.vue';
import feather from 'feather-icons';
import AppHeaderLinks from './AppHeaderLinks.vue';
import Button from '../reusable/Button.vue';
import { mapState, mapGetters, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
	
	components: {
		ThemeSwitcher,
		RegistModal,
		LoginModal,
		AppHeaderLinks,
		Button,
	},
	data() {
		return {
			isOpen: false,
			theme: '',
			modal: false,
			modal1:false,
		};
	},
	computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
	created() {
		this.theme = localStorage.getItem('theme') || 'light';
	},
	mounted() {
		feather.replace();
		this.theme = localStorage.getItem('theme') || 'light';
	},
	methods: {

		...mapActions(memberStore, ["userLogout"]),

		onClickLogout() {
      // this.SET_IS_LOGIN(false);
      // this.SET_USER_INFO(null);
      // sessionStorage.removeItem("access-token");
      // if (this.$route.path != "/") this.$router.push({ name: "main" });
      console.log(this.userInfo.userid);
      //vuex actions에서 userLogout 실행(Backend에 저장 된 리프레시 토큰 없애기
      //+ satate에 isLogin, userInfo 정보 변경)
      // this.$store.dispatch("userLogout", this.userInfo.userid);
      this.userLogout(this.userInfo.userid);
      sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
      sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기
      if (this.$route.path != "/") this.$router.push({ name: "Home" });
    },
		updateTheme(theme) {
			this.theme = theme;
		},
		registModal() {
			console.log("회원가입 누르기전"+this.modal1);
			if (this.modal1) {
				// Stop screen scrolling
				document
					.getElementsByTagName('html')[0]
					.classList.remove('overflow-y-hidden');
				this.modal1 = false;
				
			} else {
				document
					.getElementsByTagName('html')[0]
					.classList.add('overflow-y-hidden');
				this.modal1 = true;
			}
			console.log("회원가입 누름"+this.modal1);
		},
		loginModal() {
			console.log("로그인 누르기전"+this.modal);
			if (this.modal) {
				// Stop screen scrolling
				document
					.getElementsByTagName('html')[0]
					.classList.remove('overflow-y-hidden');
				this.modal = false;
			} else {
				document
					.getElementsByTagName('html')[0]
					.classList.add('overflow-y-hidden');
				this.modal = true;
			}
			console.log("로그인 누름"+this.modal);
		}
	},
	updated() {
		feather.replace();
	},
};
</script>

<template>
	<nav id="nav" class="sm:container sm:mx-auto">
		<!-- Header start -->
		<div class="z-10 max-w-screen-lg xl:max-w-screen-xl block sm:flex sm:justify-between sm:items-center my-6">
			<!-- Header menu links and small screen hamburger menu -->
			<div class="flex justify-between items-center px-4 sm:px-0">
				<!-- Header logos -->
				<div>
					<router-link to="/"><img v-if="theme === 'light'" src="@/assets/images/Homelogo2.png" class="w-36"
							alt="Dark Logo" />
						<img v-else src="@/assets/images/Homelogo2.png" class="w-36" alt="Light Logo" />
					</router-link>
				</div>

				<!-- Theme switcher small screen -->
				<theme-switcher :theme="theme" @themeChanged="updateTheme"
					class="block sm:hidden bg-ternary-light dark:bg-ternary-dark hover:bg-hover-light dark:hover:bg-hover-dark hover:shadow-sm px-2.5 py-2 rounded-lg" />

				<!-- Small screen hamburger menu -->
				<div class="sm:hidden">
					<button @click="isOpen = !isOpen" type="button" class="focus:outline-none" aria-label="Hamburger Menu">
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
							class="h-7 w-7 fill-current text-secondary-dark dark:text-ternary-light">
							<path v-if="isOpen" fill-rule="evenodd"
								d="M18.278 16.864a1 1 0 0 1-1.414 1.414l-4.829-4.828-4.828 4.828a1 1 0 0 1-1.414-1.414l4.828-4.829-4.828-4.828a1 1 0 0 1 1.414-1.414l4.829 4.828 4.828-4.828a1 1 0 1 1 1.414 1.414l-4.828 4.829 4.828 4.828z"
								clip-rule="evenodd"></path>
							<path v-if="!isOpen" fill-rule="evenodd"
								d="M4 5h16a1 1 0 0 1 0 2H4a1 1 0 1 1 0-2zm0 6h16a1 1 0 0 1 0 2H4a1 1 0 0 1 0-2zm0 6h16a1 1 0 0 1 0 2H4a1 1 0 0 1 0-2z">
							</path>
						</svg>
					</button>
				</div>
			</div>

			<!-- Header links -->
			<AppHeaderLinks :registModal="registModal" :loginModal="loginModal" :isOpen="isOpen" />

			<div class="hidden sm:flex justify-between items-center flex-col md:flex-row" v-if="userInfo">
			<!-- Sign In button -->
			<div class="hidden md:block">
					
            <b-avatar variant="primary" v-text="userInfo.userid.charAt(0).toUpperCase()"></b-avatar>
             {{ userInfo.username }}({{ userInfo.userid }})님 환영합니다. 
          
					<Button title="Logout"
						class="text-md font-general-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-md px-5 py-2.5 duration-300 "
						@click.prevent="onClickLogout" aria-label="Log In Button" />
					<Button title="My page"
						class="text-md font-general-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-md px-5 py-2.5 duration-300"
						@click="registModal()" aria-label="Sign In Button" />
			
			</div>

				<!-- Theme switcher large screen -->
				<theme-switcher :theme="theme" @themeChanged="updateTheme"
					class="ml-8 bg-primary-light dark:bg-ternary-dark px-3 py-2 shadow-sm rounded-xl cursor-pointer" />
			</div>
			<div class="hidden sm:flex justify-between items-center flex-col md:flex-row" v-else>
				<!-- Sign In button -->
				<div class="hidden md:block">
					<Button title="LogIn"
						class="text-md font-general-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-md px-5 py-2.5 duration-300 "
						@click="loginModal()" :modal="modal" aria-label="Log In Button" />
					<Button title="Sign In"
						class="text-md font-general-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-md px-5 py-2.5 duration-300"
						@click="registModal()" aria-label="Sign In Button" />
				</div>

				<!-- Theme switcher large screen -->
				<theme-switcher :theme="theme" @themeChanged="updateTheme"
					class="ml-8 bg-primary-light dark:bg-ternary-dark px-3 py-2 shadow-sm rounded-xl cursor-pointer" />
				
			</div>
		</div>

		<!-- Hire me modal -->
		<RegistModal :registModal="registModal" :modal1="modal1" :categories="categories" aria-modal="Regist Modal" />
		<LoginModal :loginModal="loginModal" :modal="modal" :categories="categories" aria-modal="Login Modal" />
	</nav>
</template>
<style scoped>
#nav a.router-link-exact-active {
    @apply text-indigo-700;
    @apply dark:text-indigo-400;
    @apply font-medium;
}
</style>