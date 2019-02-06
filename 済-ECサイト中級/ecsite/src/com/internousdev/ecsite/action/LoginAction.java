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

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO loginDAO =new LoginDAO();
	private LoginDTO loginDTO =new LoginDTO();
	private BuyItemDAO buyItemDAO =new BuyItemDAO();
	private List<Integer> itemStockList = new ArrayList<Integer>();

	public String execute() {
		String result =ERROR;

		loginDTO =loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);
		String adminsession =((LoginDTO) session.get("loginUser")).getAdminFlg();
		if((adminsession != null) && (adminsession.equals("1"))) {
			result ="admin";
		}
		else if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			result =SUCCESS;
			BuyItemDTO buyItemDTO =buyItemDAO.getBuyItemInfo();
						int intItemStock = Integer.parseInt(buyItemDTO.getItemStock());
			for (int i=1; i<=intItemStock; i++) {
				itemStockList.add(i);

			}
			session.put("id", buyItemDTO.getId());
			session.put("login_user_id", loginDTO.getLoginId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			session.put("buyItem_stock", buyItemDTO.getItemStock());
			return result;
		}

		return result;
	}
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId =loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword =loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session =session;
	}
	public List<Integer> getItemStockList() {
		return itemStockList;
	}
	public void setItemStockList(List<Integer> itemStockList) {
		this.itemStockList = itemStockList;
	}
}
