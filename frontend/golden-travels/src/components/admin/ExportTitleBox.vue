<template>
  <!-- Start All Title Box -->
  <div class="all-title-box">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h2>Users</h2>
          <ul class="breadcrumb">
            <li class="breadcrumb-item">
              <router-link :to="{ path: '/admin/users/JSON' }"
                >JSON</router-link
              >
            </li>
            <li class="breadcrumb-item active">
              <router-link :to="{ path: '/admin/users/xml' }">XML</router-link>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <!-- End All Title Box -->
</template>
