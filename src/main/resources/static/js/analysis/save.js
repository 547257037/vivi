/*提交表单*/

$("#btnImportOK").click(function () {

    var formData = new FormData($("#save-hero-form")[0]);
        $.ajax({
            type: 'POST',
            data: formData,
            url: 'http://localhost:8080/tiantian/DictionariesController/sveDictionariesHero',
            contentType : false,
            processData: false,
        }).success(function (data) {

        })
});