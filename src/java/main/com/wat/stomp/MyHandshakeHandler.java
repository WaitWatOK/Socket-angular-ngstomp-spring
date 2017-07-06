package com.wat.stomp;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

/**
 * MyHandshakeHandler
 * 
 * @author  Wutao
 * @version  1.0, 2016-7-22
 * @see  
 * @since  EMDC WEB
 */
public class MyHandshakeHandler extends DefaultHandshakeHandler {

	public Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
			Map<String, Object> attributes) {
	    String username =(String)attributes.get("username");
	    
	    MyPrincipal p = new MyPrincipal(username);
		return p;
	}
}
