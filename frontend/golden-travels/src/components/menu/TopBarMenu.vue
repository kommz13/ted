<template>
  <!-- Start Main Top -->
  <div class="main-top">
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
          <div class="text-slid-box">
            <div id="offer-box">
              <ul class="offer-box">
                <li>
                  <i class="fab fa-opencart"></i> Welcome to Golden Travels,
                  have a good day!
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
          <input type="text" class="form-control" placeholder="Search" />
        </div>
        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
          <div class="custom-select-box"></div>
          <div class="right-phone-box">
            <p>Call US :- <a href="#"> +11 900 800 100</a></p>
          </div>
          <div class="our-link">
            <ul>
              <li><a href="#">My Account</a></li>
              <li>
                <router-link :to="{ path: '/register' }">Register</router-link>
              </li>

              <li><a href="#">Our location</a></li>
              <li><a href="#">Contact Us</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- End Main Top -->
</template>
