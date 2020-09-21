<template>
  <div class="contact-box-main">
    <div class="container">
      <div class="row">
        <div class="col-lg-2 col-sm-12"></div>
        <div class="col-lg-8 col-sm-12">
          <div class="contact-form-right">
            <h2>Lets login</h2>
            <p>
              Please fill the form below and submit it.
            </p>

            <form id="loginForm" @submit.prevent="login">
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      id="username"
                      name="username"
                      placeholder="Please enter your username"
                      required
                      data-error="Please enter your username"
                      v-model="form.username"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>

                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="password"
                      class="form-control"
                      id="password"
                      name="password"
                      placeholder="Please enter your password"
                      required
                      data-error="Please enter your password"
                      v-model="form.password"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>

                <div class="col-md-12">
                  <div class="submit-button text-center">
                    <button class="btn hvr-hover" id="submit" type="submit">
                      Login
                    </button>
                    <div id="msgSubmit" class="h3 text-center hidden"></div>
                    <div class="clearfix"></div>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import authController from "@/auth/AuthController";

export default {
  data() {
    return {
      form: {
        username: undefined,
        password: undefined,
      },
      authController: authController
    };
  },
  mounted() {},

  methods: {
    login() {
      authController.loginUser(this.form)
        .then(() => {
          // console.log(getUserInfo())
          if (authController.isAdmin()) {
            this.$router.push({ name: "ApprovedUsers" });
          } else if (authController.isCustomer()) {
            this.$router.push({ name: "ListingActiveForCustomers" });
          } else if (authController.isHost()) {
            this.$router.push({ name: "ListingActiveForHost" });
          }
        })
        .catch((e => {
          console.log(e);
          alert("Invalid username or password");
        }));
    },
  },
};
</script>
