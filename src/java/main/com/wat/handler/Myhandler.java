package com.wat.handler;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.util.Pair;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wat.stomp.MyPrincipal;

/**
 * 类说明
 * @author Wutao
 * @version 2017年3月21日 下午10:14:47
 * @see
 * @since
 */
@Controller
@Scope("prototype")
public class Myhandler {
	
	@Autowired
	private SimpMessageSendingOperations messagingTemlate;
	
	@SubscribeMapping("/firstconn")
	public String firstConnection(MyPrincipal my){
		this.messagingTemlate.convertAndSendToUser("wt", "/queue/personalgreetings", my.getName());
		return "Welcome Halo!";
	}
	
	@MessageMapping(value="/processMsg")
	public void send2Browser(String mes){
		if(mes.equals("cdj")){
			this.messagingTemlate.convertAndSendToUser("cdj", "/queue/personalgreetings", mes);
		}else{
			this.messagingTemlate.convertAndSend("/queue/greetings",mes);
		}
	}

	@RequestMapping(value="/main")
	public ModelAndView isMain(ModelMap modelmap,HttpSession httpSession){
		Enumeration<String> sessionkeys = httpSession.getAttributeNames();  
        
        List<Pair<String, String>> list = new ArrayList<Pair<String,String>>();  
        while (sessionkeys.hasMoreElements()) {  
            String key = (String) sessionkeys.nextElement();  
            //list.add(new Pair<String, String>(key, httpSession.getAttribute(key).toString()));  
            System.err.println(key);
        } 
		return new ModelAndView("success",modelmap);
	}
	
	@ResponseBody
	@RequestMapping(value="/login",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String resolverLogin(HttpServletRequest request){
		String loginname = request.getParameter("loginname");
		String pwd = request.getParameter("pwd");
		
		request.getSession().setAttribute("username", loginname);
		return "done";
	}
	
	@RequestMapping(value="/loginpage")
	public ModelAndView loginPage (ModelMap modelmap){
		return new ModelAndView("login",modelmap);
	}
}
