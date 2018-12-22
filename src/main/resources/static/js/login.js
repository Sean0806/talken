$(document).ready(function () {
    $("#login").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        var loginData = {
            'userName':username,
            'password':password
        };
        // var data = loginData.parseJSON;
        $.ajax({
            type : "post",
            url : "/login",
            data:JSON.stringify(loginData),
            dataType : "json",
            headers : {
                'version' : "1.0",
                'Content-Type' : 'application/json;charset=UTF-8'
            },
            success: function (data) {
                alert("login success");
                window.location.href = 'index.html'
            }
        })
    })
})