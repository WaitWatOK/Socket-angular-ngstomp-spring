<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@page session="true"%>
    <%
    	String base = request.getContextPath();
        request.setAttribute("base", request.getContextPath());
        System.out.println(request.getContextPath());
        request.setAttribute("cssPath", request.getContextPath()+"/resources/css");
        request.setAttribute("imgPath",request.getContextPath() + "/resources/images");
        request.setAttribute("jsPath", request.getContextPath() + "/resources/js");
        request.setAttribute("imagePath",request.getContextPath() + "/resources/images/login");
        request.setAttribute("fontPath",request.getContextPath() + "/resources/fonts");
    %>
<html>

<head>
    <meta charset="">
    <meta http-equiv="Pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache"> 
	<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    <title>登录</title>
	<script type="text/javascript" src="${jsPath}/jquery-1.8.3.min.js"></script>

    <style>
    html,
    body {
        margin: 0;
        padding: 0;
        height: 100%;
        width: 100%;
        /*background-image: url(登录页01.jpg);*/
        background-size: 100% 100%;
        font: 14px/1.5 'Microsoft YaHei', arial, tahoma, \5b8b\4f53, sans-serif;
    }
    
    .header {
        position: absolute;
        z-index: 300;
        top: 0;
        height: 11%;
        width: 100%;
    }
    
    .body {
        position: absolute;
        z-index: 100;
        top: 11%;
        bottom: 9%;
        width: 100%;
        background: #1D985F url(${imagePath}/loginbg.png) center center no-repeat;
        background-size: auto 100%;
    }
    
    .footer {
        position: absolute;
        z-index: 200;
        bottom: 0;
        height: 9%;
        width: 100%;
    }
    
    .logo {
        position: absolute;
        z-index: 2;
        top: 10px;
        left: 130px;
        height: 175%;
        opacity: 0.9;
    }
    
    .left-box {
        position: absolute;
        z-index: 2;
        bottom: 10px;
        left: 350px;
        margin: 0;
        font-size: 28px;
        color: #6C6F78;
        letter-spacing: 1.5px;
    }
    
    .phone {
        position: absolute;
        z-index: 2;
        bottom: 10px;
        right: 360px;
        height: 73%;
    }
    
    .right-box {
        position: absolute;
        z-index: 2;
        bottom: 15px;
        right: 180px;
        margin: 0;
        font-size: 24px;
        line-height: 32px;
        color: #087D82;
    }

    .login-pane {
        position: absolute;
        z-index: 2;
        top: 50%;
        right: 12%;
        width: 22%;
        /* height: 500px; */
        margin-top: -250px;
        border-radius: 10px;
        background-color: #fff;
        opacity: 0.9;
    }
    
    .caption {
        text-align: center;
        font-size: 28px;
        font-weight: normal;
        color: #1C8854;
    }
    
    .input-box {
        position: relative;
        left: 10%;
        width: 80%;
        height: 50px;
        margin-top: 22px;
        margin-bottom: 22px;
        border: solid 1px #6BB893;
        border-radius: 5px;
        background-position: 2% center;
        background-repeat: no-repeat;
        background-size: auto 70%;
    }
    
    .input-checkcode img {
        position: absolute;
        top: 0;
        right: -110px;
        width: 100px;
        height: 50px;
        cursor: pointer;
    }
    
    .input-box input {
        display: block;
        width: 70%;
        height: 50px;
        margin-left: 50px;
        border: none;
        font-size: 20px;
        background-color: transparent;
        color: #3b3b3b;
        outline: none;
    }
    
    .sel-btn {
        position: absolute;
        z-index: 300;
        top: 0;
        right: 0;
        width: 50px;
        height: 50px;
        background: transparent url(${imagePath}/img03.png) center center no-repeat;
        background-size: 40% 30%;
        cursor: pointer;
    }
    
    .sel-content {
        display: none;
        margin: 0;
        padding: 0;
        padding-top: 5px;
        list-style-type: none;
        position: absolute;
        top: 45px;
        left: -1px;
        width: 100%;
        max-height: 122px;
        overflow: auto;
        border-left: solid 1px #6BB893;
        border-right: solid 1px #6BB893;
        border-bottom: solid 1px #6BB893;
        border-bottom-left-radius: 5px;
        border-bottom-right-radius: 5px;
        background-color: #fff;
    }
    
    .sel-content li {
        height: 40px;
        line-height: 40px;
        margin: 0;
        padding: 0;
        text-indent: 10px;
        cursor: pointer;
        font-size: 18px;
        background-color: #fff;
        color: #8b8b8b;
    }
    
    /*.sel-content li:nth-child(odd) {
        background-color: #ffff77;
    }*/
    
    .sel-content li:last-child {
        border-radius: 5px;
    }
    
    .sel-content li:hover {
        color: #fff;
        background-color: #1D9960;
    }
    /*选中状态下的选择框*/
    
    .selected .sel-btn {
        -webkit-transform: rotate(180deg);
        -moz-transform: rotate(180deg) transform: rotate(180deg);
    }
    
    .selected .sel-content {
        display: block;
    }
    
    .btn-box {
        height: 60px;
        line-height: 60px;
        width: 80%;
        margin: 50px auto;
        border-radius: 10px;
        text-align: center;
        font-size: 22px;
        letter-spacing: 10px;
        background-color: #B97522;
        color: #fff;
        cursor: pointer;
    }
    
    .btn-box:hover {
        background-color: #ffbb66;
    }
    
    .copyright {
        margin-top: 10px;
        margin-bottom: 0;
        text-align: center;
        font-size: 14px;
        color: #8b8b8b;
        letter-spacing: 2px;
    }
    
    .welcome {
        margin-top: 5px;
        margin-bottom: 0;
        text-align: center;
        font-size: 28px;
        letter-spacing: 4px;
        color: #109599;
    }
    /*延时加载动画效果*/
	.box{
		width:100px;
		margin:0 auto;
	}
	.box>div{
		height:60px;
		width:10px;
		background-color:#1D985F;
		margin-left:2px;
		display:inline-block;
		-webkit-animation:strechdelay 1.2s infinite ease-in-out;
	}
	.box .line2{
		-webkit-animation-delay:-1.1s;
	}
	.box .line3{
		-webkit-animation-delay:-1.0s;
	}
	.box .line4{
		-webkit-animation-delay:-0.9s;
	}
	.box .line5{
		-webkit-animation-delay:-0.8s;
	}

    </style>
</head>
<body >
    <div class="body">
        <div class="login-pane">
            <h1 class="caption">用户登录</h1>
            <form name='loginForm' method='POST'>
                <div class="input-box input-user">
                    <input id='loginname' type='text' autocomplete="off" name='loginname' 
                    type="text" placeholder="请输入用户名"/>
                </div>
                <div class="input-box input-password">
                    <input id='pwd' type='password' autocomplete="off" name='pwd' 
                    placeholder="请输入密码"/>
                </div>
				<div class="btn-box" onClick="login()">登录</div>
            </form>
			<div id="loginResult" style="width:100%;
				/* margin-left:20%; */
				margin-bottom:30px;
				text-align:center;
				font-size:150%;
				color:#b74d46">
			</div>
        </div>
    </div>
</body>
<script type="text/javascript">
   	function login(){
   		var loginname = $("#loginname").val();
   		var pwd = $("#pwd").val();
   		window.alert(pwd);
   		$.ajax({
   			type:"POST",
   			url:"/SocketDemo/login",
   			data:"loginname="+loginname+"&pwd="+pwd,
   			success:function(result){
   				console.error(result);
   				location.replace("/SocketDemo/main");
   			}
   		});
   	}
</script>
</html>