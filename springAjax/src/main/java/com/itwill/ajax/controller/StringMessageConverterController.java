package com.itwill.ajax.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.ajax.News;

@Controller
public class StringMessageConverterController {
	@RequestMapping(value = "/response_string1.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String responseString1() {
		return "hello spring ajax!!![한글]";
	}

	@RequestMapping(value = "/response_string2.do", produces = "text/html;charset=UTF-8")
	public @ResponseBody String responseString2() {
		return "<h1>hello spring ajax!!![한글]</h1><hr/>";
	}

	@RequestMapping(value = "/02.ajaxRequest.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String ajaxRequest(@RequestParam String id) {
		if (id == null)
			id = "";
		String msg = "";
		if (id.startsWith("guard")) {
			msg = "Y";
		} else {
			msg = "N";
		}
		return msg;
	}

	@RequestMapping(value = "04.server_clock.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String server_clock() {
		return new Date().toLocaleString();
	}

	@RequestMapping(value = "05.newsTitlesCSV.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String newsTitlesCSV() {
		List<News> newsList = getNewsList();
		/*
		 * 3#title1,company1,date1|title2,company2,date2|title3,company3,date3
		 * 2#title1,company1,date1|title2,company2,date2 0#
		 */
		StringBuffer sb = new StringBuffer();
		sb.append(newsList.size() + "#");

		for (int i = 0; i < newsList.size(); i++) {
			News tempNews = newsList.get(i);
			sb.append(tempNews.getTitle() + "," + tempNews.getCompany() + "," + tempNews.getDate());
			if (i != (newsList.size() - 1)) {
				sb.append("|");
			}
		}
		return sb.toString();
	}

	@RequestMapping(value = "suggest.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String suggest(@RequestParam(defaultValue = "") String keyword) {
		List keywordList = this.search(keyword);
		StringBuffer sb=new StringBuffer();
		sb.append(keywordList.size());
		sb.append("|");
		for (int i = 0; i < keywordList.size(); i++) {
			String key = (String) keywordList.get(i);
			sb.append(key);
			if (i < keywordList.size() - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

	String[] keywords = { "AJAX", "AJAX 실전 프로그래밍", "AJA", "AZERA", "자라자", "자라", "자바 프로그래밍", "자바 서버 페이지", "자바스터디",
			"자바서비스", "자바캔" };

	private List search(String keyword) {
		if (keyword == null || keyword.equals(""))
			return java.util.Collections.EMPTY_LIST;
		keyword = keyword.toUpperCase();
		List result = new java.util.ArrayList(8);
		for (int i = 0; i < keywords.length; i++) {
			if (((String) keywords[i]).startsWith(keyword)) {
				result.add(keywords[i]);
			}
		}
		return result;
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
