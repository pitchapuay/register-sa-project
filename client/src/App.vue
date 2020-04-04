<template>
  <v-app >
    <v-content class="orange lighten-4">
      <router-view />
    </v-content>
  </v-app>
</template>

<script>

export default {
  name: 'App',
  components: {
  },
  data: () => ({
    //
  }),
  computed:{
    theme(){
      return (this.$vuetify.theme.dark) ? 'dark' : 'light'
    }
}
};
</script>


  
