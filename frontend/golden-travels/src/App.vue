<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </div>

    <TopBarMenu></TopBarMenu>

    <HeaderMenu></HeaderMenu>

    <router-view />

    <Footer></Footer>

    <Copyright></Copyright>
  </div>
</template>

<script>
import TopBarMenu from "@/components/menu/TopBarMenu";
import HeaderMenu from "@/components/menu/Header";
import Copyright from "@/components/Copyright";
import Footer from "@/components/Footer";

export default {
  components: {
    TopBarMenu,
    HeaderMenu,
    Footer,
    Copyright,
  },
};
</script>
