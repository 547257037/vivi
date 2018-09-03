/**
 * 封装一下fetch
 */

function Fetchs(url) {
    var baseUrl = "/iptv4/";

    var headers = { "Content-Type": "application/json;charset=UTF-8" };

    var get = (url) => fetch(baseUrl + url, {
        headers,
        method: 'GET',
        credentials: 'include'
    }).then(res => res.ok ? res.json() : console.log(res.status + res.statusText));

    var post = (url, body, ...args) =>
        fetch(baseUrl + url,
            {
                body: JSON.stringify(body),
                headers,
                credentials: 'include',
                method: 'POST'
            })
            .then(res =>
                res.ok ? res.json() : console.log(res.status + res.statusText));


    var hideLoading = function () {
        var child = document.querySelector('.loading');
        child.parentNode.removeChild(child);
    }

    var showLoading = function () {
        var msk = document.createElement("div");
        var div = document.createElement("div");
        msk.className = 'loading';
        div.className = 'loader';
        msk.appendChild(div)
        // $('.layoutRight', window.parent.document).append(msk);
        document.getElementById('root').appendChild(msk);
    }

    this.get = get;
    this.post = post;

    this.showLoading = showLoading;
    this.hideLoading = hideLoading;
}