$(function(){

    var E = window.wangEditor;
    //这里的id为<div id="editor"中的id.
    var editor = new E('#editor');
    // 配置服务器端地址,也就是controller的请求路径，不带项目路径，前面没有/
    editor.customConfig.uploadImgServer = 'DictionariesController/sveDictionariesHero';
    //配置属性名称，绑定请求的图片数据
    //controller会用到，可以随便设置，但是一定要与controller一致
    editor.customConfig.uploadFileName = 'img';
    //创建编辑器
    editor.create();

    $("#editorSetBtn").click(function(){
        //这是设置编辑器内容
        editor.txt.html("dsafdfadsfdafdsfds");
    })
    $("#editorGetBtn1").click(function(){
        //获取编辑器的内容，带样式
        //一般使用这个获取数据，通过ajax发送给服务端　，然后服务端以Ｓtring接收，保存到数据库．
        alert(editor.txt.html());
    })
    $("#editorGetBtn2").click(function(){
        //获取编辑器的内容，不带样式，纯文本
        alert(editor.txt.text());
    })
})