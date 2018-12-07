"use strict"

var data = null;
var {name, page, size} = $.parseQuery(location.href);

$(eAddBtn).click(function() {
    $.post(serverApiAddr + '/json/member/add',
        {
            email: $(eEmail).val(),
            name: $(eName).val(),
            password: $(ePassword).val()
        },
        function(data) {
            location.href = 'form.html';
        },
        'json');
});
