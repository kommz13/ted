<template
  ><div class="about-box-main">
    <div class="container">
      <div class="row my-4">
        <div class="col-12">
          <h2 class="noo-sh-title">Your Listings</h2>
        </div>
        <div v-for="l in listings" v-bind:key="l.id" class="col-sm-6 col-lg-3">
          <div class="hover-team">
            <div class="our-team">
              <img src="images/img-1.jpg" alt="" />
              <div class="team-content">
                <h3 class="title">{{ l.friendlyName }}</h3>
                <span class="post">{{ l.city }}</span>
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
                {{ l.description }}
              </p>
            </div>
            <hr class="my-0" />
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
      listings: []
    };
  },
  mounted() {
    const id = 5;
    this.retrieveData(id);
  },
  methods: {
    retrieveData(id) {
      axios.get(API.GET_ACTIVE_LISTINGS_BY_USER_ID + id).then((response) => {
        this.listings = response.data;
        console.log(this.listings)
      });
    },
  },
};
</script>
