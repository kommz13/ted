<template>
  <header class="main-header">
    <!-- Start Navigation -->
    <nav
      class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav"
    >
      <div class="container">
        <!-- Start Header Navigation -->
        <div class="navbar-header">
          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbar-menu"
            aria-controls="navbars-rs-food"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <i class="fa fa-bars"></i>
          </button>
          <a class="navbar-brand" href="index.html"
            ><img src="images/logo.png" class="logo" alt=""
          /></a>
        </div>
        <!-- End Header Navigation -->

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-menu">
          <ul
            class="nav navbar-nav ml-auto"
            data-in="fadeInDown"
            data-out="fadeOutUp"
          >
            <li class="nav-item active">
              <router-link class="nav-link" :to="{ path: '/' }">
                Search
              </router-link>
            </li>
            <li class="dropdown megamenu-fw" v-if="showAdministratorOption()">
              <a
                href="#"
                class="nav-link dropdown-toggle arrow"
                data-toggle="dropdown"
                >Administrator</a
              >
              <ul class="dropdown-menu megamenu-content" role="menu">
                <li>
                  <div class="row">
                    <div class="col-menu col-md-6">
                      <h6 class="title">Users</h6>
                      <div class="content">
                        <ul class="menu-col">
                          <li>
                            <router-link :to="{ path: '/admin/users/approved' }"
                              >Approved</router-link
                            >
                          </li>
                          <li>
                            <router-link :to="{ path: '/admin/users/rejected' }"
                              >Rejected</router-link
                            >
                          </li>
                          <li>
                            <router-link :to="{ path: '/admin/users/pending' }"
                              >Pending</router-link
                            >
                          </li>
                        </ul>
                      </div>
                    </div>
                    <!-- end col-3 -->
                    <div class="col-menu col-md-6">
                      <h6 class="title">Export</h6>
                      <div class="content">
                        <ul class="menu-col">
                          <li>
                            <router-link :to="{ path: '/admin/export/json' }"
                              >JSON</router-link
                            >
                          </li>
                          <li>
                            <router-link :to="{ path: '/admin/export/xml' }"
                              >XML</router-link
                            >
                          </li>
                        </ul>
                      </div>
                    </div>
                    <!-- end col-3 -->
                  </div>
                  <!-- end row -->
                </li>
              </ul>
            </li>

            <li class="dropdown" v-if="showCustomerOption()">
              <a
                href="#"
                class="nav-link dropdown-toggle arrow"
                data-toggle="dropdown"
                >Customer</a
              >
              <ul class="dropdown-menu">
                <!-- <li>
                            <router-link :to="{ path: '/admin/users/approved' }"
                              >Approved</router-link
                            >
                          </li> -->
                <li>
                  <router-link :to="{ path: '/mybookings/active' }"
                    >My bookings</router-link
                  >
                </li>
              </ul>
            </li>

            <li class="dropdown" v-if="showHostOption()">
              <a
                href="#"
                class="nav-link dropdown-toggle arrow"
                data-toggle="dropdown"
                >Host</a
              >
              <ul class="dropdown-menu">
                <li>
                  <router-link :to="{ path: '/host/listing/create' }"
                    >Create listing</router-link
                  >
                </li>
                <!-- <li>
                            <router-link :to="{ path: '/admin/users/approved' }"
                              >Approved</router-link
                            >
                          </li> -->

                <li>
                  <router-link :to="{ path: '/host/listing/list/' }"
                    >View my listings</router-link
                  >
                </li>
                <!-- <li>
                  <router-link :to="{ path: '/host/listing/active/' }"
                    >Active listings</router-link
                  >
                </li>
                <li>
                  <router-link :to="{ path: '/host/listing/inactive/' }"
                    >Inactive listings</router-link
                  >
                </li> -->
              </ul>
            </li>
            <li class="dropdown" v-if="showSessionOptions()">
              <a
                href="#"
                class="nav-link dropdown-toggle arrow"
                data-toggle="dropdown"
                >Messages</a
              >
              <ul class="dropdown-menu">
                <!-- <li>
                            <router-link :to="{ path: '/admin/users/approved' }"
                              >Approved</router-link
                            >
                          </li> -->
                <li>
                  <router-link :to="{ path: '/messages/received/' }"
                    >Inbox</router-link
                  >
                </li>
                <li>
                  <router-link :to="{ path: '/messages/sent/' }"
                    >Outbox</router-link
                  >
                </li>
                <!-- <li><a href="checkout.html">View my active listings</a></li>
                <li><a href="my-account.html">View my inactive listings</a></li> -->
              </ul>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" :to="{ path: '/about' }"
                >About</router-link
              >
            </li>

            <!-- <li class="dropdown">
              <a
                href="#"
                class="nav-link dropdown-toggle arrow"
                data-toggle="dropdown"
                >SHOP</a
              >
              <ul class="dropdown-menu">
                <li><a href="cart.html">Cart</a></li>
                <li><a href="checkout.html">Checkout</a></li>
                <li><a href="my-account.html">My Account</a></li>
                <li><a href="wishlist.html">Wishlist</a></li>
                <li><a href="shop-detail.html">Shop Detail</a></li>
              </ul>
            </li> -->

            <!-- <li class="nav-item">
              <a class="nav-link" href="service.html">Our Service</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="contact-us.html">Contact Us</a>
            </li> -->
          </ul>
        </div>
      </div>
    </nav>
    <!-- End Navigation -->
  </header>
  <!-- End Main Top -->
</template>

<script>
import authController from "@/auth/AuthController";

export default {
  data() {
    return {
      authController: authController,
    };
  },
  methods: {
    showAdministratorOption() {
      return authController.isAdmin() == true;
    },
    showHostOption() {
      return authController.isHost() == true;
    },
    showGuestOption() {
      return authController.isLoggedIn() == false;
    },
    showCustomerOption() {
      return authController.isCustomer() == true;
    },
    showSessionOptions() {
      return authController.isCustomer() == true || authController.isHost() == true || authController.isAdmin() == true;
    }
  },
};
</script>
