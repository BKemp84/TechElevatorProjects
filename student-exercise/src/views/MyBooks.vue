<template>
<div class="reading-list">
  <reading-list/>
      <nav> 
      <router-link to="/addBook">Add Book to Reading List</router-link>   

     </nav>
</div>
</template>

<script>
 import ReadingList from '@/components/ReadingList.vue'

export default {

    name: 'my-books',
    components: {
        ReadingList
    },
    props: ['book']
   
}
</script>

<style>

</style>