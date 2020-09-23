<template
  ><div class="about-box-main">
    <div class="profile">
      <CustomerTitleBox title="User profile"></CustomerTitleBox>
    </div>
    <div class="container">
      <!-- <button @click.prevent="f">Active</button>
      <button @click.prevent="g">Inactive</button> -->

      <div class="row my-4">
        <div class="col-12">
          <h2 class="noo-sh-title">Your Active Bookings</h2>
        </div>
        <div v-for="b in bookings" v-bind:key="b.id" class="col-sm-6 col-lg-3">
          <div class="hover-team">
            <div class="our-team">
              <router-link
                :to="{
                  name: 'BookingPreviousForCustomers',
                  params: { id: b.id },
                }"
              >
                <img
                  v-if="b.photos.length"
                  :src="b.photos[0].photoUrl"
                  alt=""
                  class="img_thumbnail"
                />
                <img v-else src="" alt="" />
              </router-link>
              <div class="icon">
                <i class="fa fa-plus" aria-hidden="true"></i>
              </div>
            </div>
            <div class="team-description">
              <p>
                {{ b.id }}
              </p>
              
            </div>
            <hr class="my-0" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.img_thumbnail {
  display: block;
  max-width: 100%;
  max-height: 300px;
  min-height: 300px;
  width: auto;
  height: auto;
}
</style>

<script>
import axios from "axios";
import API from "@/api/Api.js";
import CustomerTitleBox from "@/components/customer/CustomerTitleBox.vue";
import authController from "@/auth/AuthController";

export default {
  components: {
    CustomerTitleBox,
  },

  data() {
    return {
      authController: authController,
      bookings: [],
    };
  },
  mounted() {
    const id = authController.getUserID();
    this.retrieveData(id);
  },
  methods: {
    retrieveData(id) {
      axios.get(API.GET_ACTIVE_BOOKINGS + id).then((response) => {
        this.bookings = response.data;
        console.log(this.bookings);
      });
    },
  },
};
</script>
