<template>
  <v-data-table
    :headers="headers"
    :items="users"
    :items-per-page="5"
    class="elevation-1"
  >
    <template v-slot:[`item.edit`]="{ item }">
      <v-btn color="success" @click="editItem(item)">Edit</v-btn>
    </template>
    <template v-slot:[`item.delete`]="{ item }">
      <v-btn color="warning" @click="deleteItem(item.id)">Delete</v-btn>
    </template>
    <template v-slot:[`item.view`]="{ item }">
      <v-btn color="primary" @click="goTo(item.id)">View</v-btn>
    </template>
  </v-data-table>
</template>

<script>
export default {
  data() {
    return {
      headers: [
        { text: "Name", value: "name" },
        { text: "Email ", value: "email" },
        { text: "Password ", value: "password" },
        { button: "Edit ", value: "edit" },
        { button: "Delete ", value: "delete" },
      ],
    };
  },
  computed: {
    users() {
      return this.$store.state.users.data;
    },
  },
  async fetch() {
    this.$store.commit(
      "users/storeData",
      (await this.$axios.get("http://localhost:8080/users/")).data
    );
  },
  methods: {
    async deleteItem(id) {
      await this.$axios.delete("http://localhost:8080/users/" + id);
      this.$store.commit(
        "users/storeData",
        (await this.$axios.get("http://localhost:8080/users/")).data
      );
    },
    async editItem(user) {
      this.$store.commit("user/storeId", user.id);
      this.$store.commit("user/storeName", user.name);
      this.$store.commit("user/storeEmail", user.email);
      this.$store.commit("user/storePassword", user.password);
    },
  },
};
</script>

<style></style>
