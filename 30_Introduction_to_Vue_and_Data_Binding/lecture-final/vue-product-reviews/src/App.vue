<template>
  <div id="app">
    <product-review></product-review>
    <add-email></add-email>
  </div>
</template>

<script>
import ProductReview from './components/ProductReview.vue'
import AddEmail from './components/AddEmail'

export default {
  name: 'App',
  components: {
    ProductReview,
    AddEmail
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
</style>
