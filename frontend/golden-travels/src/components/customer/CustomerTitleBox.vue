<template>
  <!-- Start All Title Box -->
  <div class="all-title-box">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h2>Bookings {{ content }}</h2>
          <ul class="breadcrumb">
            <li class="breadcrumb-item">
              <router-link :to="{ path: '/mybookings/active/:id' }"
                >Active</router-link
              >
            </li>
            <li class="breadcrumb-item active">
             <router-link :to="{ path: '/mybookings/pending/' }"
                >Pending</router-link
              >
            </li>
             <li class="breadcrumb-item active">
              <router-link :to="{ path: '/mybookings/previous/' }"
                >Previous</router-link
              >
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <!-- End All Title Box -->
</template>

<script>
export default {
  props: ["content"]
};
</script>
