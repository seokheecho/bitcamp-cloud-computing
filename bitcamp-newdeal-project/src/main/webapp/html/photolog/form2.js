'use strict'


$('#add-btn').click(() => {
    $.post(`${serverApiAddr}/json/photolog/add`, {
        'date': $('#f-date').val(),
        'title': $('#f-title').val(),
        'memo': $('#f-memo').val(),
        'photo': $('#f-fileupload').val()
    }, (result) => {
        console.log(result);
    }, 'json')
    .fail(() => {
        console.log(result.status),
        console.log(result.message)
        alert('포토로그 추가 중에 오류 발생!')
    });
});

/*
$('#fileupload').fileupload({
  url: `${serverApiAddr}/json/photolog/add`,        // 서버에 요청할 URL
  dataType: 'json',         // 서버가 보낸 응답이 JSON임을 지정하기
  sequentialUploads: true,  // 여러 개의 파일을 업로드 할 때 순서대로 요청하기.
  singleFileUploads: false, // 한 요청에 여러 개의 파일을 전송시키기.
  autoUpload: false,        // 파일을 추가할 때 자동 업로딩 하지 않도록 설정.
  disableImageResize: /Android(?!.*Chrome)|Opera/
        .test(window.navigator && navigator.userAgent), // 안드로이드와 오페라 브라우저는 크기 조정 비활성 시키기
  previewMaxWidth: 100,   // 미리보기 이미지 너비
  previewMaxHeight: 100,  // 미리보기 이미지 높이 
  previewCrop: true,      // 미리보기 이미지를 출력할 때 원본에서 지정된 크기로 자르기
  processalways: function(e, data) {
      console.log('fileuploadprocessalways()...');
      console.log(data.files);
      var imagesDiv = $('#images-div');
      imagesDiv.html("");
      for (var i = 0; i < data.files.length; i++) {
        try {
          if (data.files[i].preview.toDataURL) {
            $("<img>")
              .attr('src', data.files[i].preview.toDataURL())
              .css('height', '80px')
              .appendTo(imagesDiv);
          }
        } catch (err) {}
      }
      $('#add-btn').unbind("click");
      $('#add-btn').click(function() {
          data.submit();
      });
  }, 
  submit: function (e, data) { // 서버에 전송하기 직전에 호출된다.
    console.log('submit()...');
    data.formData = {
            date: $('#f-date').val(),
            title: $('#f-title').val(),
            memo: $('#f-memo').val()
    };
  }, 
  done: function (e, data) { // 서버에서 응답이 오면 호출된다. 각 파일 별로 호출된다.
    console.log('done()...');
    console.log(data.result);
    $('<p/>').text("date : " + data.result.date).appendTo(document.body);
    $('<p/>').text("title : " + data.result.title).appendTo(document.body);
    $('<p/>').text("memo : " + data.result.memo).appendTo(document.body);
    $.each(data.result.filenames, function(index, filename) {
      $('<p/>').text(filename).appendTo(document.body);
    });
  }
});

*/



