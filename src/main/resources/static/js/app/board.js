var board = {

    init : function() {

       var _this = this;

        $('#btn-save').on('click', function() {

            _this.save();
        });

        $('#btn-update-before').on('click', function(){

            var email = $('#user-email').val()
            var author = $('#author').val()

            console.log(email)
            console.log(author)

            if(email != author) {

                alert("로그인 사용자가 일치하지않습니다.")
                location.reload();
            }
        });

        $('#btn-update').on('click', function() {

           _this.update();
        });

        $('#btn-delete').on('click', function() {

            var email = $('#user-email').val()
            var author = $('#author').val()

                   if(email === author) {
                       _this.delete();
                   }else {
                       alert("로그인 사용자가 일치하지않습니다.")
                   }
        });

    },

    save : function() {

        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val(),

        };

        $.ajax({
            type: 'POST',
            url: '/api/board',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('등록 되었습니다. ')
            window.location.href = '/board';
        }).fail(function (error) {
            alert('로그인을 해주세요')
        });
    },

    update : function() {

        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

            $.ajax({
                type: 'PUT',
                url: '/api/board/' + id,
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('글이 수정되었습니다')
                window.location.href = "/board/detail/" + id;
            }).fail(function(error) {
               console.log(JSON.stringify(error))
            });
    },

    delete : function() {

        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/board/' + id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert("삭제되었습니다.");
            window.location.href = '/board';
        }).fail(function(error){
            console.log(JSON.stringify(error));
        })
    }

};

board.init();