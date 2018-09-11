/*
 * author ck
 */
/*
(function () {
	//var vlstatAction = "https://101.200.150.101:9080/LogServer/1.gif";
	var vlstatAction = "https://10.0.248.122:9080/LogServer/1.gif";
    var statIdName = "vlstatId";
    var xmlHttp;
	var img = new Image();
	var rnd_id = "_img_" + Math.random();
	 
	window[rnd_id] = img; // 全局变量引用
	 
	img.onload = img.onerror = function () {
		window[rnd_id] = null; // 删除全局变量引用
	}
	var d = {
		getDateStr: function(AddDayCount){
			var dd = new Date();
			dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
			var y = dd.getFullYear();
			var m = dd.getMonth() + 1;//获取当前月份的日期
			if (m < 10) {
				m = '0' + m;
			}
			var d = dd.getDate();
			if (d < 10) {
				d = '0' + d;
			}
			return y + "-" + m + "-" + d;
		},
		getTimeStr: function(type, offset){
			var d = new Date();
			var hour = type && type == "h" ? parseInt(d.getHours()) + offset : d.getHours().toString();
			if (hour < 10) {
				hour = '0' + hour;
			}
			var minute = type && type == "m" ? parseInt(d.getMinutes()) + offset : d.getMinutes().toString();
			if (minute < 0) {
				minute += 60;
				hour--;
			}
			if (minute < 10) {
				minute = '0' + minute;
			}
			var second = type && type == "s" ? parseInt(d.getSeconds()) + offset : d.getSeconds().toString();
			if (second < 10) {
				second = '0' + second;
			}
			return hour + ":" + minute + ":" + second;
		}
	}
   function setCookie (name, value, expires, path, domain, secure){
	   	var Days = 365;
	    var exp = new Date();
	    exp.setTime(exp.getTime() + Days*24*60*60*1000);
        var curCookie = name + "=" + escape(value) +
        "; expires=" +  exp.toGMTString()+
        ((path) ? "; path=" + path : "") +
        ((domain) ? "; domain=" + domain : "") +
        ((secure) ? "; secure" : "")
        if ((name + "=" + escape(value)).length <= 4000) 
            document.cookie = curCookie
        else 
            if (confirm("Cookie exceeds 4KB and will be cut!")) 
                document.cookie = curCookie
	}
	function getCookie(name){
	    var prefix = name + "=";
	    var cookieStartIndex = document.cookie.indexOf(prefix);
	    if (cookieStartIndex == -1) 
	        return null;
	    var cookieEndIndex = document.cookie.indexOf(";", cookieStartIndex + prefix.length);
	    if (cookieEndIndex == -1) 
	        cookieEndIndex = document.cookie.length;
	    return unescape(document.cookie.substring(cookieStartIndex + prefix.length, cookieEndIndex));
	}  
    function getTimestamp(){
        var timestamp = Date.parse(new Date());
        return timestamp;
    }
    
    function genStatId(){
        var cookieId = getTimestamp();
        cookieId = "vlstat" + "-" + cookieId + "-" + Math.round(Math.random() * 3000000000);
        return cookieId;
    }
    
    function setStatId(){
        var cookieId = genStatId();
        setCookie(statIdName, cookieId);
    }
    
    function getStatId(){
        var statId = getCookie(statIdName);
        if (statId != null && statId.length > 0) {
            return statId;
        }
        else {
            setStatId();
            return getCookie(statIdName);
        }
    }
    
    function getUA(){
        var ua = navigator.userAgent;
        if (ua.length > 250) {
            ua = ua.substring(0, 250);
        }
        return ua;
    }
    
    function getBrower(){
        var ua = getUA();
        if (ua.indexOf("Maxthon") != -1) {
            return "Maxthon";
        }
        else 
            if (ua.indexOf("MSIE") != -1) {
                return "MSIE";
            }
            else 
                if (ua.indexOf("Firefox") != -1) {
                    return "Firefox";
                }
                else 
                    if (ua.indexOf("Chrome") != -1) {
                        return "Chrome";
                    }
                    else 
                        if (ua.indexOf("Opera") != -1) {
                            return "Opera";
                        }
                        else 
                            if (ua.indexOf("Safari") != -1) {
                                return "Safari";
                            }
                            else {
                                return "ot";
                            }
    }
    
    function getBrowerLanguage(){
        var lang = navigator.browserLanguage;
        return lang != null && lang.length > 0 ? lang : "";
    }
    
    function getPlatform(){
        return navigator.platform;
    }
    
    function getPageTitle(){
        return document.title;
    }
    
    function createXMLHttpRequest(){
            if (window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            }else{
				xmlHttp = new ActiveXObject('Microsoft.XMLHTTP');
			}
    }
    function vlstatInitLE(){
        var p;
        var vlstatCookieId = getStatId();
        var vlstatUA = encodeURIComponent(getUA());
        var vlstatIPAddress = document.localName;
        var vlstatREFURL = encodeURIComponent(document.referrer);
        var vlstatURL = encodeURIComponent(document.URL);
        var vlstatScreenX = screen.width;
        var vlstatScreenY = screen.height;
        var vlstatOS = getPlatform();
        var vlstatBrower = getBrower();
        var vlstatBrowerLanguage = getBrowerLanguage();
        var vlstatPageTitle = encodeURIComponent(getPageTitle());
        p = "cookieId=" + vlstatCookieId+
		 "&ua=" + vlstatUA+
		 "&refurl=" + vlstatREFURL+
        "&url=" + vlstatURL +
        "&screenX=" + vlstatScreenX +
		"&ip=" + returnCitySN["cip"] +
        "&screenY=" + vlstatScreenY +
        "&os=" + vlstatOS +
        "&brower=" + vlstatBrower +
        "&browerLang=" + vlstatBrowerLanguage +
        "&title=" + vlstatPageTitle+
		"&currTime=" + (d.getDateStr()+ " "+d.getTimeStr());
		img.src = vlstatAction + "?" + p;
        
		console.log(p);
    }
	vlstatInitLE();
})();
*/
