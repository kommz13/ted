<template>
  <div class="Login">
    <SimpleTitleBox title="Login"></SimpleTitleBox>
    <LoginForm></LoginForm>
  </div>
</template>

<script>
import SimpleTitleBox from "@/components/common/SimpleTitleBox";
import LoginForm from "@/components/forms/LoginForm.vue";

export default {
  components: {
    SimpleTitleBox,
    LoginForm
  },
};
</script>
