$(function(){
$.ajax({
    type: "POST",
    data: formData,
    url: "http://localhost:8080/tiantian/DictionariesController/getDictionariesHeroList",
    contentType : false,
    processData: false,
    async: false
}).success(function (result) { 
    for (var i=0,l=result.data.length; i<l; i++){
       if(result.data.heroType==1){
        var v=new Vue({
            el : '#most',
            data : {
                ResponseResult : result.data[0] 
            }
        });
       }
          
      
    }
})
});