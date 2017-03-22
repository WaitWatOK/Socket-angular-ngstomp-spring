package com.wat.stomp;

import java.security.Principal;

/**
 * MyPrincipal
 * 
 * @author  Wutao
 * @version  1.0, 2016-7-22
 * @see  
 * @since  EMDC WEB
 */
public class MyPrincipal implements Principal {

	private String username;
	
	public MyPrincipal(String username)
	{
		this.username=username;
	}
	@Override
	public String getName() {
		return username;
	}
}
