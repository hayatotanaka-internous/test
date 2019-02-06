package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport{

	public String execute() throws SQLException{
		String result = ERROR;
		ItemListDeleteCompleteDAO itemListDeleteCompleteDAO = new ItemListDeleteCompleteDAO();
		int res = itemListDeleteCompleteDAO.deleteItemList();
		if (res > 0) {
			result =SUCCESS;
		}
		return result;
	}
}