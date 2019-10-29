package com.itwill.ajax;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class APIExamSearchBlog {

    public static void main(String[] args) {
        String clientId = "Jaxxx_gxFJfvXW9FrxFP";
        String clientSecret = "9xjPC6rXZi";
        try {
        	String text = URLEncoder.encode("자바", "UTF-8");
            //String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json ���
            String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml ���
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { //응답상태코드  성공(200)
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  //응답상태코드  실패(404,500)
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
               
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}