import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  // {
  //   path: "/AirBnb",
  //   name: "Home",
  //   component: Home,
  // },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
  {
    path: "/admin/users/approved",
    name: "ApprovedUsers",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/admin/ApprovedUsers.vue"
      ),
  },
  {
    path: "/admin/users/rejected",
    name: "RejectedUsers",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/admin/RejectedUsers.vue"
      ),
  },
  {
    path: "/admin/users/pending",
    name: "PendingUsers",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/admin/PendingUsers.vue"),
  },
  {
    path: "/admin/export/xml",
    name: "ExportXML",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/admin/XML.vue"),
  },
  {
    path: "/admin/export/json",
    name: "ExportJSON",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/admin/JSON.vue"),
  },
  {
    path: "/register",
    name: "Register",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/guest/Register.vue"),
  },
  {
    path: "/login",
    name: "Login",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/guest/Login.vue"),
  },
  {
    path: "/account",
    name: "MyAccount",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AccountView.vue"),
  },
  {
    path: "/account/edit",
    name: "EditMyAccount",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AccountEdit.vue"),
  },
  {
    path: "/admin/profile/:id",
    name: "Profile",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/admin/Profile.vue"),
  },
  {
    path: "/host/listing/create",
    name: "Listing",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/host/ListingCreation.vue"
      ),
  },
  {
    path: "/host/listing/view/:id",
    name: "ListingViewByUserID",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/host/ListingViewById.vue"
      ),
  },
  {
    path: "/host/listing/update/:id",
    name: "ListingUpdate",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/host/ListingUpdate.vue"),
  },
  {
    path: "/host/listing/list",
    name: "ListingViewAllByUserId",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/host/ListingActive.vue"),
  },
  {
    path: "/host/listing/active",
    name: "ListingActiveForHost",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/host/ListingActive.vue"),
  },
  {
    path: "/host/listing/pending",
    name: "ListingPendingForHost",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/host/ListingPending.vue"
      ),
  },
  {
    path: "/host/listing/inactive",
    name: "ListingInactiveForHost",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/host/ListingInactive.vue"
      ),
  },
  {
    path: "/customer/booking/search",
    name: "ListingSearch",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/customer/ListingSearch.vue"
      ),
  },
  {
    path: "/mybookings/active",
    name: "BookingActiveForCustomers",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/customer/BookingActive.vue"
      ),
  },
  {
    path: "/mybookings/listing/view/:id",
    name: "BookingViewById",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/customer/BookingViewById.vue"
      ),
  },
  {
    path: "/mybookings/pending",
    name: "BookingPendingForCustomers",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/customer/BookingPending.vue"
      ),
  },
  {
    path: "/mybookings/previous",
    name: "BookingPreviousForCustomers",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/customer/BookingPrevious.vue"
      ),
  },
  {
    path: "/mybookings/rejected",
    name: "BookingRejectedForCustomers",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/customer/BookingRejected.vue"
      ),
  },
  
  
  {
    path: "/messages/received/",
    name: "MessageReceived",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/messages/MessageReceived.vue"
      ),
  },
  {
    path: "/messages/sent/",
    name: "MessageSent",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/messages/MessageSent.vue"
      ),
  },
  {
    path: "/messages/details/",
    name: "MessageDetails",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/messages/MessageDetails.vue"
      ),
  },
  {
    path: "/about",
    name: "AboutUs",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/About.vue"
      ),
  },
];

const router = new VueRouter({
  routes,
});

export default router;
