package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public String execute() throws SQLException {
		String result = SUCCESS;
		int count = 0;
		count = buyItemCompleteDAO.buyItemInfo(session.get("id").toString(), session.get("totalPrice").toString(),
				session.get("count").toString(), session.get("loginUserId").toString(),
				session.get("payment").toString());

		if (count > 0) {
			int buyItemStock = Integer.parseInt(session.get("buyItemStock").toString());
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
