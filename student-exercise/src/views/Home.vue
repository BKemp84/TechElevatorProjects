<template>
<div class="books">
    <best-seller-list/>
    <new-releases-list/>

</div>
</template>

<script>

import BestSellerList from "@/components/BestSellerList.vue"
import NewReleasesList from "@/components/NewReleasesList.vue"

export default {
props: ["book"],
name: 'books',

    components : {
     BestSellerList,
     NewReleasesList

    },
   

}
</script>

<style>

</style>