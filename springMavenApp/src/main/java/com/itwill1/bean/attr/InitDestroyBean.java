package com.itwill1.bean.attr;

public class InitDestroyBean {
	public InitDestroyBean() {
		System.out.println("### InitDestroyBean()생성자");
	}
	public void myInit() {
		System.out.println("### InitDestroyBean.myInit()메소드 호출");
	}
	public void myDestroy() {
		System.out.println("### InitDestroyBean.myDestroy()메소드 호출");
		
	}
}
