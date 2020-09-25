<template>
  <!-- Start Main Top -->
  <div class="main-top">
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
          <div class="text-slid-box">
            <div id="offer-box">
              <ul class="offer-box">
                <li>
                  <i class="fas fa-plane-departure"></i>Welcome to Golden
                  Travels
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
          <!--<input type="text" class="form-control" placeholder="Search" /> -->
        </div>
        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
          <div class="custom-select-box"></div>
          
          <div class="our-link">
            <ul>
              <li v-if="showAccountOption()">
                <router-link :to="{ path: '/account' }">My Account</router-link>
              </li>
              <li v-if="showRegisterOption()">
                <router-link :to="{ path: '/register' }">Register</router-link>
              </li>
              <li v-if="showRegisterOption()">
                <router-link :to="{ path: '/login' }">Login</router-link>
              </li>

              <li v-if="showLogoutOption()" @click="logout">
                <a href="#">Logout</a>
              </li>

              <li><a href="#">Our location</a></li>
              <li><a href="#">Contact Us</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- End Main Top -->
</template>

<script>
import authController from "@/auth/AuthController";

export default {
  data() {
    return {
      authController:authController
    }
  },
  methods: {
    showLogoutOption() {
      return authController.isLoggedIn() == true;
    },
    showAccountOption() {
      return authController.isLoggedIn() == true;
    },
    showRegisterOption() {
      return authController.isLoggedIn() == false;
    },
    logout() {
      authController.logoutUser();
      this.$router.push({name: "Login"});
    }
  }
}
</script>