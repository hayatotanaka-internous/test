package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
	public BuyItemDAO buyItemDAO = new BuyItemDAO();
	BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

	public String execute() throws SQLException {
		int count = 0;
		count = buyItemCompleteDAO.buyItemInfo(session.get("id").toString(), session.get("total_price").toString(),
				session.get("count").toString(), session.get("login_user_id").toString(),
				session.get("pay").toString());

		if (count > 0) {
			int itemStocks = Integer.parseInt(session.get("buyItem_stock").toString());
			int buyCount = Integer.parseInt(session.get("count").toString());
			itemStocks -= buyCount;

			// 在庫を減らす
			buyItemCompleteDAO.updateItemStock(itemStocks, session.get("id").toString());
		}
		String result = SUCCESS;
		return result;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
