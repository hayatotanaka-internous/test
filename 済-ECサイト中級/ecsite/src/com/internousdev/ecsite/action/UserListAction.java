package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;
public class UserListAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private List<UserListDTO> userList =new ArrayList<UserListDTO>();

	public String execute() throws SQLException {
		UserListDAO userListDAO =new UserListDAO();
		userList = userListDAO.getUserListDTO();
		String result = SUCCESS;
		return result;
	}


	public List<UserListDTO> getUserList(){
		return userList;
	}
	public void setUserList(List<UserListDTO> userList){
		this.userList =userList;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session =session;
	}

	public Map<String, Object> getSession(){
		return session;
	}
}
