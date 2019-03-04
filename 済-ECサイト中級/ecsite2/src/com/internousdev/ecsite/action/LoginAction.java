package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	public String loginUserId;
	public String loginPassword;
	public String userName;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private List<Integer> itemStockList = new ArrayList<Integer>();

	public String execute() {
		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);
		if (((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			result = SUCCESS;
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = (buyItemDAO.getBuyItemInfo());
			int intItemStock = Integer.parseInt(buyItemDTO.getItemStock());
			for (int i = 1; i <= intItemStock; i++) {
				itemStockList.add(i);
			}
			session.put("id", buyItemDTO.getId());
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("buyItem_Name", buyItemDTO.getItemName());
			session.put("buyItem_Price", buyItemDTO.getItemPrice());
			session.put("buyItem_Stock", buyItemDTO.getItemStock());
			session.put("userName",loginDTO.getUserName());
			return result;
		}
		return result;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public List<Integer> getItemStockList() {
		return itemStockList;
	}

	public void setItemStockList(List<Integer> itemStockList) {
		this.itemStockList = itemStockList;
	}
}
