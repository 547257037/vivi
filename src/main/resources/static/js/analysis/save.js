/*提交表单*/

$("#test").click(function(){

})
$("#test1").click(function(){

})

$("#btnImportOK").click(function () {

    var formData = new FormData($("#save-hero-form")[0]);
    $.ajax({
        type: "POST",
        data: formData,
        url: "http://localhost:8080/tiantian/DictionariesController/sveDictionariesHero",
        contentType : false,
        processData: false,
        async: false
    }).success(function (data) {
        if(data.success){
            swal("Good!", data, "success");
            $(window).attr('location','http://localhost:8080/tiantian/index.html');
        }else{
            swal("OMG!", data, "error");
        }
    })
});