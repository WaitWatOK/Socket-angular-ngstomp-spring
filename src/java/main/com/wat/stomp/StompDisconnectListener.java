package com.wat.stomp;

import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/*
 * 文 件 名:  StompDisconnectListener.java
 * 描    述:  <描述>
 * 修 改 人:  Wat
 * 修改时间:  2017年7月6日 下午3:13:57
 * @since:  [产品/模块版本]
 * @version:  [版本号, 2017年7月6日]
 */
public class StompDisconnectListener implements ApplicationListener<SessionDisconnectEvent>
{

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event)
    {
        String username = event.getUser().getName();
        System.out.println("on StompDisconnectListener:getName=\t"+username);
    }
    
}
