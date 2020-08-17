<template>
  <table id="tblUsers">
    <thead>
      <tr class>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
      </tr>
    </thead>

    <tbody>
      <tr>
        <td>
          <input v-model="filter.firstName" type="text" id="firstNameFilter" />
        </td>
        <td>
          <input v-model="filter.lastName" type="text" id="lastNameFilter" />
        </td>
        <td>
          <input v-model="filter.username" type="text" id="usernameFilter" />
        </td>
        <td>
          <input v-model="filter.emailAddress" type="text" id="emailFilter" />
        </td>
        <td>
          <select v-model="filter.status" id="statusFilter">
            <option value>Show All</option>
            <option value="Active">Active</option>
            <option value="Disabled">Disabled</option>
          </select>
        </td>
      </tr>
      <tr v-for="user in filteredList" v-bind:key="user.firstName">
        <td>{{user.firstName}}</td>
        <td>{{user.lastName}}</td>
        <td>{{user.username}}</td>
        <td>{{user.emailAddress}}</td>
        <td>{{user.status}}</td>
      </tr>
      <!-- user listing goes here -->
    </tbody>
  </table>
</template>

<script>
export default {
  name: "user-list",
  data() {
    return {
      users: [
        {
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active"
        },
        {
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active"
        },
        {
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Disabled"
        },
        {
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active"
        },
        {
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active"
        },
        {
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Disabled"
        }
      ],
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: ""
      }
    };
  },
  computed: {
    filteredList() {
      let userList = this.users;

      if (this.filter.firstName != "") {
        userList = userList.filter(user =>
          user.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }  if (this.filter.lastName != "") {
        userList = userList.filter(user =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }  if (this.filter.username != "") {
        userList = userList.filter(user =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );

        } if (this.filter.emailAddress != "") {
        userList = userList.filter(user =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
        }
       if (this.filter.status != "") {
        userList = userList.filter(user =>
          user.status
            .toLowerCase()
            .includes(this.filter.status.toLowerCase())
        );
      }
      return userList;
    }
  }
};
</script>


<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input,
select {
  font-size: 16px;
}
</style>
