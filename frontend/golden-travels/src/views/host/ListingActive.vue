<template
  ><div class="about-box-main">
    <div class="profile">
      <HostTitleBox title="User profile"></HostTitleBox>
    </div>
    <div class="container">
      <!-- <button @click.prevent="f">Active</button>
      <button @click.prevent="g">Inactive</button> -->

      <div class="row my-4">
        <div class="col-12">
          <h2 class="noo-sh-title">Your Listings</h2>
        </div>
        <div v-for="l in listings" v-bind:key="l.id" class="col-sm-6 col-lg-3">
          <div class="hover-team">
            <div class="our-team">
              <router-link
                :to="{ name: 'ListingViewByUserID', params: { id: l.id } }"
              >
                <img
                  v-if="l.photos.length"
                  :src="l.photos[0].photoUrl"
                  alt=""
                  class="img_thumbnail"
                />
                <img v-else src="" alt="" />
              </router-link>

              <div class="team-content">
                <h3 class="title">{{ l.city }}</h3>
                <span class="post">{{ l.district }}</span>
              </div>
              <ul class="social">
                <li>
                  <a href="#" class="fab fa-facebook"></a>
                </li>
                <li>
                  <a href="#" class="fab fa-twitter"></a>
                </li>
                <li>
                  <a href="#" class="fab fa-google-plus"></a>
                </li>
                <li>
                  <a href="#" class="fab fa-youtube"></a>
                </li>
              </ul>
              <div class="icon">
                <i class="fa fa-plus" aria-hidden="true"></i>
              </div>
            </div>
            <div class="team-description">
              <p>
                {{ l.friendlyName }}
              </p>
              <p>{{ l.cost }} + {{ l.extraCostPerPerson }} per person</p>
              <p>
                {{ l.submittedDate }}
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
import HostTitleBox from "@/components/host/HostTitleBox.vue";
import authController from "@/auth/AuthController";

export default {
  components: {
    HostTitleBox,
  },

  data() {
    return {
      authController: authController,
      listings: [],
    };
  },
  mounted() {
    const id = authController.getUserID();
    this.retrieveData(id);
  },
  methods: {
    retrieveData(id) {
      axios.get(API.GET_ACTIVE_LISTINGS_BY_USER_ID + id).then((response) => {
        this.listings = response.data;
        console.log(this.listings);
      });
    }
  },
};
</script>
