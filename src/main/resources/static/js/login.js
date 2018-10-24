$(document).ready(function () {
    $("#button1").click(function () {
        $.ajax({
            type : "post",
            url : "/login",
            headers : {
                'version' : "1.0",
                'Content-Type' : 'application/json;charset=UTF-8'
            },
            success: function () {
                alert("login success");
                window.location.href = 'index.html'
            }
        })
    })
})