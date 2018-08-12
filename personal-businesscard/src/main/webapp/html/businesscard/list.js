"use strict"

var data = null;
var {id, page, size} = $.parseQuery(location.href);

$(eAddBtn).click(function() {
    $.post(serverApiAddr + '/json/auth',
        {
            email: $(eEmail).val(),
            password: $(ePassword).val()
        },
        function(data) {
            location.href = 'form.html';
        },
        'json');
});
