package com.itwill.controller.annotation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringModelController {
	
	@RequestMapping("/model_request.do")
	public String request(HttpServletRequest request) {
		request.setAttribute("req", "리퀘스트데이타");
		return "/WEB-INF/view/spring_model.jsp";
	}
	
	@RequestMapping("/model_map.do")
	
	public String map(Map map) {
		System.out.println("### "+map.getClass().getSimpleName()+":"+map);
		map.put("map", "맵데이터");
		/*
		request.setAttribute("map","맵데이타");
		*/
		System.out.println("### "+map.getClass().getSimpleName()+":"+map);
		return "/WEB-INF/view/spring_model.jsp";
	}
	
	@RequestMapping("/model_modelmap")
	public String model_map(ModelMap modelMap) {
		System.out.println("### "+modelMap.getClass().getSimpleName()+":"+modelMap);
		modelMap.addAttribute("modelmap", "모델맵데이터");
		/*
		request.setAttribute("modelmap","모델맵데이타");
		 */
		return "/WEB-INF/view/spring_model.jsp";
	}
	
	@RequestMapping("/model_model.do")
	public String model(Model model) {
		/*
		 * model객체클래스-->BindingAwareModelMap
		 */
		System.out.println("### "+model.getClass().getSimpleName()+":"+model);
		model.addAttribute("model", "모델데이타");
		/*
		request.setAttribute("model","모델데이타");
		*/
		return "/WEB-INF/view/spring_model.jsp";
	}
	
	@RequestMapping("/model_modelandview.do")
	public ModelAndView modelAndView() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("modelAndView","모델앤드뷰데이터");
		mv.setViewName("/WEB-INF/view/spring_model.jsp");
		
		/*
		request.setAttribute("modelAndView","모델앤드뷰데이터");
		*/
		return mv;
		
		
	}
	
	@RequestMapping("/model_all.do")
	public String model_all(HttpServletRequest request,
							Model model,
							Map map,
							ModelMap modelMap) {
		request.setAttribute("req", "리퀘스트데이터");
		map.put("map", "맵데이터");
		model.addAttribute("model","모델데이터");
		model.addAttribute("modelmap","모델맵데이터");
		
		
		return "/WEB-INF/view/spring_model.jsp";
	}
	
}
