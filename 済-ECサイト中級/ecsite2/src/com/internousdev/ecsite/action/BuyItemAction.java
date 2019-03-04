package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	public String count;
	public String payment;

	public String execute(){
		String result=SUCCESS;
		session.put("count",count);
		int intCount =Integer.parseInt((session.get("count").toString()));
		int intPrice =Integer.parseInt((session.get("buyItemPrice").toString()));
		session.put("totalPrice", intCount*intPrice);
		String paySystem;

		if(payment.equals("1")){
			paySystem="キャッシュ";
		}else{
			paySystem="クレジット";
		}
		session.put("payment",paySystem);

		return result;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public void setPay(String payment) {
		this.payment = payment;
	}
}
