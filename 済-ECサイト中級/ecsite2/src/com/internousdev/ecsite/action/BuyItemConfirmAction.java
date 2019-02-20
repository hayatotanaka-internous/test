package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public String execute() {
		String result = SUCCESS;
		int count = 0;
		count = buyItemCompleteDAO.buyItemInfo(session.get("id").toString(), session.get("total_price").toString(),
				session.get("count").toString(), session.get("login_user_id").toString(),
				session.get("pay").toString());
		if (count > 0)

		{

			int buyItemStock = Integer.parseInt(session.get("buyItem_stock").toString());
			int buyCount = Integer.parseInt(session.get("count").toString());
			buyItemStock -= buyCount;
			buyItemCompleteDAO.updateItemStock(buyItemStock, session.get("id").toString());
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
