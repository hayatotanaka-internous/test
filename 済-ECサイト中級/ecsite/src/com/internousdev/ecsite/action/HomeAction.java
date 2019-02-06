package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	private List<Integer> itemStockList = new ArrayList<Integer>();
	public Map<String, Object> session;
	public String execute() {
		String result ="login";
			if (session.containsKey("id")) {
				BuyItemDAO buyItemDAO =new BuyItemDAO();
				BuyItemDTO buyItemDTO =buyItemDAO.getBuyItemInfo();
				int intItemStock = Integer.parseInt(buyItemDTO.getItemStock());
				for (int i=1; i<=intItemStock; i++) {
					itemStockList.add(i);
				}
				session.put("id", buyItemDTO.getId());
				session.put("buyItem_name", buyItemDTO.getItemName());
				session.put("buyItem_price", buyItemDTO.getItemPrice());
				session.put("buyItem_stock", buyItemDTO.getItemStock());
				result =SUCCESS;
		}
		return result;
	}

	public List<Integer> getItemStockList() {
		return itemStockList;
	}

	public void setItemStockList(List<Integer> itemStockList) {
		this.itemStockList = itemStockList;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session =session;
	}
}
