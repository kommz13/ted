<template>
  <div class="about">
    <h1>This is Page one</h1>
    <button @click="f">click me to say hello !</button>
    <label>value of x is:</label>
    <input type="number" v-model="x">

    <p>Value of x is : {{ x }} </p>
    <p>Value of x is : {{ x }} </p>
    <p>Value of x is : {{ x }} </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
       x : 0
    };
  },
  methods: {
    f() {
      this.x++;

      console.log("hello, value of x is: " + this.x);
    }
  }
};
</script>
