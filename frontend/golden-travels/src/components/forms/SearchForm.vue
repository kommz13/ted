<template>
  <div class="container">
    <form class="needs-validation" @submit.prevent="submitForm">
      <div class="row">
        <div class="col-sm-6 col-lg-6 mb-3">
          <div class="checkout-address">
            <div class="title-left">
              <h2>Search</h2>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="city">City</label>
                <input
                  type="text"
                  class="form-control"
                  id="city"
                  placeholder="leave blank to ignore"
                  value=""
                  v-model="listing.city"
                />
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="checkin">Check-in date</label>
                <div class="input-group">
                  <input
                    type="text"
                    class="form-control"
                    id="checkin"
                    placeholder="type the latitude of the room"
                    v-model="listing.checkin"
                  />
                </div>
              </div>

              <div class="col-md-6 mb-3">
                <label for="checkout">Check-out date</label>
                <input
                  type="text"
                  class="form-control"
                  id="checkout"
                  placeholder=""
                  v-model="listing.checkout"
                />
              </div>
            </div>

            <div class="title-left">
              <h2>Properties</h2>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="cost">Cost per day</label>
                <input
                  type="number"
                  class="form-control"
                  id="cost"
                  placeholder=""
                  v-model="listing.cost"
                />
              </div>
              <div class="col-md-6 mb-3">
                <label for="maxPeople">Maximum number of People</label>
                <input
                  type="number"
                  class="form-control"
                  id="maxPeople"
                  placeholder=""
                  v-model="listing.maxPeople"
                />
                <div class="invalid-feedback">
                  Please enter maximum number of people.
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-lg-6 mb-3">
          <div class="row">
            <div class="col-md-6 col-lg-6">
              <div class="shipping-method-box">
                <div class="title-left">
                  <h3>Listing Type</h3>
                </div>
                <div class="mb-4">
                  <div class="custom-control custom-radio">
                    <input
                      id="shippingOption0"
                      name="shipping-option0"
                      class="custom-control-input"
                      checked="checked"
                      type="radio"
                      value="0"
                      v-model="listing.typeId"
                    />
                    <label class="custom-control-label" for="shippingOption0"
                      >Any</label
                    >
                  </div>

                  <div class="custom-control custom-radio">
                    <input
                      id="shippingOption1"
                      name="shipping-option"
                      class="custom-control-input"
                      type="radio"
                      value="1"
                      v-model="listing.typeId"
                    />
                    <label class="custom-control-label" for="shippingOption1"
                      >Entire</label
                    >
                  </div>

                  <div class="custom-control custom-radio">
                    <input
                      id="shippingOption2"
                      name="shipping-option"
                      class="custom-control-input"
                      type="radio"
                      value="2"
                      v-model="listing.typeId"
                    />
                    <label class="custom-control-label" for="shippingOption2"
                      >Private</label
                    >
                  </div>

                  <div class="custom-control custom-radio">
                    <input
                      id="shippingOption3"
                      name="shipping-option"
                      class="custom-control-input"
                      type="radio"
                      value="3"
                      v-model="listing.typeId"
                    />
                    <label class="custom-control-label" for="shippingOption3"
                      >Shared</label
                    >
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-6 col-lg-6">
              <div class="title-left">
                <h3>Amenities</h3>
              </div>
              <div class="custom-control custom-checkbox">
                <input
                  type="checkbox"
                  class="custom-control-input"
                  id="hasWifi"
                  v-model="listing.hasWifi"
                />
                <label class="custom-control-label" for="hasWifi">WiFi</label>
              </div>
              <div class="custom-control custom-checkbox">
                <input
                  type="checkbox"
                  class="custom-control-input"
                  id="hasKitchen"
                  v-model="listing.hasKitchen"
                />
                <label class="custom-control-label" for="hasKitchen"
                  >Kitchen</label
                >
              </div>
              <div class="custom-control custom-checkbox">
                <input
                  type="checkbox"
                  class="custom-control-input"
                  id="hasTv"
                  v-model="listing.hasTv"
                />
                <label class="custom-control-label" for="hasTv">Tv</label>
              </div>
              <div class="custom-control custom-checkbox">
                <input
                  type="checkbox"
                  class="custom-control-input"
                  id="hasParking"
                  v-model="listing.hasParking"
                />
                <label class="custom-control-label" for="hasParking"
                  >Parking</label
                >
              </div>
              <div class="custom-control custom-checkbox">
                <input
                  type="checkbox"
                  class="custom-control-input"
                  id="hasElevator"
                  v-model="listing.hasElevator"
                />
                <label class="custom-control-label" for="hasElevator"
                  >Elevator</label
                >
              </div>
              <div class="custom-control custom-checkbox">
                <input
                  type="checkbox"
                  class="custom-control-input"
                  id="hasHeating"
                  v-model="listing.hasHeating"
                />
                <label class="custom-control-label" for="hasHeating"
                  >Heating</label
                >
              </div>
              <div class="custom-control custom-checkbox">
                <input
                  type="checkbox"
                  class="custom-control-input"
                  id="hasLivingRoom"
                  v-model="listing.hasLivingRoom"
                />
                <label class="custom-control-label" for="hasLivingRoom"
                  >Living Room</label
                >
              </div>
              <div class="custom-control custom-checkbox">
                <input
                  type="checkbox"
                  class="custom-control-input"
                  id="hasAirCondition"
                  v-model="listing.hasAirCondition"
                />
                <label class="custom-control-label" for="hasAirCondition"
                  >Air Condition</label
                >
              </div>
            </div>
            <div class="col-12 d-flex shopping-box">
              <button id="submit" type="submit" class="ml-auto btn btn-success">
                Search
              </button>
            </div>
          </div>
        </div>
      </div>
    </form>

 <div class="row my-4" v-if="search_completed">
      <div class="col-12">
        <h2 class="noo-sh-title">Request:</h2>

<code>
        {{  JSON.stringify(this.listing, null, 2) }}
</code>
      </div>
    </div>

    <div class="row my-4" v-if="search_completed">
      <div class="col-12">
        <h2 class="noo-sh-title">Results:</h2>
      </div>
    </div>
    <div class="row" v-if="listings.length > 0">
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

    <div class="row my-4" v-if="listings.length > 0">
      <div
        v-for="l in filtered_listings"
        v-bind:key="l.id"
        class="col-sm-6 col-lg-3"
      >
        <div class="hover-team">
          <div class="our-team">
            <router-link
              :to="{ name: 'BookingViewById', params: { id: l.id } }"
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
  <!-- End Cart -->
</template>

<script>
import axios from "axios";
import API from "@/api/Api.js";
import authController from "@/auth/AuthController";
import PaginationMixin from "@/mixins/PaginationMixin";

export default {
  mixins: [PaginationMixin],
  data() {
    return {
      authController: authController,
      search_completed: false,

      listing: {
        checkin: "",
        checkout: "",
        city: "",
        maxPeople: "",
        cost: "",
        typeId: 0,
        hasWifi: false,
        hasKitchen: false,
        hasTv: false,
        hasParking: false,
        hasElevator: false,
        hasHeating: false,
        hasLivingRoom: false,
        hasAirCondition: false,
        hasPet: false,
        hasEvent: false,
        hasSmoking: false,
      },
      listings: [],
    };
  },
  computed: {
    filtered_listings() {
      return this.getPage(this.listings);
    },
  },
  methods: {
    submitForm() {
      this.retrieveData();
    },
    retrieveData() {
      this.search_completed = false;

      let s = JSON.stringify(this.listing, null, 2);
      // alert(s);
      console.log(s);

      axios.post(API.POST_LISTING_SEARCH, this.listing).then((response) => {
        this.listings = response.data;
        console.log(this.listings);
        this.search_completed = true;
      });
    },
  },
};
</script>
