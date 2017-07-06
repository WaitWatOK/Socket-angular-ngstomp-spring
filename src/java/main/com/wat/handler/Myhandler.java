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
import org.springframework.data.redis.core.StringRedisTemplate;
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

import com.google.gson.Gson;
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
	
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
	
	@SubscribeMapping("/firstconn")
	public String firstConnection(MyPrincipal my){
	    StringBuffer sbf = new StringBuffer("");
	    for(Object username:stringRedisTemplate.opsForHash().values("username")){
	        sbf.append(String.valueOf(username)+"-");
	        System.err.println(String.valueOf(username)+"------i catch you !!!!");
	    }
		this.messagingTemlate.convertAndSend("/queue/greetings",sbf);
		return sbf.toString();
	}
	
	@MessageMapping(value="/processMsg")
	public void send2Browser(String mes,MyPrincipal my){
		this.messagingTemlate.convertAndSendToUser(my.getName(), "/queue/personalgreetings", mes);
	}

	@RequestMapping(value="/main")
	public ModelAndView isMain(ModelMap modelmap,HttpSession httpSession){
		Enumeration<String> sessionkeys = httpSession.getAttributeNames();  
        
        List<Pair<String, String>> list = new ArrayList<Pair<String,String>>();  
        while (sessionkeys.hasMoreElements()) {  
            String key = (String) sessionkeys.nextElement();
            String name = httpSession.getAttribute(key).toString();
            stringRedisTemplate.opsForHash().put("username", "username-"+name, name);;
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
