package com.wat.stomp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.ExpiringSession;
import org.springframework.session.web.socket.config.annotation.AbstractSessionWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * 类说明
 * @author Wutao
 * @version 2017年3月21日 下午10:03:33
 * @see
 * @since
 */
@Configuration
@EnableScheduling
@EnableWebSocketMessageBroker
public class WebSocketConfig extends  AbstractSessionWebSocketMessageBrokerConfigurer<ExpiringSession>{


	@Override
	protected void configureStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/watpoint").setHandshakeHandler(new MyHandshakeHandler()).addInterceptors(new HttpSessionHandshakeInterceptor()).withSockJS();
	}
	
	public void configureMessageBroker(MessageBrokerRegistry registry) {
         registry.enableSimpleBroker("/queue/", "/notify/");
         registry.setApplicationDestinationPrefixes("/app");
         
 }

}
