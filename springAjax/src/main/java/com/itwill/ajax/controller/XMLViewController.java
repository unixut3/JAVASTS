package com.itwill.ajax.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import com.itwill.ajax.News;
import com.itwill.ajax.NewsListResult;

@Controller
public class XMLViewController {
	/*
	 * xml출력View객체반환
	 */
	@RequestMapping("/response_xml_view_object.do")
	public View responseXMLViewObject(Model model) {
		ArrayList<String> friendsList=new ArrayList<String>();
		friendsList.add("김경수");
		friendsList.add("김경우");
		friendsList.add("김경미");
		friendsList.add("김경양");
		friendsList.add("김경가");
		model.addAttribute("friendsList", friendsList);
		XMLView  xmlView=new XMLView();
		return xmlView;
	}
	/*
	 * xml출력CustomView이름반환
	 */
	@RequestMapping("/response_xml_view_name.do")
	public String responseXMLViewName(Model model) {
		ArrayList<String> friendsList=new ArrayList<String>();
		friendsList.add("김경수");
		friendsList.add("김경우");
		friendsList.add("김경미");
		friendsList.add("김경양");
		friendsList.add("김경가");
		model.addAttribute("friendsList", friendsList);
		return "xmlView";
	}
	
	/*
	 * xml출력View이름반환
	 */
	@RequestMapping(value="newsTitleXmlView.do")
	public String newsTitleXmlView(Model model) {
		model.addAttribute("news",
				new News("title", "company", new Date().toLocaleString()));
		return  "jaxbXmlView";
	} 
	/************error*************/
	@RequestMapping(value="newsTitleListXmlView.do")
	public String newsTitleListXmlView(Model model) {
		List<News> newsList = this.getNewsList();
		model.addAttribute("newsList",newsList);
		return  "jaxbXmlView";
	} 
	@RequestMapping(value="newsTitleListResultXmlView.do")
	public String newsTitleListResultXmlView(Model model) {
		List<News> newsList = this.getNewsList();
		NewsListResult newsListResult=new NewsListResult();
		newsListResult.setCount(newsList.size());
		newsListResult.setNewsList(newsList);
		model.addAttribute("newsListResult",newsListResult);
		return  "jaxbXmlView";
	} 
	
	
	private List<News> getNewsList() {
		/*
		 * for(int i=0;i<300000;i++){ System.out.println(""); }
		 */
		List<News> newsList = new ArrayList<News>();
		newsList.add(new News("참으로 수고 많으셨습니다...", "연합뉴스", new Date().toLocaleString()));
		newsList.add(new News("IS 60개국 테러 위협 영상 공개…한국도 포함 포토", "SBS뉴스", new Date().toLocaleString()));
		newsList.add(new News("통일부 남북 당국회담 실무접촉서 입장차", "KBS뉴스", new Date().toLocaleString()));
		newsList.add(new News("내년도 수도권 집값·전세값↑…2∼3년후 조정", "TBC뉴스", new Date().toLocaleString()));
		newsList.add(new News("국토부 폴크스바겐 경유차 연비 3단계로 조사", "OMY뉴스", new Date().toLocaleString()));
		newsList.add(new News("日롯데 신격호 소송 이해하는가 건강문제 제기", "조선뉴스", new Date().toLocaleString()));
		newsList.add(new News("국가유공자 부인 위장 재혼시 유족자격 있다", "YTN뉴스", new Date().toLocaleString()));
		newsList.add(new News("청소년에 한달 100건 성매매 강요 조폭 징역 6년", "CBS뉴스", new Date().toLocaleString()));
		newsList.add(new News("한국인들 실직·이직 공포에 시달린다", "ITWILL뉴스", new Date().toLocaleString()));
		return newsList;
	}
	
}
