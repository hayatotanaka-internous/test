package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;
public class ItemListAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private List<ItemListDTO> itemList =new ArrayList<ItemListDTO>();

	public String execute() throws SQLException{
		ItemListDAO itemListDAO =new ItemListDAO();
		itemList =itemListDAO.getItemListDTO();
		String result =SUCCESS;
		return result;
	}

	public List<ItemListDTO> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemListDTO> itemList) {
		this.itemList = itemList;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session =session;
	}

	public Map<String, Object> getSession() {
		return session;
	}
}
