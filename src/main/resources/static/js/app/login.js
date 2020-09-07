var login = {

    init : function() {

        var _this = this;

        $('#btn-loginCancel').on('click', function() {

            _this.cancel();
        });

        $('#btn-logoutCancel').on('click', function() {

            _this.cancel();
        })

    },

    cancel : function() {

       location.reload();
    }
}

login.init();