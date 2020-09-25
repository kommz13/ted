<template>
  <div>
    <CustomerTitleBox></CustomerTitleBox>
    
    <div class="container">
      <div class="row ">
         <div class="col-lg-4">
          <GmapMap
      :center="{lat:listing.geolocation_lat, lng:listing.geolocation_long}"
      :zoom="17"
      map-type-id="roadmap"
      style="width: 300px; height: 300px"      
  >
  <GmapMarker
    key="1"
    :position="{lat:listing.geolocation_lat, lng:listing.geolocation_long}"
  />

</GmapMap>
</div>
        <div class="col-lg-4">
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
        <div class="col-lg-4">
          <div class="banner-frame">
            <img class="img-thumbnail img-fluid" :src="getDefaultURL" alt="" />
          </div>
        </div>
      </div>

      <div class="row my-4">
        <div class="col-12">
          <h2 class="noo-sh-title">Photos:</h2>
        </div>
        <div
          v-for="c in listing.photos"
          v-bind:key="c.id"          
        >
        <div class="col-sm-6 col-lg-3">
          <div v-if="!c.is_default" class="hover-team">
            <div class="our-team">
              <img :src="c.photoUrl" alt="" />
            </div>
            <hr class="my-0" />
          </div>
          </div>
        </div>
      </div>
        
      <div class="row my-5">
        <div class="col-sm-4 col-lg-4">
          <div class="service-block-inner">
            <h3>Amenities:</h3>
            <p v-for="a in listing.amenities" v-bind:key="a.id">
              {{ a.name }}
            </p>
          </div>
        </div>
        <div class="col-sm-4 col-lg-4">
          <div class="service-block-inner">
            <h3>Rules:</h3>
            <p  v-for="r in listing.rules" v-bind:key="r.id">
              {{ r.rule }}
            </p>
          </div>
        </div>
        <div class="col-sm-4 col-lg-4">
          <div class="service-block-inner">
            <h3>Status:</h3>
            <p v-if="listing.active">
              Available
            </p>

            <p v-else>
              Not available right now
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


    
      <div class="cart-box-main">
      <div class="container">
        <div class="row">
          <div class="col-12">
          <h2 class="noo-sh-title">Bookings:</h2>
        </div>

          <div class="col-lg-12">
            <div class="table-main table-responsive">
              <table class="table">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Status</th>
                    <th>Checkin</th>
                    <th>Checkout</th>
                    <th>Username</th>
                    <th>Name</th>
                    <th>People</th>
                    <th>&nbsp;</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="b in mybookings" :key="b.id">
                    <td>
                      {{ b.id }}
                    </td>
                    <td>
                      {{ b.bookingStatus }}
                    </td>
                    <td>
                      {{ b.checkIn }}
                    </td>
                    <td>
                      {{ b.checkOut }}
                    </td>
                    <td>
                      {{ b.user.username  }}
                    </td>
                    <td>
                      {{ b.user.firstname  }} {{ b.user.lastname  }}
                    </td>
                    <td>
                      {{ b.user.howManyPeople  }}
                    </td>
                    <td class="total-pr">                      
                      <button v-if="b.bookingStatus == 0 && b.userId == user_id" class="btn btn-primary" @click="rejectBooking(b.id)">
                        Reject
                      </button>

                      <div v-if="b.bookingStatus == 1" class="badge badge-success">
                        Accepted
                      </div>

                      <div v-if="b.bookingStatus == 2" class="badge badge-error">
                        Rejected
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>

            <form class="needs-validation" @submit.prevent="submitBooking">
      <div class="row">
        <div class="col-sm-12 col-lg-12 mb-3">
          <div class="checkout-address">
            <div class="title-left">
              <h2>Booking Creation</h2>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="country">Check-in</label>
                <input
                  type="text"
                  class="form-control"
                  value=""
                  required
                  v-model="booking.checkIn"
                />
              </div>
              <div class="col-md-6 mb-3">
                <label for="city">Check-out</label>
                <input
                  type="text"
                  class="form-control"
                  value=""
                  required
                  v-model="booking.checkOut"
                />
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="country">People</label>
                <input
                  type="text"
                  class="form-control"
                  id="country"
                  placeholder=""
                  value=""
                  required
                  v-model="booking.howManyPeople"
                />
              </div>
              </div>

              <div class="col-12 d-flex shopping-box">
              <button id="submit" type="submit" class="ml-auto btn btn-success">
                Apply for a booking
              </button>
            </div>

            </div>
            </div>
            </div>
            </form>
            

              
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
</template>

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
      user_id: authController.getUserID(),

      listing: {
        geolocation_lat: 0,
        geolocation_long: 0,
        photos: [],
      },
      booking: {
        checkIn: "",
        checkOut: "",
        howManyPeople: 2,
        userId:  authController.getUserID(),
        listingId: 0
      }
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
    mybookings: function() {
      console.log(this.user_id);
      if (!this.listing || !this.listing.bookings) {
        return [];
      }
      let data = this.listing.bookings.filter(p => p.user.id == this.user_id);
      return data;
    }
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
    showCustomerOption() {
      return authController.isCustomer() == true;
    },
    retrieveData(id) {
      axios.get(API.GET_LISTING_BY_ID + id).then((response) => {
        this.listing = response.data[0];
        this.booking.listingId = id;
        console.log(this.listing);
      });
    },
    rejectBooking(id) {
      axios.post(API.POST_REJECT_BOOKING + id).then((response) => {
        if (response.status == 200) {
          id = this.$route.params.id;
          this.retrieveData(id);
        }
      });
    },
    submitBooking(id) {
      this.booking.checkIn = this.booking.checkIn + "T22:00:00Z[UTC]";
      this.booking.checkOut = this.booking.checkOut + "T22:00:00Z[UTC]";

      axios.post(API.POST_BOOKING, this.booking).then((response) => {
        if (response.status == 200) {
          id = this.$route.params.id;
          this.retrieveData(id);
        }
      });
    }
  },
};
</script>
