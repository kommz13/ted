<template>
  <div id="app">
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
