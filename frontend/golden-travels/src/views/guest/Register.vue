<template>
  <div class="register">
    <SimpleTitleBox title="Register"></SimpleTitleBox>
    <RegisterForm></RegisterForm>
  </div>
</template>

<script>
import SimpleTitleBox from "@/components/common/SimpleTitleBox";
import RegisterForm from "@/components/forms/RegisterForm.vue";

export default {
  components: {
    SimpleTitleBox,
    RegisterForm
  },
};
</script>
