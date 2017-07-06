package com.wat.stomp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.socket.messaging.SessionConnectEvent;

/*
 * 文 件 名:  StompConnectionListener.java
 * 描    述:  <描述>
 * 修 改 人:  Wat
 * 修改时间:  2017年7月6日 下午3:03:06
 * @since:  [产品/模块版本]
 * @version:  [版本号, 2017年7月6日]
 */
public class StompConnectionListener implements ApplicationListener<SessionConnectEvent>
{
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void onApplicationEvent(SessionConnectEvent event)
    {
        String username = event.getUser().getName();
        System.err.println(username+"<=============");
        /*if(!username.equals("")&&username!=null){
            stringRedisTemplate.opsForHash().put("username", "username-"+username, username);;
        }*/
        System.out.println("onApplicationEvent:getName=\t"+username);
    }

    
}
