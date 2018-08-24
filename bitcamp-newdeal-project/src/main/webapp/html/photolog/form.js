'use strict'

$('#add-btn').click(() => {
    $.post(`${serverApiAddr}/json/photolog/add`, {
        'no': '3',
        'memberNo': '2',
        'date': $('#f-date').val(),
        'title': $('#f-title').val(),
        'memo': $('#f-memo').val()
    }, (result) => {
        console.log(result);
    }, 'json')
    .fail(() => {
        console.log(result.status),
        console.log(result.message)
        alert('포토로그 추가 중에 오류 발생!')
    });
});






