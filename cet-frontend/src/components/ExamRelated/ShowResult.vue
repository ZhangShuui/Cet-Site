<script setup>

import {onMounted, reactive} from "vue";
import { inject } from 'vue';

const examResult = inject('sharedList');


onMounted(()=> {

  console.log(examResult)
})


</script>

<template>

</template>

<style scoped>

</style>