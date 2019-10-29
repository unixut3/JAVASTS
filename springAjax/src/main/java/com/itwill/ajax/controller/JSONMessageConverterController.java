package com.itwill.ajax.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ajax.News;

/*
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-annotations</artifactId>
			<version>2.9.6</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-core</artifactId>
			<version>2.9.6</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.9.6</version>
		</dependency>
 */
@RestController
public class JSONMessageConverterController {
	
	@RequestMapping(value="newsTitleJson.do",
			produces="application/json;charset=UTF-8")
	public  News newsTitleJson() {
		News news=
				new News(
						"오늘은금요일정보처리2일남았어요",
						"ITWILL", 
						new Date().toLocaleString()
						);
		return news;
	}
	@RequestMapping(value="newsTitleListJson.do",
			produces="application/json;charset=UTF-8")
	public  List<News> newsTitleListJson() {
		return this.getNewsList();
	}
	@RequestMapping(value="testMapJson.do")
	public Map testMapJson() {
		HashMap map=new HashMap();
		map.put("id", "guard");
		map.put("married", true);
		map.put("age", 43);
		map.put("news", new News("제목", "조세일보", new Date().toLocaleString()));
		map.put("data", this.getNewsList());
		return map;
	}
	@RequestMapping(value="/08.newsTitlesJSON.do")
	public Map newsTitlesJSON() {
		List<News> newsList = this.getNewsList();
		HashMap map=new HashMap();
		map.put("count", newsList.size());
		map.put("data", newsList);
		return map;
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


















