package com.wat.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public String firstConnection(){
		return "Welcome Halo!";
	}
	
	@MessageMapping(value="/processMsg")
	public void send2Browser(String mes){
		this.messagingTemlate.convertAndSend("/queue/greetings",mes);
	}

	@RequestMapping(value="/main")
	public ModelAndView isMain(ModelMap modelmap){
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
