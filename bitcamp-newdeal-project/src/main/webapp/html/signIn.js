'use strict'

$('#loginBtn').click(() => {
    $.post(`${serverApiAddr}/json/auth/signIn`, {
        'email': $('#fEmail').val(),
        'password': $('#fPassword').val(),
        'saveEmail': $('#fSaveEmail').prop('checked')
    }, (result) => {
        if (result.status === 'success') {
            location.href = 'photolog/form.html'
        } else {
            console.log(result.status)
            console.log(result.message)
            alert('로그인 실패!')
        }
    }, 'json')
    .fail(() => {
        alert('서버 요청 중 오류 발생!')
    });
});
