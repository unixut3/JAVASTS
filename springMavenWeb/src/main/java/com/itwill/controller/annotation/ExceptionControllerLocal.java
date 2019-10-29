package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionControllerLocal {
	@RequestMapping("/business1.do")
	public String business_method1() throws BusinessException1 {
		boolean b=true;
		if(b) {
			throw new BusinessException1("업무에러1발생");
		}
		return"forward:/WEB-INF/view/business_result.jsp";
	}
	
	@RequestMapping("/business2.do")
	public String business_method2() throws BusinessException2{
		boolean b=true;
		if(b) {
			throw new BusinessException2("업무에러2발생");
		}
		return"forward:/WEB-INF/view/business_result.jsp";
	}
	
	@RequestMapping("/business3.do")
	public String business_method3() {
		String name=null;
		int size = name.length();
		return"forward:/WEB-INF/view/business_result.jsp";
	}
	
	@ExceptionHandler(BusinessException1.class)
	public String handle_business1_exception(BusinessException1 e) {
		return "forward:/WEB-INF/view/business_error_result.jsp";
	}
	
	/*
	//단순히 페이지 이동만 할때
	@ExceptionHandler(BusinessException2.class)
	public String handle_business2_exception(BusinessException2 e) {
		return "forward:/WEB-INF/view/business_error_result.jsp";
	}
	 */
	
	//메세지를 출력 및 페이지 이동을 같이 하고 싶을때
	@ExceptionHandler(BusinessException2.class)
	public ModelAndView handle_business2_exception(BusinessException2 e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/WEB-INF/view/business_error_result.jsp");
		mv.addObject("error_msg", e.getMessage());
		return mv;
	}
	
	/*
	@ExceptionHandler(RuntimeException.class)	//런타임 익셉션
	public String handle_runtime_exception(RuntimeException e) {
		return "forward:/WEB-INF/view/runtime_error_result.jsp";
	}
	*/
	
	

}
