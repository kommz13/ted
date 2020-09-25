<template>
  <div>
    <MessageTitleBox></MessageTitleBox>

    <div class="cart-box-main">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 col-sm-12">
            <h2>Inbox</h2>
            <div class="table-main table-responsive">
              <table class="table">
                <thead>
                  <tr>
                    <th>&nbsp;</th>
                    <th>From</th>
                    <th>Content</th>
                    <th>Date</th>
                    <th>&nbsp;</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="m in filtered_messages" v-bind:key="m.id">
                    <td class="thumbnail-img">
                      <a href="#">
                        <img
                          class="img-fluid"
                          :src="m.sender.photoUrl"
                          alt=""
                        />
                      </a>
                    </td>
                    <td class="name-pr">
                      <router-link
                        :to="{
                          name: 'Profile',
                          params: { id: m.sender.id },
                        }"
                      >
                        {{ m.sender.firstname }} {{ m.sender.lastname }}
                      </router-link>
                    </td>
                    <td class="name-pr">{{ m.text.substring(0, 20) }} ...</td>
                    <td class="name-pr">
                      {{ m.dateTime }}
                    </td>
                    <!-- <td class="name-pr">
                      {{ u.birthdate }}
                    </td>                                         -->
                    <td class="total-pr">
                      <button
                        type="button"
                        @click="reply(m.id)"
                        class="btn btn-primary"
                      >
                        Reply
                      </button>
                      &nbsp;
                      <button
                        type="button"
                        @click="remove(m.id)"
                        class="btn btn-primary"
                      >
                        Delete
                      </button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>

            <div class="add-to-btn">
              <div class="add-comp">
                Page {{ page }} of {{ maxpages }} - {{ messages.length }}
                records
              </div>
              <div class="share-bar">
                <a class="btn hvr-hover" href="#" @click.prevent="first">
                  |<i class="fas fa-caret-left"></i>
                </a>
                <a class="btn hvr-hover" href="#" @click.prevent="previous">
                  <i class="fas fa-caret-left"> </i>
                </a>
                <a class="btn hvr-hover" href="#" @click.prevent="next">
                  <i class="fas fa-caret-right"></i>
                </a>
                <a class="btn hvr-hover" href="#" @click.prevent="last">
                  <i class="fas fa-caret-right"></i>|
                </a>
              </div>
            </div>
          </div>
          <!-- <div class="col-lg-8 col-sm-12">
                <div class="contact-form-right">
                  <h2>Received message</h2>

                  <form id="contactForm">
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <input
                            type="text"
                            class="form-control"
                            id="name"
                            name="name"
                            placeholder="Message From"
                            required
                            data-error="Please enter your name"
                            v-model="message.name"
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
              </div> -->
          <!-- End Cart -->
        </div>
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
      messages: [],
    };
  },
  computed: {
    filtered_messages() {
      return this.getPage(this.messages);
    },
  },
  mounted() {
    const id = authController.getUserID();
    this.retrieveData(id);
  },
  methods: {
    retrieveData(id) {
      axios.get(API.GET_SENT_MESSAGES + id).then((response) => {
        this.messages = response.data;
        console.log(this.message);
      });
    },
    reply(id) {
      console.log("replying to " + id);
    },
    remove(id) {
      axios
        .post(API.POST_DELETE_MESSAGE + id)
        .then(() => {
          const id = authController.getUserID();
          this.retrieveData(id);
        })
        .catch(() => {
          console.log("Error: message could not be deleted");
        });
    },
  },
};
</script>
