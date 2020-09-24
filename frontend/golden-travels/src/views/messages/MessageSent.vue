<template>
  <!-- Start Contact Us  -->
  <div class="contact-box-main">
    <div class="profile">
      <MessageTitleBox title="User profile"></MessageTitleBox>
    </div>
    <div class="container">
      <div class="row">
        <!-- Start Contact Us  -->
        <div class="cart-box-main">
          <div class="container">
            <div class="row">
              <div class="col-lg-12 col-sm-12">
                <div class="contact-info-left">
                  <h2>Outbox</h2>
                  <div class="table-main table-responsive">
              <table class="table">
                <thead>
                  <tr>
                    <th>To</th>
                    <th>Date</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="m in filtered_users" :key="m.id">
                    <td class="thumbnail-img">
                      <a href="#">
                        <img class="img-fluid" :src="m.sender.photoUrl" alt="" />
                      </a>
                    </td>
                    <td>
                      {{ u.id }}
                    </td>
                    <td class="name-pr">
                      <router-link
                        :to="{ name: 'MessageSent', params: { id: u.id } }"
                        >{{ u.firstname }} {{ u.lastname }}</router-link
                      >
                    </td>
                    <td class="name-pr">
                      {{ u.username }}
                    </td>
                    <td class="name-pr">
                      {{ u.email }}
                    </td>
                    <!-- <td class="name-pr">
                      {{ u.birthdate }}
                    </td>                                         -->
                    <td class="total-pr">
                      {{ u.phone }}
                    </td>
                    <td>
                      <div
                        class="badge badge-success"
                        v-for="r in u.roles"
                        :key="r.id"
                      >
                        {{ r.name }}
                      </div>
                    </td>
                    <td class="total-pr">
                      <button
                        type="button"
                        @click="rejectUser(u.id)"
                        class="btn btn-primary"
                      >
                        Reply
                      </button>
                    </td>
                     <td class="total-pr">
                      <button
                        type="button"
                        @click="rejectUser(u.id)"
                        class="btn btn-primary"
                      >
                        Reply
                      </button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
                </div>
              </div>
              <div class="col-lg-8 col-sm-12">
                <div class="contact-form-right">
                  <h2>Send message</h2>

                  <form id="contactForm">
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <input
                            type="text"
                            class="form-control"
                            id="name"
                            name="name"
                            placeholder="Message To"
                            required
                            data-error="Please enter your name"
                            v-model="message.receiver.id"
                          />
                          <div class="help-block with-errors"></div>
                        </div>
                      </div>
                      <div class="col-md-12">
                        <div class="form-group">
                          <input
                            type="text"
                            class="form-control"
                            id="subject"
                            name="name"
                            placeholder="Subject"
                            required
                            data-error="Please enter your Subject"
                          />
                          <div class="help-block with-errors"></div>
                        </div>
                      </div>
                      <div class="col-md-12">
                        <div class="form-group">
                          <textarea
                            class="form-control"
                            id="message"
                            placeholder="Message"
                            rows="4"
                            data-error="Write your message"
                            required
                            v-model="message.text"
                          ></textarea>
                          <div class="help-block with-errors"></div>
                        </div>
                        <div class="submit-button text-center">
                          <button
                            class="btn hvr-hover"
                            id="submit"
                            type="submit"
                          >
                            Reply
                          </button>
                          <div
                            id="msgSubmit"
                            class="h3 text-center hidden"
                          ></div>
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
        <!-- End Cart -->
      </div>
    </div>
  </div>
  <!-- End Cart -->
</template>

<script>
import axios from "axios";
import API from "@/api/Api.js";
import MessageTitleBox from "@/components/customer/MessageTitleBox.vue";
import authController from "@/auth/AuthController";
import PaginationMixin from "@/mixins/PaginationMixin";

export default {
  components: {
    MessageTitleBox,
  },

  mixins: [PaginationMixin],
  data() {
    return {
      authController: authController,
      message: [],
    };
  },
    mounted(){
    const id = authController.getUserID();
    this.retrieveData(id);
  },
  methods: {
    retrieveData(id) {
      axios.get(API.GET_RECEIVED_MESSAGES + id).then((response) => {
        this.message = response.data;
        console.log(this.message);
      })
    },
  },
  };

</script>
