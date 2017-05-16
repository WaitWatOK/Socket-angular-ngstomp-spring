<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
request.setAttribute("jsPath", request.getContextPath()+"/resources/js");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Stomp Over SocketJS</title>
		<script src="${jsPath}/websocket/jquery.js"></script>
	<!-- websocket框架 -->
	<script src="${jsPath}/websocket/sockjs-0.3.min.js"></script>
	<script src="${jsPath}/websocket/stomp.js"></script>
	<script type="text/javascript">
		function connect(){
			$.ajax({});
			var ws = new SockJS("http://127.0.0.1:8080/SocketDemo/watpoint");
			var client= Stomp.over(ws);
			var on_connect = function() {
			    console.log('connected');
			};
			var on_error =  function() {
			    console.log('error');
			};
			client.connect('guest', 'guest', on_connect, on_error);
		}
		
		function disconnect(){
			var ws = new SockJS("http://127.0.0.1:8080/SocketDemo/watpoint");
			var client= Stomp.over(ws);
			var on_disconnect = function() {
			    console.log('connected');
			};
			client.disconnect(on_disconnect);
		}
	</script>
  </head>
  
  <body>
    <button id="conn" type="button" onclick="connect()">连接</button>
    <button id="disconn" type="button" onclick="disconnect()">断开连接</button>
  </body>
</html>
