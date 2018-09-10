Vue.use(Vuex);
var store = new Vuex.Store({
    state: {
        loading: false
    },
    mutations: {
        SETLOADING: function (state, num) {
            state.Loading = num;
        }
    },
    actions: {
        setLoading: function (commit, num) {
            commit('SETLOADING', num);
        },
    },
    getters: {
        showLoading: function(state){state.Loading} //loading
    }

});
