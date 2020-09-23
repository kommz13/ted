<template
  ><!-- Start About Page  -->
  <div class="about-box-main">
    
    <div class="container">
      <div class="profile">
        <HostTitleBox title="User profile"></HostTitleBox>
      </div>
      <!-- <div class="row">
        <div class="col-lg-12">
          <h2>Listings {{ content }}</h2>
          <ul class="breadcrumb">
            <li class="breadcrumb-item">
              <router-link :to="{ path: '/host/listing/active' }"
                >Active</router-link
              >
            </li>
            <li class="breadcrumb-item active">
              <router-link :to="{ path: '/host/listing/inactive' }"
                >Inactive</router-link
              >
            </li>
            <li class="breadcrumb-item active">
              <router-link :to="{ path: '/host/listing/update' }"
                >Update</router-link
              >
            </li>
            <li class="breadcrumb-item active">
              <router-link :to="{ path: '/host/listing/create' }"
                >Create</router-link
              >
            </li>
            
            
          </ul>
        </div>
      </div> -->
      <div class="row">
        <div class="col-lg-6">
          <h2 class="noo-sh-title">{{ listing.friendlyName }}</h2>
          <p>
            <i>Submitted at: {{ listing.submittedDate }} </i>
          </p>
          <p>
          <ol>
            <li>Bedrooms: {{ listing.bedroom_num }}</li>
            <li>Beds: {{ listing.bedNum }}</li>
            <li>Bathrooms: {{ listing.bathroomNum }}</li>
            <li>Cost per day: {{ listing.cost }}</li>
            <li>Extra cost per day: {{ listing.extraCostPerPerson }}</li>
            <li>Maximum persons: {{ listing.maxPeople }}</li>
            <li>Minimum stay duration: {{ listing.minDays }}</li>
            <li>District: {{ listing.district }}</li>
            <li>City: {{ listing.city }}</li>
            <li>Country: {{ listing.country }}</li>
            
          </ol>
          </p>
          <p>
            {{ listing.description }}
          </p>
        </div>
        <div class="col-lg-6">
          <div class="banner-frame">
            <img class="img-thumbnail img-fluid" :src="getDefaultURL" alt="" />
          </div>
        </div>
      </div>
      <div class="row my-5">
        <div
          v-for="r in listing.rules"
          v-bind:key="r.id"
          class="col-sm-6 col-lg-4"
        >
          <div class="service-block-inner">
            <h3>We allow:</h3>
            <p>
              {{ r.rule }}
            </p>
          </div>
        </div>
      </div>
      <div class="row my-4">
        <div class="col-12">
          <h2 class="noo-sh-title">People said for this listing:</h2>
        </div>
        <div
          v-for="c in listing.critics"
          v-bind:key="c.id"
          class="col-sm-6 col-lg-3"
        >
          <div class="hover-team">
            <div class="our-team">
              <img :src="c.userId.photoUrl" alt="" />
              <div class="team-content">
                <h3 class="title">
                  {{ c.userId.firstname }} {{ c.userId.lastname }}
                </h3>
                <span class="post">{{ c.userId.email }} </span>
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
              <h3>
                Rated:

                <span v-for="i in c.rating" v-bind:key="i">
                  &#9733;
                </span>
              </h3>
              <p>
                {{ c.text }}
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
import HostTitleBox from "@/components/host/HostTitleBox.vue";

export default {
  components: {
    HostTitleBox,
  },
  data() {
    return {
      listing: {
        photos: [],
      },
    };
  },
  computed: {
    getDefaultURL: function() {
      console.log("computed called");

      for (let i = 0; i < this.listing.photos.length; i++) {
        let p = this.listing.photos[i];
        if (p.is_default) {
          console.log(p.photoUrl);
          return p.photoUrl;
        }
      }
      return "";
    },
  },
  mounted() {
    const id = this.$route.params.id;
    this.retrieveData(id);
  },
  watch: {
    $route(to, from) {
      console.log("to: " + from);
      const id = to.params.id;
      this.retrieveData(id);
    },
  },
  methods: {
    retrieveData(id) {
      axios.get(API.GET_LISTING_BY_ID + id).then((response) => {
        this.listing = response.data[0];
        console.log(this.listing);
      });
    },
  },
};
</script>
