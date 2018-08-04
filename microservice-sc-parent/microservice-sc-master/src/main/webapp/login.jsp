<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <style>
    html,body{
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100%;
    }
    .bjBox{
    width: 100%;
    height: 100%;
    position: relative;
    }
    .bjBox img{
    width: 100%;
    height: 100%;
    }
    .dlBox{
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    margin: auto;
    width: 410px;
    height: 408px;
    background: url("/images/login/dlk.png") no-repeat 100% 100%;
    }
    .dlTit{
    width: 100%;
    height: 80px;
    line-height: 80px;
    text-align: center;
    font-size: 40px;
    color: #151617;
    }
    .dlInput{
    width: 100%;
    height: 40px;
    margin-bottom: 8px;
    line-height: 40px;
    color: #fff;
    }
    .dlInput img{
    width: 30%;
    border-radius: 2px;
    height: 99%;
    margin: 0 2%;
    }
    .dlInput input{
    display: block;
    width: 80%;
    height: 100%;
    padding: 6px 12px;
    margin: 0 auto;
    font-size: 14px;
    line-height: 1.42857143;
    color: #eee;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
    position: relative;
    background: #151617;
    opacity: 0.3;
    }
    .check{
    background: #151617;
    opacity: 0.3;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
    }
    .dlCheck{
    padding-left: 10%;
    color: #fff;
    padding-bottom: 15px;
    }
    #btn_login{
    width: 80%;
    height: 40px;
    line-height: 40px;
    text-align: center;
    color: #fff;
    background: #151617;
    margin: 0 auto;
    border-radius: 4px;
    font-size: 18px;
    }
    </style>
</head>
<body>
<div class="bjBox">
    <%--<img src="/images/login/loginBj.png" alt="">--%>
    <div class="dlBox">
        <h3 class="dlTit">用户登录</h3>
        <div class="dlInput">
            <input  type="text" name="name" id="useName"  title="用户名" nullmsg="请输入用户名!" placeholder="请输入账号" />
        </div>

        <div class="dlInput">
            <input   name="passwd" type="password" id="passwd"  title="密码" nullmsg="请输入密码!" placeholder="请输入密码" />
        </div>
        <!-- <div class="dlInput" style="padding-left: 10%">
            <input style="width: 30%;display: inline-block"  name="yzm" type="text" id="yzm"  title="密码" placeholder="验证码" />
            <img src="/images/login/yztp.png" alt="">
            换一张
        </div> -->
        <div class="dlCheck">
            <input type="checkbox" class="check"> 记住密码
        </div>
            <div id="btn_login" name="but_login" type="button" >登 录</div>
        <div id="alertMessage">${msg }</div>
    </div>

</div>




<script type="text/javascript" src="/js/lib/jquery-3.2.1.min.js"></script>
<script>
    function login(username, password) {//, yzm
        if (!username) {
            alert("请输入用户名");
            return
        }
        if (!password) {
            alert("请输入密码");
            return
        }
        // if (!yzm) {
        //     alert("请输入验证码");
        //     return
        // }
        // if(yzm.toLocaleLowerCase()!="ktlu"){
        //     alert("验证码不正确");
        //     return
        // }

        var qData = {
            username: username,
            password: password
        };
        qData = JSON.stringify(qData);
        $.ajax({
            url: "/loginForm",
            data: qData,
            type: "POST",
            contentType: "application/json",
            success: function (res) {
                if (res.success) {
                    window.location.href = "/home"
                }
                else {
                    alert(res.msg);
                }
            }
        })
    }
</script>
<script>
    $(function() {
        $(function () {
            $("#btn_login").on("click", function () {
                login($("#useName").val(), $("#passwd").val());// , $("#yzm").val()
                
            });

        });
        $("body").keydown(function() {
            if (event.keyCode == "13") {//keyCode=13是回车键
                $("#btn_login").click();
            }
        });
    });
</script>
</body>
</html>
