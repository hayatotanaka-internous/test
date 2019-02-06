package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{

	public String execute() throws SQLException{
		String result = ERROR;
		UserListDeleteCompleteDAO userListDeleteCompleteDAO = new UserListDeleteCompleteDAO();
		int res = userListDeleteCompleteDAO.deleteUserList();
		int admin = userListDeleteCompleteDAO.adminUserList();
		if (res > 0) {
			result =SUCCESS;
		} else if(res >= admin){
			result ="fail";
		}
		return result;
	}
}