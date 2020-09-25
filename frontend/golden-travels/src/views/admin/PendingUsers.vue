<template>
  <div>
    <!-- Start All Title Box -->
    <UserTitleBox content="Pending"></UserTitleBox>
    <!-- End All Title Box -->

    <!-- Start Tablert  -->
    <div class="cart-box-main">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="table-main table-responsive">
              <table class="table">
                <thead>
                  <tr>
                    <th>Photo</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Username</th>
                    <th>E-mail</th>
                    <!-- <th>Birthday</th> -->
                    <th>Phone</th>
                    <!-- <th>Registered at</th> -->
                    <th>Roles</th>
                    <th>&nbsp;</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="u in filtered_users" :key="u.id">
                    <td class="thumbnail-img">
                      <a href="#">
                        <img class="img-fluid" :src="u.photoUrl" alt="" />
                      </a>
                    </td>
                    <td>
                      {{ u.id }}
                    </td>
                    <td class="name-pr">
                      <router-link
                        :to="{ name: 'Profile', params: { id: u.id } }"
                        >{{ u.firstname }} {{ u.lastname }}</router-link
                      >
                    </td>
                    <td class="name-pr">
                      {{ u.username }}
                    </td>
                    <td class="name-pr">
                      {{ u.email }}
                    </td>
                    <!-- <td class="name-pr">
                      {{ u.birthdate }}
                    </td>                                         -->
                    <td class="total-pr">
                      {{ u.phone }}
                    </td>
                    <td>
                      <div
                        class="badge badge-success"
                        v-for="r in u.roles"
                        :key="r.id"
                      >
                        {{ r.name }}
                      </div>
                    </td>
                    <td class="total-pr">
                      <button
                        type="button"
                        @click="approveUser(u.id)"
                        class="btn btn-primary"
                      >
                        Approve
                      </button>
                      <button
                        type="button"
                        @click="rejectUser(u.id)"
                        class="btn btn-primary"
                      >
                        Reject
                      </button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div class="add-to-btn">
              <div class="add-comp">
                Page {{ page }} of {{ maxpages }} - {{ users.length }}
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
      </div>
    </div>
    <!-- End Cart -->
  </div>
</template>

<script>
import axios from "axios";
import UserTitleBox from "@/components/admin/UserTitleBox";
import API from "@/api/Api.js";
import PaginationMixin from "@/mixins/PaginationMixin";

export default {
  components: {
    UserTitleBox,
  },
  mixins: [PaginationMixin],
  data() {
    return {
      users: [],
    };
  },
  computed: {
    filtered_users() {
      return this.getPage(this.users);
    },
  },
  mounted() {
    console.clear();
    console.log("Mounted called");

    this.retrieveData();
  },
  methods: {
    retrieveData() {
      axios.get(API.GET_PENDING_USERS).then((response) => {
        this.users = response.data;
      });
    },
    approveUser(id) {
      console.log("id clicked: " + id);

      axios.post(API.APPROVE_PENDING_USER + id).then((response) => {
        if (response.status == 200) {
          this.retrieveData();
        }
      });
    },
    rejectUser(id) {
      console.log("id clicked: " + id);

      axios.post(API.REJECT_PENDING_USER + id).then((response) => {
        if (response.status == 200) {
          this.retrieveData();
        }
      });
    },
  },
};
</script>
