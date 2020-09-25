<template>
  <div class="profile">
    <SimpleTitleBox title="My account"></SimpleTitleBox>
    <EditDetails> </EditDetails>
  </div>
</template>

<script>
import SimpleTitleBox from "@/components/common/SimpleTitleBox";
import EditDetails from "@/components/user/EditDetails";

export default {
  components: {
    SimpleTitleBox,
    EditDetails,
  },
};
</script>
