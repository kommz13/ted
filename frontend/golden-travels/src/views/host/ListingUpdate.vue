<template>
  <div class="container">
    <form class="needs-validation" @submit.prevent="submitForm">
      <div class="row">
        <div class="col-sm-6 col-lg-6 mb-3">
          <div class="checkout-address">
            <div class="title-left">
              <h2>Room Update</h2>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="country">Country</label>
                <input
                  type="text"
                  class="form-control"
                  id="country"
                  placeholder=""
                  value=""
                  required
                  v-model="listing.country"
                />
                <div class="invalid-feedback">
                  Valid country is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="city">City</label>
                <input
                  type="text"
                  class="form-control"
                  id="city"
                  placeholder=""
                  value=""
                  required
                  v-model="listing.city"
                />
                <div class="invalid-feedback">
                  Valid city is required.
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="geolocation_lat">Geolocation latitude</label>
                <div class="input-group">
                  <input
                    type="text"
                    class="form-control"
                    id="geolocation_lat"
                    placeholder="type the latitude of the room"
                    required
                    v-model="listing.geolocation_lat"
                  />
                  <div class="invalid-feedback" style="width: 100%;">
                    Please enter geolocation latitude coordinates.
                  </div>
                </div>
              </div>

              <div class="col-md-6 mb-3">
                <label for="geolocation_long">Geolocation longitude</label>
                <input
                  type="text"
                  class="form-control"
                  id="geolocation_long"
                  placeholder=""
                  required
                  v-model="listing.geolocation_long"
                />
                <div class="invalid-feedback">
                  Please enter geolocation longitude coordinates.
                </div>
              </div>
            </div>
            <div class="mb-3">
              <label for="district">District</label>
              <input
                type="text"
                class="form-control"
                id="district"
                placeholder=""
                required
                v-model="listing.district"
              />
              <div class="invalid-feedback">
                Please enter a district.
              </div>
            </div>

            <div class="title-left">
              <h2>Properties</h2>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="floor">Floor</label>
                <input
                  type="number"
                  class="form-control"
                  id="floor"
                  placeholder=""
                  v-model="listing.floor"
                />
              </div>
              <div class="col-md-6 mb-3">
                <label for="bedroom">Bedroom no</label>
                <input
                  type="number"
                  class="form-control"
                  id="bedroom_num"
                  placeholder=""
                  v-model="listing.bedroom_num"
                />
                <div class="invalid-feedback">
                  Please enter a valid bedroom number.
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="maxPeople">Maximum number of People</label>
                <input
                  type="number"
                  class="form-control"
                  id="maxPeople"
                  placeholder=""
                  required
                  v-model="listing.maxPeople"
                />
                <div class="invalid-feedback">
                  Please enter maximum number of people.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="bedNum">Bed numbers</label>
                <input
                  type="number"
                  class="form-control"
                  id="bedNum"
                  placeholder=""
                  required
                  v-model="listing.bedNum"
                />
                <div class="invalid-feedback">
                  Please enter number of beds.
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="sqrMeters">Enter square meters</label>
                <input
                  type="number"
                  class="form-control"
                  id="sqrMeters"
                  placeholder=""
                  required
                  v-model="listing.sqrMeters"
                />
                <div class="invalid-feedback">
                  Please enter square meters.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="friendlyName">Friendly Name</label>
                <input
                  type="text"
                  class="form-control"
                  id="friendlyName"
                  placeholder=""
                  required
                  v-model="listing.friendlyName"
                />
                <div class="invalid-feedback">
                  Please enter a friendly name.
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="minDays">Minimum rent days</label>
                <input
                  type="text"
                  class="form-control"
                  id="minDays"
                  placeholder=""
                  required
                  v-model="listing.minDays"
                />
                <div class="invalid-feedback">
                  Enter minimum rent days.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="extraCostPerPerson">Extra cost per person</label>
                <input
                  type="text"
                  class="form-control"
                  id="extraCostPerPerson"
                  placeholder=""
                  required
                  v-model="listing.extraCostPerPerson"
                />
                <div class="invalid-feedback">
                  Please enter extra cost per person.
                </div>
              </div>
              <div class="col-md-12 mb-3">
                <label for="description">Description</label>
                <input
                  type="text"
                  class="form-control"
                  id="description"
                  placeholder=""
                  required
                  v-model="listing.description"
                />
                <div class="invalid-feedback">
                  Please enter a description.
                </div>
              </div>
            </div>

            <div class="title-left">
              <h2>
                Photos
                <button
                  @click="
                    listing.photos.push({
                      id: undefined,
                      default: false,
                      photoUrl: '',
                    })
                  "
                >
                  +
                </button>
              </h2>
            </div>

            <div class="row">
              <div
                v-for="(p, i) in listing.photos"
                v-bind:key="p.id"
                class="col-md-12 mb-3"
              >
                <label for="photo_url">Photo URL #{{ i + 1 }}</label>
                <input
                  type="text"
                  class="form-control"
                  id="photo_url"
                  placeholder=""
                  required
                  v-model="p.photoUrl"
                />
                <div class="invalid-feedback">
                  Please enter photo URL.
                </div>
                <input type="checkbox" v-model="p.is_default" />
                Default

                <button @click="listing.photos.splice(i, 1)">
                  remove
                </button>
              </div>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-lg-6 mb-3">
          <div class="row">
            <div class="col-md-12 col-lg-12">
              <div class="shipping-method-box">
                <div class="title-left">
                  <h3>Listing Type</h3>
                </div>
                <div class="mb-4">
                  <div class="custom-control custom-radio">
                    <input
                      id="shippingOption1"
                      name="shipping-option"
                      class="custom-control-input"
                      checked="checked"
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
            <div class="col-md-12 col-lg-12">
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
            <div class="col-md-12 col-lg-12">
              <br />
              <br />
              <div class="order-box">
                <div class="title-left">
                  <h3>Rules</h3>
                </div>
                <div class="custom-control custom-checkbox">
                  <input
                    type="checkbox"
                    class="custom-control-input"
                    id="hasPet"
                    v-model="listing.hasPet"
                  />
                  <label class="custom-control-label" for="hasPet">Pet</label>
                </div>
                <div class="custom-control custom-checkbox">
                  <input
                    type="checkbox"
                    class="custom-control-input"
                    id="hasEvent"
                    v-model="listing.hasEvent"
                  />
                  <label class="custom-control-label" for="hasEvent"
                    >Party</label
                  >
                </div>
                <div class="custom-control custom-checkbox">
                  <input
                    type="checkbox"
                    class="custom-control-input"
                    id="hasSmoking"
                    v-model="listing.hasSmoking"
                  />
                  <label class="custom-control-label" for="hasSmoking"
                    >Smoking</label
                  >
                </div>
              </div>
            </div>
            <div class="col-12 d-flex shopping-box">
              <button id="submit" type="submit" class="ml-auto btn primary  ">
                Apply changes
              </button>
            </div>

            <div class="col-md-12 col-lg-12">
              <br />
              <br />
            </div>
            
            <div class="col-12 d-flex shopping-box">
              <button
                v-if="deactivatable"
                id="deleteRoom"
                @click.prevent="deactivateListing(listing.id)"
                class="ml-auto btn hvr-hover"
              >
                Deactive Room
              </button>

              <button
                v-if="activatable"
                id="deleteRoom"
                @click.prevent="activateListing(listing.id)"
                class="ml-auto btn btn-success"
              >
                Activate Room
              </button>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
  <!-- End Cart -->
</template>

<script>
import axios from "axios";
import API from "@/api/Api.js";

export default {
  data() {
    return {
      submit_complete: false,

      listing: {
        geolocation_lat: 0,
        geolocation_long: 0,
        country: "-",
        bedroom_num: 5,
        city: "-",
        district: "",
        floor: 0,
        maxPeople: 0,
        bedNum: 0,
        bathroomNum: 0,
        description: "",
        sqrMeters: 0,
        minDays: 0,
        extraCostPerPerson: 0,
        typeId: 0,
        friendlyName: "",
        userId: 0,
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
        photos: [],
      },
    };
  },
  mounted() {
    const id = this.$route.params.id;
    this.retrieveData(id);
  },
  computed: {
    activatable() {
      return !this.listing.active;
    },
    deactivatable() {
      return (
        this.listing.active &&
        (!this.listing.bookings ||
          (this.listing.bookings && this.listing.bookings.length == 0))
      );
    },
  },
  methods: {
    retrieveData(id) {
      axios.get(API.GET_UPDATE_LISTING + id).then((response) => {
        this.listing = response.data[0];
        console.log(this.listings);
      });
    },
    submitForm() {
      const id = this.$route.params.id;
      axios
        .post(API.POST_UPDATE_LISTING + id, this.listing)
        .then(() => {
          this.submit_complete = true;
          alert("submit successful!");

          return false;
        })
        .catch((response) => {
          alert(response.data);
        });
      return false;
    },
    activateListing(id) {
      console.log(id);
      axios
        .post(API.POST_ACTIVATE_LISTING + id, this.listing)
        .then(() => {
          this.submit_complete = true;

          this.retrieveData(id);

          return false;
        })
        .catch((response) => {
          alert(response.data);
        });
      return false;
    },
    deactivateListing(id) {
      console.log(id);
      axios
        .post(API.POST_DEACTIVATE_LISTING + id, this.listing)
        .then(() => {
          this.submit_complete = true;

          this.retrieveData(id);

          return false;
        })
        .catch((response) => {
          alert(response.data);
        });
      return false;
    },
  },
};
</script>
