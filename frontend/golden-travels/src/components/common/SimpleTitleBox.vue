<template>
  <div class="all-title-box">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h2>{{ title }}</h2>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["title"]
};
</script>