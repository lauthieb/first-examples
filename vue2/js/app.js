Vue.directive('salut', {
    bind: function(el, binding, vnode) {
        el.value = binding.value;
    },
    update: function(el, binding, vnode, oldvnode) {
        console.log('update');
    },
});

let vm = new Vue({
    el: '#app',
    data: {
        message: 'Hello World',
        seconds: 0,
        link: 'http://google.fr',
        success: true,
        persons: ['Laurent', 'Tanguy', 'Ludovic'],
        firstName: 'Laurent',
        lastName: 'THIEBAULT'
    },
    methods: {
        close: function() {
            console.log('close called');
            this.success = false;
            this.message = 'fermé';
        },
        demo: function() {
            console.log('demo');
        },
        demo2: function() {
            console.log('demo2');
        }
    },
    computed: {
        cls: function() {
            console.log('cls called');
            return this.success ? 'success' : 'error';
        },
        fullName: {
            get: function() {
                return this.firstName + ' ' + this.lastName;
            },
            set: function(value) {
                let parts = value.split(' ');
                this.firstName = parts[0];
                this.lastName = parts[1];
            }
        }
    },
    watch: {
        message: function(value) {
            console.log(value);
        }
    },
    mounted: function () {
        setInterval(() => {
            this.seconds++;
        }, 1000);
    }
});