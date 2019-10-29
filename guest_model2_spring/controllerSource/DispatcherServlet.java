package com.itwill.summer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private HashMap<String, Controller> controllerMap;
	/*
	* web.xml에서 전달된 설정파일위치값을 초기화하는 메써드.
	<servlet>
	  	<servlet-name>dispatcher</servlet-name>
	  	<servlet-class>com.itwill.summer.DispatcherServlet</servlet-class>
	  	<init-param>
	  		<param-name>configFile</param-name>
	  		<param-value>/WEB-INF/guest_controller_mapping.properties</param-value>
	  	</init-param>
	  	<load-on-startup>1</load-on-startup>
  	</servlet>
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		controllerMap=new HashMap<String, Controller>();
		ServletContext servletContext=this.getServletContext();
		/*
		 * web.xml의 파라메타가져오기
		 */
		String configFile=config.getInitParameter("configFile");
		String configFileRealPath = 
				servletContext.getRealPath(configFile);
		try {
			FileInputStream fis=new FileInputStream(configFileRealPath);
			Properties mappingProperties=new Properties();
			mappingProperties.load(fis);
			Set commandKeySet =mappingProperties.keySet();
			Iterator commandKeyIter = commandKeySet.iterator();
			System.out.println("-----------------"+configFile+"-----------------");
			while (commandKeyIter.hasNext()) {
				String command =(String)commandKeyIter.next();
				String controllerClassStr=
						mappingProperties.getProperty(command);
				
				Controller controller=
						(Controller)Class.forName(controllerClassStr)
							.newInstance();
				controllerMap.put(command, controller);
				System.out.println(command+"="+controller);
			}
			System.out.println("-----------------------------------------------------");
			
				
		
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.processRequest(request, response);
	}
	private void processRequest(HttpServletRequest  request,
								HttpServletResponse response)
										throws ServletException, IOException  {
		
		/*
		<<요청command>>
		/guest_main.do
		/guest_write_form.do
		/guest_write_action.do
		/guest_list.do
		/guest_view.do
		/guest_modify_form.do
		/guest_modify_action.do
		/guest_delete_action.do
		
		*/
		/*
		 * 1.클라이언트 요청분석(URI)
		 */
		String requestURI = request.getRequestURI();
		//System.out.println("requstURI:"+requestURI);
		String contextPath=request.getContextPath();
		//System.out.println("contextPath:"+contextPath);
		String command = requestURI.substring(contextPath.length());
		System.out.println("command:"+command);
		/*
		 * 2.클라이언트요청에따른 Controller객체찾기
		 */
		String forwardPath="";
		boolean isRedirect=false;
		Controller controller=controllerMap.get(command);
		/*
		*  3.클라이언트요청에따른 생성된 
		*  	Controller객체메쏘드(handleRequst)호출
		*/
		forwardPath = controller.handleRequest(request, response);
		/*
		 * 4. JSP로 forward or *.do redirect(forward)
		 */
		/**************forward:xxx.jsp,redirect:xxx.do*************/
		String[] tempForwardPaths = forwardPath.split(":");
		String redirectStr=tempForwardPaths[0];
		forwardPath=tempForwardPaths[1];
		if(redirectStr.equals("forward")) {
			isRedirect=false;
		}else if(redirectStr.equals("redirect")) {
			isRedirect=true;
		}
		/********************************************************/
		if(isRedirect) {
			response.sendRedirect(forwardPath);
		}else {
			RequestDispatcher rd=
					request.getRequestDispatcher(forwardPath);
			rd.forward(request, response);
		}
	}
	

}
