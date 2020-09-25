<template>
  <div>
    <HostTitleBox title="User profile"></HostTitleBox>

    <div class="container">
      <!-- <button @click.prevent="f">Active</button>
      <button @click.prevent="g">Inactive</button> -->

      <div class="row my-4">
        <div class="col-12">
          <h2 class="noo-sh-title">Unpublished listings</h2>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <div class="add-to-btn">
            <div class="add-comp">
              Page {{ page }} of {{ maxpages }} - {{ listings.length }}
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
      </div>
      <div class="row my-4">
        <div
          v-for="l in filtered_listings"
          v-bind:key="l.id"
          class="col-sm-6 col-lg-3"
        >
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
             
            <div class="icon">
                <router-link
                  :to="{ name: 'ListingUpdate', params: { id: l.id } }"
                >
                  <i class="fa fa-edit" aria-hidden="true"></i>
                </router-link>
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
import PaginationMixin from "@/mixins/PaginationMixin";

export default {
  components: {
    HostTitleBox,
  },
  mixins: [PaginationMixin],
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
  computed: {
    filtered_listings() {
      return this.getPage(this.listings);
    },
  },
  methods: {
    retrieveData(id) {
      axios.get(API.GET_INACTIVE_LISTINGS_BY_USER_ID + id).then((response) => {
        this.listings = response.data;
        console.log(this.listings);
      });
    },
  },
};
</script>
