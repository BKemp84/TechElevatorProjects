<template>
    <div id="addemail">
        <h1>Add Email</h1>
        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" v-model.trim="name" />
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="text" id="email" v-model.trim="email" />
        </div>
        <div>
            <label for="emailType">Email Type</label>
            <select id="emailType" v-model="emailType">
                <option value="HOME">Home</option>
                <option value="WORK">Work</option>
                <option value="OTHER">Other</option>
            </select>
        </div>
        <div>
            <div>Name: {{ name }}</div>
            <div>Email: {{ email }}</div>
            <div>Email Type: {{ emailType }}</div>

        </div>
    </div>
</template>

<script>
export default {
    name: 'add-email',
    data() {
        return {
            name: '',
            email: '',
            emailType: ''
        }
    }
}
</script>

<style>

</style>