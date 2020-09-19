<template>
  <div class="contact-box-main">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 col-sm-12">
          <div class="contact-info-left">
            <h2>REGISTER INFO</h2>
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
            <h2>GET IN TOUCH</h2>
            <p v-show="!submit_complete">
              Please fill the form below and submit it. An administrator will
              examine your request and if it is approved you will be notified
            </p>

            <p v-show="submit_complete">
              Your application has been submited. You will  be notified at {{ form.email  }}.
            </p>
            <form id="contactForm" v-show="!submit_complete" @submit.prevent="register">
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
                      v-model="form.firstname"
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
                      v-model="form.lastname"
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
                      v-model="form.email"
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
                      v-model="form.phone"
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
                  <div class="form-group">
                    <input
                      type="password"
                      class="form-control"
                      id="password_confirmation"
                      name="password_confirmation"
                      placeholder="Please re-enter your password"
                      required
                      data-error="Please re-enter your password"
                      v-model="form.password_confirmation"
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
                      v-model="form.birthdate"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>

                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="checkbox"
                      id="is_host"
                      name="is_host"
                      v-model="form.is_host"
                    />
                    Would you like to be a host?
                    <div class="help-block with-errors"></div>
                  </div>
                </div>

                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="checkbox"
                      id="is_customer"
                      name="is_customer"
                      v-model="form.is_customer"
                    />
                    Would you like to be a customer?
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
                      v-model="form.photoUrl"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>

                <div class="col-md-12">
                  <div class="submit-button text-center">
                    <button
                      class="btn hvr-hover"
                      id="submit"
                      type="submit"
                    >
                      Complete registration
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

export default {
  data() {
    return {
      submit_complete: false,
      form: {
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
        photoUrl: "https://icons-for-free.com/iconfiles/png/512/avatar+person+profile+user+icon-1320166578424287581.png",
      },
    };
  },
  mounted() {},

  methods: {
    register() {
      if (!this.form.firstname) {
        alert("firstname is a required field");
      } else {
        axios
          .post(API.REGISTRATION, this.form)
          .then(() => {
            this.submit_complete = true;
            return false;
          })
          .catch((response) => {
            alert(response.data);
          });
      }
      return false;
    },
  },
};
</script>
