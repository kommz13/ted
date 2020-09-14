<template>
  <div class="profile">
    <SimpleTitleBox title="User profile"></SimpleTitleBox>
    <UserDetails> </UserDetails>
  </div>
</template>

<script>
import SimpleTitleBox from "@/components/common/SimpleTitleBox";
import UserDetails from "@/components/admin/UserDetails";

export default {
  components: {
    SimpleTitleBox,
    UserDetails,
  },
  mounted() {
    
  }
};
</script>

