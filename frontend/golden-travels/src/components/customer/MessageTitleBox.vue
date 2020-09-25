<template>
  <!-- Start All Title Box -->
  <div class="all-title-box">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h2>Messages</h2>
          <ul class="breadcrumb">
            <li class="breadcrumb-item">
              <router-link :to="{ path: '/messages/received/' }"
                >Inbox</router-link
              >
            </li>
            <li class="breadcrumb-item active">
              <router-link :to="{ path: '/messages/sent/' }"
                >Outbox</router-link
              >
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <!-- End All Title Box -->
</template>

