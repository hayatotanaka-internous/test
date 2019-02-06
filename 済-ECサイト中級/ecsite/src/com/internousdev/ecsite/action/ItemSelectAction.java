package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemSelectDAO;
import com.opensymphony.xwork2.ActionSupport;
public class ItemSelectAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
//	private List<ItemListDTO> allItemDTOList =new ArrayList<ItemListDTO>();
	private List<String> allItemNameList = new ArrayList<String>();

	public String execute() throws SQLException{
		String result =SUCCESS;
//		if (session.containsKey("id")) {
			ItemSelectDAO itemSelectDAO =new ItemSelectDAO();
//			List<ItemListDTO> allItemDTOList =itemSelectDAO.getAllItemNameList();
			allItemNameList =itemSelectDAO.getAllItemNameList();

//			String ItemNameList = ((ItemListDTO) allItemDTOList).getItem_Name();
//			session.put("Item_Name", ItemNameList);
//		}
		return result;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session =session;
	}


	public List<String> getAllItemNameList() {
		return allItemNameList;
	}

	public void setAllItemNameList(List<String> allItemNameList) {
		this.allItemNameList = allItemNameList;
	}

//	public List<ItemListDTO> getAllItemDTOList() {
//		return allItemDTOList;
//	}
//
//
//	public void setAllItemDTOList(List<ItemListDTO> allItemDTOList) {
//		this.allItemDTOList = allItemDTOList;
//	}
}
