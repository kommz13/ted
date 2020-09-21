<template>
  <div class="shop-detail-box-main">
    <div class="container">
      <div class="row">
        <div class="col-xl-5 col-lg-5 col-md-6">
          <div
            id="carousel-example-1"
            class="single-product-slider carousel slide"
            data-ride="carousel"
          >
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <img
                  class="d-block w-100"
                  :src="user.photoUrl"
                  alt="First slide"
                />
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-7 col-lg-7 col-md-6">
          <div class="single-product-details">
            <h2>{{ user.firstname }} {{ user.lastname }}</h2>
            <h2>
              <span v-for="r in user.roles" v-bind:key="r.id"
                >{{ r.name }}
              </span>
            </h2>
            <h2 class="available-stock">
              Email : {{ user.email }} 
            </h2>
            <h2>Username : {{ user.username }}</h2>
            <h2>Id : {{ user.id }}</h2>
            <h2>Phone : {{ user.phone }}</h2>
            <h2>Registration status : {{ user.registrationStatus }}</h2>
            <h2>Birthdate : {{ user.birthdate }}</h2>
            <h2>Registration date : {{ user.registrationDate }}</h2>
            <!-- <ul>
              <li>
                <div class="form-group size-st">
                  <label class="size-label">Size</label>
                  <select
                    id="basic"
                    class="selectpicker show-tick form-control"
                  >
                    <option value="0">Size</option>
                    <option value="0">S</option>
                    <option value="1">M</option>
                    <option value="1">L</option>
                    <option value="1">XL</option>
                    <option value="1">XXL</option>
                    <option value="1">3XL</option>
                    <option value="1">4XL</option>
                  </select>
                </div>
              </li>
              <li>
                <div class="form-group quantity-box">
                  <label class="control-label">Quantity</label>
                  <input
                    class="form-control"
                    value="0"
                    min="0"
                    max="20"
                    type="number"
                  />
                </div>
              </li>
            </ul> -->
            <!-- 
            <div class="price-box-bar">
              <div class="cart-and-bay-btn">
                <a class="btn hvr-hover" data-fancybox-close="" href="#"
                  >send message</a
                >
               
              </div>
            </div> -->

            <div class="add-to-btn">
              <div class="add-comp">
                <router-link class="btn hvr-hover"  :to="{ name: 'EditMyAccount' }"><i class="fas fa-envelope"></i> edit</router-link>
                <!-- <a class="btn hvr-hover" href="#"
                  ><i class="fas fa-sync-alt"></i> Add to Compare</a
                > -->
                <!-- </div>
              <div class="share-bar">
                <a class="btn hvr-hover" href="#"
                  ><i class="fab fa-facebook" aria-hidden="true"></i
                ></a>
                <a class="btn hvr-hover" href="#"
                  ><i class="fab fa-google-plus" aria-hidden="true"></i
                ></a>
                <a class="btn hvr-hover" href="#"
                  ><i class="fab fa-twitter" aria-hidden="true"></i
                ></a>
                <a class="btn hvr-hover" href="#"
                  ><i class="fab fa-pinterest-p" aria-hidden="true"></i
                ></a>
                <a class="btn hvr-hover" href="#"
                  ><i class="fab fa-whatsapp" aria-hidden="true"></i
                ></a>-->
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="row my-5">
        <div class="col-lg-12">
          <div class="title-all text-center">
            <h1>Featured Products</h1>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit
              amet lacus enim.
            </p>
          </div>
          <div class="featured-products-box owl-carousel owl-theme">
            <div class="item">
              <div class="products-single fix">
                <div class="box-img-hover">
                  <img
                    src="images/img-pro-01.jpg"
                    class="img-fluid"
                    alt="Image"
                  />
                  <div class="mask-icon">
                    <ul>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="View"
                          ><i class="fas fa-eye"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Compare"
                          ><i class="fas fa-sync-alt"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Add to Wishlist"
                          ><i class="far fa-heart"></i
                        ></a>
                      </li>
                    </ul>
                    <a class="cart" href="#">Add to Cart</a>
                  </div>
                </div>
                <div class="why-text">
                  <h4>Lorem ipsum dolor sit amet</h4>
                  <h5>$9.79</h5>
                </div>
              </div>
            </div>
            <div class="item">
              <div class="products-single fix">
                <div class="box-img-hover">
                  <img
                    src="images/img-pro-02.jpg"
                    class="img-fluid"
                    alt="Image"
                  />
                  <div class="mask-icon">
                    <ul>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="View"
                          ><i class="fas fa-eye"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Compare"
                          ><i class="fas fa-sync-alt"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Add to Wishlist"
                          ><i class="far fa-heart"></i
                        ></a>
                      </li>
                    </ul>
                    <a class="cart" href="#">Add to Cart</a>
                  </div>
                </div>
                <div class="why-text">
                  <h4>Lorem ipsum dolor sit amet</h4>
                  <h5>$9.79</h5>
                </div>
              </div>
            </div>
            <div class="item">
              <div class="products-single fix">
                <div class="box-img-hover">
                  <img
                    src="images/img-pro-03.jpg"
                    class="img-fluid"
                    alt="Image"
                  />
                  <div class="mask-icon">
                    <ul>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="View"
                          ><i class="fas fa-eye"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Compare"
                          ><i class="fas fa-sync-alt"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Add to Wishlist"
                          ><i class="far fa-heart"></i
                        ></a>
                      </li>
                    </ul>
                    <a class="cart" href="#">Add to Cart</a>
                  </div>
                </div>
                <div class="why-text">
                  <h4>Lorem ipsum dolor sit amet</h4>
                  <h5>$9.79</h5>
                </div>
              </div>
            </div>
            <div class="item">
              <div class="products-single fix">
                <div class="box-img-hover">
                  <img
                    src="images/img-pro-04.jpg"
                    class="img-fluid"
                    alt="Image"
                  />
                  <div class="mask-icon">
                    <ul>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="View"
                          ><i class="fas fa-eye"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Compare"
                          ><i class="fas fa-sync-alt"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Add to Wishlist"
                          ><i class="far fa-heart"></i
                        ></a>
                      </li>
                    </ul>
                    <a class="cart" href="#">Add to Cart</a>
                  </div>
                </div>
                <div class="why-text">
                  <h4>Lorem ipsum dolor sit amet</h4>
                  <h5>$9.79</h5>
                </div>
              </div>
            </div>
            <div class="item">
              <div class="products-single fix">
                <div class="box-img-hover">
                  <img
                    src="images/img-pro-01.jpg"
                    class="img-fluid"
                    alt="Image"
                  />
                  <div class="mask-icon">
                    <ul>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="View"
                          ><i class="fas fa-eye"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Compare"
                          ><i class="fas fa-sync-alt"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Add to Wishlist"
                          ><i class="far fa-heart"></i
                        ></a>
                      </li>
                    </ul>
                    <a class="cart" href="#">Add to Cart</a>
                  </div>
                </div>
                <div class="why-text">
                  <h4>Lorem ipsum dolor sit amet</h4>
                  <h5>$9.79</h5>
                </div>
              </div>
            </div>
            <div class="item">
              <div class="products-single fix">
                <div class="box-img-hover">
                  <img
                    src="images/img-pro-02.jpg"
                    class="img-fluid"
                    alt="Image"
                  />
                  <div class="mask-icon">
                    <ul>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="View"
                          ><i class="fas fa-eye"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Compare"
                          ><i class="fas fa-sync-alt"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Add to Wishlist"
                          ><i class="far fa-heart"></i
                        ></a>
                      </li>
                    </ul>
                    <a class="cart" href="#">Add to Cart</a>
                  </div>
                </div>
                <div class="why-text">
                  <h4>Lorem ipsum dolor sit amet</h4>
                  <h5>$9.79</h5>
                </div>
              </div>
            </div>
            <div class="item">
              <div class="products-single fix">
                <div class="box-img-hover">
                  <img
                    src="images/img-pro-03.jpg"
                    class="img-fluid"
                    alt="Image"
                  />
                  <div class="mask-icon">
                    <ul>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="View"
                          ><i class="fas fa-eye"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Compare"
                          ><i class="fas fa-sync-alt"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Add to Wishlist"
                          ><i class="far fa-heart"></i
                        ></a>
                      </li>
                    </ul>
                    <a class="cart" href="#">Add to Cart</a>
                  </div>
                </div>
                <div class="why-text">
                  <h4>Lorem ipsum dolor sit amet</h4>
                  <h5>$9.79</h5>
                </div>
              </div>
            </div>
            <div class="item">
              <div class="products-single fix">
                <div class="box-img-hover">
                  <img
                    src="images/img-pro-04.jpg"
                    class="img-fluid"
                    alt="Image"
                  />
                  <div class="mask-icon">
                    <ul>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="View"
                          ><i class="fas fa-eye"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Compare"
                          ><i class="fas fa-sync-alt"></i
                        ></a>
                      </li>
                      <li>
                        <a
                          href="#"
                          data-toggle="tooltip"
                          data-placement="right"
                          title="Add to Wishlist"
                          ><i class="far fa-heart"></i
                        ></a>
                      </li>
                    </ul>
                    <a class="cart" href="#">Add to Cart</a>
                  </div>
                </div>
                <div class="why-text">
                  <h4>Lorem ipsum dolor sit amet</h4>
                  <h5>$9.79</h5>
                </div>
              </div>
            </div>
          </div>
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

export default {
  data() {
    return {
      authController:authController,
      user: {
        active: "-",
        birthdate: "-",
        email: "-",
        firstname: "-",
        id: "-",
        lastname: "-",
        phone: "-",
        photoUrl: "-",
        registrationDate: "-",
        registrationStatus: "-",
        roles: [],
        username: "-",
      },
    };
  },
  mounted() {
    const id = authController.getUserID();
    this.retrieveData(id);
  },
  methods: {
    retrieveData(id) {
      axios.get(API.GET_USER_BY_ID + id).then((response) => {
        this.user = response.data[0];
      });
    },
  },
};
</script>

