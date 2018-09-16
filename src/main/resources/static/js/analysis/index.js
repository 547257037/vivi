$(function(){
    $(document).ready(function() {
		
        $("#owl-demo-1").owlCarousel({
          items : 4,
          lazyLoad : true,
          navigation : true
        });
        $("#owl-demo-2").owlCarousel({
          items : 4,
          lazyLoad : true,
          navigation : true
        });
        $("#owl-demo-3").owlCarousel({
          items : 4,
          lazyLoad : true,
          navigation : true
        });
      });
// $.ajax({
//     type: "get",
//     url: "analysis/test.json",
//     dataType: "jsonp",
//     jsonp: "callback",
//     jsonpCallback:"flightHandler",
//     success:function (result) { 
    var result = {
        "data": {
            "strongest": [
                {
                    "heroName": "admin",
                    "heroPassword": "21232f297a57a5a743894a0e4a801fc3",
                    "heroType": 0,
                    "createTime": "2018-09-13 09:18:18.693489",
                    "heroLv": 0,
                    "updateTime": "2018-09-13 09:18:18.693489",
                    "heroPrice": 0,
                    "imgPath": ["E:\\tiantia\\src\\main\\resources\\static\\images\\4.jpg"],
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\bootstrap_3.3.7_css_bootstrap.min.css,E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\deprecated-list.html",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "婆婆",
                    "heroPassword": "21232f297a57a5a743894a0e4a801fc3",
                    "heroType": 0,
                    "createTime": "2018-09-13 09:47:46.911466",
                    "heroLv": 0,
                    "updateTime": "2018-09-13 09:47:46.911466",
                    "heroPrice": 0,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\123.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\123.csv",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "天天",
                    "heroPassword": "e10adc3949ba59abbe56e057f20f883e",
                    "heroType": 0,
                    "createTime": "2018-09-14 03:24:32.958993",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 03:24:32.958993",
                    "heroPrice": 0,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\111.xlsx",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\123.csv",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "77",
                    "heroPassword": "21232f297a57a5a743894a0e4a801fc3",
                    "heroType": 0,
                    "createTime": "2018-09-14 03:27:12.97836",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 03:27:12.97836",
                    "heroPrice": 0,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\bootstrap_3.3.7_css_bootstrap.min.css",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\deprecated-list.html",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "天天1",
                    "heroPassword": "c81e728d9d4c2f636f067f89cc14862c",
                    "heroType": 0,
                    "createTime": "2018-09-14 06:44:15.227286",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 06:44:15.227286",
                    "heroPrice": 2,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\LT 8,01-8,31.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\123.csv",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "天天8",
                    "heroPassword": "c9f0f895fb98ab9159f51fd0297e236d",
                    "heroType": 0,
                    "createTime": "2018-09-14 06:45:12.744375",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 06:45:12.744375",
                    "heroPrice": 0,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\123.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\111.xlsx",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "8",
                    "heroPassword": "c9f0f895fb98ab9159f51fd0297e236d",
                    "heroType": 0,
                    "createTime": "2018-09-14 06:46:00.183762",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 06:46:00.183762",
                    "heroPrice": 8,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\123.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\111.xlsx",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "777",
                    "heroPassword": "8f14e45fceea167a5a36dedd4bea2543",
                    "heroType": 0,
                    "createTime": "2018-09-14 06:51:53.693955",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 06:51:53.693955",
                    "heroPrice": 7,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\123.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\123.csv",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "admin88888",
                    "heroPassword": "21232f297a57a5a743894a0e4a801fc3",
                    "heroType": 0,
                    "createTime": "2018-09-14 06:55:25.482668",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 06:55:25.482668",
                    "heroPrice": 0,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\111.xlsx",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\123.csv",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "admin5555",
                    "heroPassword": "6074c6aa3488f3c2dddff2a7ca821aab",
                    "heroType": 0,
                    "createTime": "2018-09-14 07:43:32.619843",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 07:43:32.619843",
                    "heroPrice": 5,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\123.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\111.xlsx",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "88",
                    "heroPassword": "2a38a4a9316c49e5a833517c45d31070",
                    "heroType": 0,
                    "createTime": "2018-09-14 07:46:52.232105",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 07:46:52.232105",
                    "heroPrice": 8,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\123.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\123.csv",
                    "videoFiles": null,
                    "imageFiles": null
                }
            ],
            "type0": [
                {
                    "heroName": "1",
                    "heroPassword": "1",
                    "heroType": 1,
                    "createTime": "2018-09-03 01:36:45.129832",
                    "heroLv": 0,
                    "updateTime": "2018-09-04 01:38:22.87714",
                    "heroPrice": 0,
                    "imgPath": "1",
                    "describe": null,
                    "videoPath": "1",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "爸爸",
                    "heroPassword": "e10adc3949ba59abbe56e057f20f883e",
                    "heroType": 1,
                    "createTime": "2018-09-14 06:40:22.794245",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 06:40:22.794245",
                    "heroPrice": 0,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\123.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\deprecated-list.html",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "天天2",
                    "heroPassword": "c81e728d9d4c2f636f067f89cc14862c",
                    "heroType": 1,
                    "createTime": "2018-09-14 06:43:40.206406",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 06:43:40.206406",
                    "heroPrice": 0,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\123.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\123.csv",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "admin0",
                    "heroPassword": "cfcd208495d565ef66e7dff9f98764da",
                    "heroType": 1,
                    "createTime": "2018-09-14 06:49:42.944285",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 06:49:42.944285",
                    "heroPrice": 0,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\123.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\111.xlsx",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "8888",
                    "heroPassword": "2a38a4a9316c49e5a833517c45d31070",
                    "heroType": 1,
                    "createTime": "2018-09-14 07:24:15.026417",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 07:24:15.026417",
                    "heroPrice": 8,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\LT 8,01-8,31.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\111.xlsx",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "3",
                    "heroPassword": "2",
                    "heroType": 2,
                    "createTime": "2018-09-04 01:39:10.729825",
                    "heroLv": 0,
                    "updateTime": "2018-09-04 01:39:10.729825",
                    "heroPrice": 2,
                    "imgPath": "1",
                    "describe": null,
                    "videoPath": "2",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "2",
                    "heroPassword": "2",
                    "heroType": 2,
                    "createTime": "2018-09-04 01:40:14.503589",
                    "heroLv": 0,
                    "updateTime": "2018-09-04 01:40:14.503589",
                    "heroPrice": 0,
                    "imgPath": null,
                    "describe": null,
                    "videoPath": null,
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "55",
                    "heroPassword": "b53b3a3d6ab90ce0268229151c9bde11",
                    "heroType": 2,
                    "createTime": "2018-09-14 07:39:28.281305",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 07:39:28.281305",
                    "heroPrice": 5,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\LT 8,01-8,31.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\123.csv",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "3",
                    "heroPassword": "2",
                    "heroType": 2,
                    "createTime": "2018-09-04 01:39:10.729825",
                    "heroLv": 0,
                    "updateTime": "2018-09-04 01:39:10.729825",
                    "heroPrice": 2,
                    "imgPath": "1",
                    "describe": null,
                    "videoPath": "2",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "2",
                    "heroPassword": "2",
                    "heroType": 2,
                    "createTime": "2018-09-04 01:40:14.503589",
                    "heroLv": 0,
                    "updateTime": "2018-09-04 01:40:14.503589",
                    "heroPrice": 0,
                    "imgPath": null,
                    "describe": null,
                    "videoPath": null,
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "55",
                    "heroPassword": "b53b3a3d6ab90ce0268229151c9bde11",
                    "heroType": 2,
                    "createTime": "2018-09-14 07:39:28.281305",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 07:39:28.281305",
                    "heroPrice": 5,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\LT 8,01-8,31.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\123.csv",
                    "videoFiles": null,
                    "imageFiles": null
                }
                
            ],
            "type1": [
                {
                    "heroName": "3",
                    "heroPassword": "2",
                    "heroType": 2,
                    "createTime": "2018-09-04 01:39:10.729825",
                    "heroLv": 0,
                    "updateTime": "2018-09-04 01:39:10.729825",
                    "heroPrice": 2,
                    "imgPath": "1",
                    "describe": null,
                    "videoPath": "2",
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "2",
                    "heroPassword": "2",
                    "heroType": 2,
                    "createTime": "2018-09-04 01:40:14.503589",
                    "heroLv": 0,
                    "updateTime": "2018-09-04 01:40:14.503589",
                    "heroPrice": 0,
                    "imgPath": null,
                    "describe": null,
                    "videoPath": null,
                    "videoFiles": null,
                    "imageFiles": null
                },
                {
                    "heroName": "55",
                    "heroPassword": "b53b3a3d6ab90ce0268229151c9bde11",
                    "heroType": 2,
                    "createTime": "2018-09-14 07:39:28.281305",
                    "heroLv": 0,
                    "updateTime": "2018-09-14 07:39:28.281305",
                    "heroPrice": 5,
                    "imgPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\images\\LT 8,01-8,31.csv",
                    "describe": null,
                    "videoPath": "E:\\vivi44\\target\\vivi44-0.0.1-SNAPSHOT\\WEB-INF\\classes\\static\\video\\123.csv",
                    "videoFiles": null,
                    "imageFiles": null
                }
            ]
        },
        "success": true,
        "errorMessage": "",
        "errorCode": 0,
        "pageInfo": null,
        "messageTip": null,
        "otherData": null
    }
   // $.each(result.data, function(i, item) {
      
       // if(item.heroType==1){          
           
            var v =new Vue({
                    el : '#most',
                    data : {
                        ResponseResult : result,
                      
                    }
                });
             
                    
                
//        }   
           
    //        return false;             
  //  })
//    }
// })
});