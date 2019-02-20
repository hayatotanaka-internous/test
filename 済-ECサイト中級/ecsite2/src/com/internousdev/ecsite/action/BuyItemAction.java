package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	public int count;
	public String pay;

	public String execute(){
		String result=SUCCESS;
		session.put("count",count);
		int intCount =Integer.parseInt(NONE);
		int intPrice =Integer.parseInt(NONE);
		session.put("total_price", intCount*intPrice);
		String payment;

		if(pay.equals("1")){
			payment="キャッシュ";
		}else{
			payment="クレジット";
		}
		session.put("pay",payment);
		return result;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}
}
