/**
 * @author ck
 */

Number.prototype.toPercent = function (n) {
    n = n || 2;
    return (Math.round(this * Math.pow(10, n + 2)) / Math.pow(10, n)).toFixed(n) + '%';
};
/*Number.prototype.toPercent = function(n){
 n = n || 2;
 return (Math.round(this * 10000)/100).toFixed(n) + '%';
 }*/
var Q = Query = {
    getBodyHeight: function (status) {
        var high = parseInt(window.getComputedStyle(document.getElementsByTagName("body")[0]).height);
        var curDiv = window.parent.document.getElementById("rightiframe");
        curDiv.style.height = high + "px";
    },
    toThousands: function (num) {
        var num = (num || 0).toString(), result = '';
        while (num.length > 3) {
            result = ',' + num.slice(-3) + result;
            num = num.slice(0, num.length - 3);
        }
        if (num) {
            result = num + result;
        }
        return result;
    },
    get: function (parameter) {
        if (typeof (parameter) == "undefined" || parameter == "") {
            return null;
        }
        var url = window.location.href;
        var index = url.indexOf("?");
        if (index != -1) {
            var parameterString = url.substr(index + 1);
            var reg = new RegExp("(^|&)" + parameter + "=([^&]*)(&|$)", "i");
            var r = parameterString.match(reg);
            if (r != null) {
                return r[2];
            }
        }
        return null;
    },
    getInt: function (parameter, defaultValue) {
        var value = parseInt(this.get(parameter));
        return isNaN(value) ? (typeof (defaultValue) == "undefined" ? 0 : defaultValue) : value;
    },
    getDecoded: function (parameter) {
        return this.decode(this.get(parameter));
    },
    decode: function (srcStr) {
        if (typeof (srcStr) == "undefined") {
            return null;
        }
        return decodeURIComponent(srcStr);
    },
    encode: function (srcStr) {
        if (typeof (srcStr) == "undefined") {
            return null;
        }
        return encodeURIComponent(srcStr);
    },
    getSymbol: function (url) {
        return url.indexOf("?") == -1 ? "?" : "&";
    },
    joinURL: function (url, queryString) {
        return url + this.getSymbol(url) + queryString;
    },
    stringToJSON: function (str) {
        try {
            var a;
            eval('a=' + str + ';');
            return a;
        }
        catch (e) {
            ipanelPrint('stringToJSON err');
            return {};
        }
    },
    JSONToString: function (obj) {
        switch (typeof (obj)) {
            case 'object':
                var ret = [];
                if (obj == null) {
                    return '""';
                }
                else if (obj instanceof Array) {
                    for (var i = 0, len = obj.length; i < len; i++) {
                        ret.push(this.JSONToString(obj[i]));
                    }
                    return '[' + ret.join(',\n') + ']';
                }
                else if (obj instanceof RegExp) {
                    return obj.toString();
                }
                else {
                    for (var a in obj) {
                        ret.push('"' + a + '":' +
                            this.JSONToString(obj[a]));
                    }
                    return '{' + ret.join(',\n') + '}';
                }
            case 'function':
                return 'function() {}';
            case 'number':
                return obj.toString();
            case 'string':
                return '"' + obj + '"';
            case 'boolean':
                return obj.toString();
            default:
                return obj.toString();

        }
    },
    formatCommafy: function (num) {
        return (num.toFixed(2) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
    },
    verifyPhone: function (tel) {
        return !tel.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/);
    }, undefinedtoempt: function (str) {
        return str == "undefined" || !str ? "" : str;
    },

    getEnterString: function (oc, re) {
        var reStr = "(.{" + re + "}|.*)";
        var reg = new RegExp(reStr, "g");
        var ocArray = oc.match(reg)
        var arrLength = ocArray.length + 1;
        for (var element = 0; element < arrLength; element += 2) {
            ocArray.splice(element + 1, 0, '\n')
        }
        return ocArray.join('');
    },
    getFilterList: function (list, keyList, valueList) {
        if (typeof (list) == "object" || keyList.length != valueList.length) {
            var arr = [];
            for (var i = 0; i < list.length; i++) {
                for (var j = 0; j < keyList.length; j++) {
                    if (list[i][keyList[j]] == valueList[j]) {
                        arr.push(list[i]);
                    }
                }
            }
            return arr;
        }
        else {
            return [];
        }
    },
    formatMoney: function (mVal) {
        var fTmp = 0.00;//临时变量
        var iFra = 0;//小数部分
        var iInt = 0;//整数部分
        var aBuf = new Array(); //输出缓存
        var bPositive = true; //保存正负值标记(true:正数)
        /**
         * 输出定长字符串，不够补0
         * <li>闭包函数</li>
         * @param int iVal 值
         * @param int iLen 输出的长度
         */
        function funZero(iVal, iLen) {
            var sTmp = iVal.toString();
            var sBuf = new Array();
            for (var i = 0, iLoop = iLen - sTmp.length; i < iLoop; i++)
                sBuf.push('0');
            sBuf.push(sTmp);
            return sBuf.join('');
        };

        bPositive = (mVal >= 0);//取出正负号
        fTmp = (isNaN(fTmp = parseFloat(mVal))) ? 0 : Math.abs(fTmp);//强制转换为绝对值数浮点
        //所有内容用正数规则处理
        iInt = parseInt(fTmp); //分离整数部分
        iFra = parseInt((fTmp - iInt) * Math.pow(10, 0) + 0.5); //分离小数部分(四舍五入)

        do {
            aBuf.unshift(funZero(iInt % 1000, 3));
        } while ((iInt = parseInt(iInt / 1000)));
        aBuf[0] = parseInt(aBuf[0]).toString();//最高段区去掉前导0
        return ((bPositive) ? '' : '-') + aBuf.join(',');
    },
    secondToHour: function (str) {

        if (typeof (str) == "string" || typeof (str) == "number") {
            if (typeof (str) == "number") str = str + "";
            var s = str.indexOf(".") == -1 ? str : str.split(".")[0];
            if (s > 3600) {
                return Math.floor(s / 3600) + "小时" + Math.floor((s % 3600) / 60) + "分" + ((s % 3600) % 60) + "秒" + (str.indexOf(".") != -1 ? parseInt(str.split(".")[1].substring(0, 3)) + "毫秒" : "")
            } else if (s > 60) {
                return Math.floor(s / 60) + "分" + (s % 60) + "秒" + (str.indexOf(".") != -1 ? parseInt(str.split(".")[1].substring(0, 3)) + "毫秒" : "")
            } else {
                return s + "秒" + (str.indexOf(".") != -1 ? parseInt(str.split(".")[1].substring(0, 3)) + "毫秒" : "")
            }
        } else {
            return 0;
        }
    },
    toPercent: function (n) {
        if (n < 1 && n > 0) {
            n = n || 2;
            return (Math.round(this * Math.pow(10, n + 2)) / Math.pow(10, n)).toFixed(n) + '%';
        } else {
            return (this * 100).toFixed(n) + '%';
        }
    },
    toP: function (num, n) {
        if (n < 1 && n > 0) {
            n = n || 2;
            return (Math.round(num * Math.pow(10, n + 2)) / Math.pow(10, n)).toFixed(n);
        } else {
            return (num * 100).toFixed(n);
        }
    },
    showLoading: function () {
        Q.hideLoading();
        $(".loading", window.parent.document).remove();
        var msk = document.createElement("div");
        $(msk).addClass("loading");
        //$(msk).css("height", $(document).height()).show();
        $('.layoutRight', window.parent.document).append(msk);
        $('.loading', window.parent.document).append("<div class='loader'></div>");
    },
    hideLoading: function () {
        $('.loading', window.parent.document).remove();
    }
};
var d = {
    getDateStr: function (AddDayCount) {
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
    getTimeStr: function (type, offset) {
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
    },
    getDateArr: function (value1, value2) {
        var dataArr = [];
        var getDate = function (str) {
            var tempDate = new Date();
            var list = str.split("-");
            tempDate.setFullYear(list[0]);
            tempDate.setMonth(list[1] - 1);
            tempDate.setDate(list[2]);
            return tempDate;
        }
        var getNextday = function (day) {
            var today = day;
            var t = new Date(Date.parse(today.replace(/-/g, "/")));
            var tm = new Date(t.getFullYear(), t.getMonth(), t.getDate() + 1);
            var m = '0' + (tm.getMonth() + 1);
            var d = '0' + tm.getDate();
            return tm.getFullYear() + '-' + m.substr(m.length - 2) + '-' + d.substr(d.length - 2);
        }
        var date1 = getDate(value1);
        var date2 = getDate(value2);
        if (date1 > date2) {
            var tempDate = date1;
            date1 = date2;
            date2 = tempDate;
        }
        while (!(date1.getFullYear() == date2.getFullYear() && date1.getMonth() == date2.getMonth() && date1.getDate() == date2.getDate())) {
            var m = date1.getMonth() + 1
            if (m < 10) {
                m = '0' + m;
            }
            var d = date1.getDate();
            if (d < 10) {
                d = '0' + d;
            }
            dataArr.push(date1.getFullYear() + "-" + m + "-" + d);
            date1 = getDate(getNextday(date1.getFullYear() + "-" + m + "-" + d));
        }
        dataArr.push(date2.getFullYear() + "-" + ((date2.getMonth() + 1) < 10 ? ('0' + (date2.getMonth() + 1)) : (date2.getMonth() + 1)) + "-" + (date2.getDate() < 10 ? ('0' + date2.getDate()) : date2.getDate()));
        return dataArr;
    }
};
function accMul(arg1, arg2) {
    var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
    try {
        m += s1.split(".")[1].length
    }
    catch (e) {
    }
    try {
        m += s2.split(".")[1].length
    }
    catch (e) {
    }
    return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m)
}
function customDropDown(ele) {
    this.dropdown = ele;
    this.placeholder = this.dropdown.find(".placeholder");
    this.options = this.dropdown.find("ul.dropdown-menu > li");
    this.val = '';
    this.index = -1;//默认为-1;
    this.initEvents();
}

customDropDown.prototype = {
    initEvents: function () {
        var obj = this;
        //点击下拉列表的选项
        obj.options.on("click", function () {
            var opt = $(this);
            obj.text = opt.find("a").text();
            obj.val = opt.attr("value");
            obj.index = opt.index();
            obj.placeholder.text(obj.text);
        });
    },
    getText: function () {
        return this.text;
    },
    getValue: function () {
        return this.val;
    },
    getIndex: function () {
        return this.index;
    }
}
function IsPC() {
    var userAgentInfo = navigator.userAgent;
    var Agents = ["Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod"];
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = false;
            break;
        }
    }
    return flag;
}

function isNull(tmp) {
    if (!tmp && typeof (tmp) != "undefined" && tmp != 0) {
        return true;
    }
    else {
        return false;
    }
}
/*window.alert = function(content){
 $('#alertModal').modal('show');
 $('#_alert',window.parent.document).html(content);
 $('#alertModal',window.parent.document).modal('show');
 };*/
function GetDateDiff(startDate, endDate) {
    var obj = {
        "days": 0,
        "value": 0
    };
    var startTime = new Date(Date.parse(startDate.replace(/-/g, "-"))).getTime();
    var endTime = new Date(Date.parse(endDate.replace(/-/g, "-"))).getTime();
    obj.value = startTime - endTime;
    var dates = Math.abs((startTime - endTime)) / (1000 * 60 * 60 * 24);
    obj.days = dates;
    return obj;
}
function reinitIframe(id) {
    var iframe = document.getElementById(id);
    try {

        var bHeight = iframe.contentWindow.document.body.scrollHeight;
        var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
        var height = Math.max(bHeight, dHeight);
        height = Math.max(height, window.screen.availHeight - 110);
        iframe.height = height;
    }
    catch (ex) {
    }
}
Math.formatFloat = function (f, digit) {
    if (!digit) digit = 4;
    var m = Math.pow(10, digit);
    return parseInt(f * m, 10) / m;
}
var G = {
    queryFirst: true
}
var serverUrl = "/iptv4/";
var serverUrlNew = "/iptv4/";
var parentcode = 1;
var __userdemo = false;
var model = {
    "直播统计": 1,
    "点播统计": 2,
    "时移统计": 3,
    "回看统计": 4
};
if (location.href.indexOf("file:///") != -1) {
    var testServer = false;
    if (testServer) {
        serverUrl = "http://192.168.3.23:8080/iptv4/";
        serverUrlNew = "http://192.168.3.23:8080/iptv4/";
    } else {
        serverUrl = "http://120.192.66.24:8080/iptv4/";
        serverUrlNew = "http://120.192.66.24:8080/iptv4/";
    }
}
var roleidUrl = serverUrl + "common/getUserInfo";
