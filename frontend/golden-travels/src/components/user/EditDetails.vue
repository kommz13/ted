<template>
  <div class="contact-box-main">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 col-sm-12">
          <div class="contact-info-left">
            <h2>Edit INfo</h2>
            <p>
              Register for awesome stuff
            </p>
            <ul>
              <li>
                <p>
                  <i class="fas fa-map-marker-alt"></i>Address: Michael I. Days
                  3756 <br />Preston Street Wichita,<br />
                  KS 67213
                </p>
              </li>
              <li>
                <p>
                  <i class="fas fa-phone-square"></i>Phone:
                  <a href="tel:+1-888705770">+1-888 705 770</a>
                </p>
              </li>
              <li>
                <p>
                  <i class="fas fa-envelope"></i>Email:
                  <a href="mailto:contactinfo@gmail.com"
                    >contactinfo@gmail.com</a
                  >
                </p>
              </li>
            </ul>
          </div>
        </div>
        <div class="col-lg-8 col-sm-12">
          <div class="contact-form-right">
            <h2>Edit Profile</h2>
            <form id="editProfileForm" @submit.prevent="saveChanges">
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      id="firstname"
                      name="firstname"
                      placeholder="Please enter your firstname"
                      required
                      data-error="Please enter your name"
                      v-model="user.firstname"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="text"
                      placeholder="Please enter your lastname"
                      id="lastname"
                      class="form-control"
                      name="lastname"
                      required
                      data-error="Please enter your lastname"
                      v-model="user.lastname"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      id="email"
                      name="email"
                      placeholder="Please enter your e-mail"
                      required
                      data-error="Please enter your e-mail"
                      v-model="user.email"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      id="phone"
                      name="phone"
                      placeholder="Please enter your phone"
                      required
                      data-error="Please enter your phone"
                      v-model="user.phone"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>

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
                      v-model="user.username"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>

                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      id="birthdate"
                      name="birthdate"
                      placeholder="Please enter your birthdate"
                      required
                      data-error="Please enter your birthdate"
                      v-model="user.birthdate"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>

                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      id="photo_url"
                      name="photo_url"
                      placeholder="Please enter your photo url ( copy and paste something ffs ) "
                      required
                      data-error="Please enter your photo url ( copy and paste something ffs )"
                      v-model="user.photoUrl"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>

                <div class="col-md-12">
                  <div class="submit-button text-center">
                    <button class="btn hvr-hover" id="submit" type="submit">
                      Apply changes
                    </button>
                    <div id="msgSubmit" class="h3 text-center hidden"></div>
                    <div class="clearfix"></div>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
        <div class="col-lg-4 col-sm-12">
          &nbsp;
        </div>

        <div class="col-lg-8 col-sm-12">
          <div class="contact-form-right">
            <h2>Change password</h2>
            <form id="changePasswordForm" @submit.prevent="changePassword">
              <div class="row">
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
                      v-model="user.password"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>

                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="password"
                      class="form-control"
                      id="password_confirmation"
                      name="password_confirmation"
                      placeholder="Please re-enter your password"
                      required
                      data-error="Please re-enter your password"
                      v-model="user.password_confirmation"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="submit-button text-center">
                    <button class="btn hvr-hover" id="submit" type="submit">
                      Apply changes
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
import axios from "axios";
import API from "@/api/Api.js";
import authController from "@/auth/AuthController";

export default {
  data() {
    return {
      user: {
        firstname: undefined,
        lastname: undefined,
        email: undefined,
        phone: undefined,
        username: undefined,
        password: undefined,
        password_confirmation: undefined,
        birthdate: "2010-10-10T22:00:00Z[UTC]",
        is_host: false,
        is_customer: true,
        photoUrl:
          "https://icons-for-free.com/iconfiles/png/512/avatar+person+profile+user+icon-1320166578424287581.png",
      },
    };
  },
  mounted() {
    const id = authController.getUserID();
    this.retrieveData(id);
  },

  methods: {
    retrieveData(id) {
      axios.get(API.GET_USER_BY_ID + id).then((response) => {
        this.user = response.data[0];
      });
    },
    saveChanges() {
      const id = authController.getUserID();
      axios
        .post(API.CHANGE_PROFILE + id, this.user)
        .then(() => {
          alert("Profile changed");
          return false;
        })
        .catch((response) => {
          alert(response.data);
        });
    },
    changePassword() {
      const id = authController.getUserID();
      axios
        .post(API.CHANGE_PROFILE + id, this.user)
        .then(() => {
          alert("Password changed");
          return false;
        })
        .catch((response) => {
          alert(response.data);
        });
    },
  },
};
</script>
