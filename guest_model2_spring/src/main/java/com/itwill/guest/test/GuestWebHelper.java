package com.itwill.guest.test;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;

public class GuestWebHelper {
	public static DataSource getDataSource(ServletContext ctx){
		WebApplicationContext wac = 
				WebApplicationContextUtils.getWebApplicationContext(ctx);
		return (DataSource)wac.getBean("dataSource");
	}
	public static GuestDao getGuestDao(ServletContext ctx){
		WebApplicationContext wac = 
				WebApplicationContextUtils.getWebApplicationContext(ctx);
		return (GuestDao)wac.getBean("guestDao");
	}
	public static GuestService getGuestService(ServletContext ctx){
		WebApplicationContext wac = 
			WebApplicationContextUtils.getWebApplicationContext(ctx);
		return (GuestService)wac.getBean("guestService");
	}
	
}
