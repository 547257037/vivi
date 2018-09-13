/*提交表单*/

$(".alert").hide()

$("#btnImportOK").click(function () {

    var formData = new FormData($("#save-hero-form")[0]);
    $.ajax({
        type: "POST",
        data: formData,
        url: "http://localhost:8080/tiantian/DictionariesController/sveDictionariesHero",
        contentType : false,
        processData: false,
        async: false
    }).success(function (result) {        
            var v=new Vue({
                el : '#tabel',
                data : {
                    ResponseResult : result 
                }
            });
            $(".alert").show();       
            setTimeout(function(){$(".alert").hide()}, 3000);      
    })
});

