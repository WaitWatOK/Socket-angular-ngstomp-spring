<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setAttribute("jsPath", request.getContextPath()+"/resources/js");
%>

<!DOCTYPE html>
<html  ng-app="myindex">
  <head>
    <title>SuccessPage</title>
	<meta charset="UTF-8">
	<script src="${jsPath}/websocket/jquery.js"></script>
	<script src="${jsPath}/angular.min.js"></script>
	<!-- websocket框架 -->
	<script src="${jsPath}/websocket/sockjs-0.3.min.js"></script>
	<script src="${jsPath}/websocket/stomp.js"></script>
	<script src="${jsPath}/websocket/NGStomp.js"></script>    
	<!-- 加载自定义的angular控制层 -->
	<script src="${jsPath}/myController.js"></script> 

  </head>
  
  <body>
    WelCome！ 
    <br><br>
    <!-- <a href="getName.action">GetName</a>
    <br> -->
    <input type="text" ng-model="message">
    <input type="button" ng-click="sendmsg()" value="Send">
    <br><br><br>
    <textarea name="a" style="width:200px;height:80px;" ng-model="msgfromServer" readonly></textarea>
    
    <textarea name="a" style="width:200px;height:80px;" ng-model="personalmsgfromServer" readonly></textarea>
    
  </body>
</html>
