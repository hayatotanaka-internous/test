package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class ItemCreateAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private int itemStock;
	public String execute() {
		String result =SUCCESS;
		session.put("itemStock", itemStock);
		return result;
	}
	public void setItemStock(int itemStock){
		this.itemStock =itemStock;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session =session;
	}
}
