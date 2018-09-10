
$("#save-hero-form").submit(function(){
    alert("提交");
    ajaxSubmit();
}); 

/*提交表单*/
function ajaxSubmit() {
    alert("123")
    $("#save-hero-form").ajaxSubmit({
        type : 'post',
        url : "/DictionariesController/getDictionariesHeroList", //变量
        error : function() {//请求失败处理函数  
            alert("失败");
        },
        success : function(data) { //请求成功后处理函数。
            alert("成功");
        }
    });
}