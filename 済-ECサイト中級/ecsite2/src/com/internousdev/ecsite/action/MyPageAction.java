package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	private String message;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private String deleteFlg;
	public Map<String, Object> session;
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

	public String execute() throws SQLException {

		String result = ERROR;
		if (session.containsKey("admin_flg")) {
			result = "back";
		}
		if (!session.containsKey("id")) {
			result = ERROR;
		}
		String itid = session.get("id").toString();
		String usid = session.get("login_user_id").toString();
		if (deleteFlg == null) {
			myPageList = myPageDAO.getMyPageUserInfo(itid, usid);
		} else if (deleteFlg.equals("1")) {
			delete();
		}
		result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {
		String itid = session.get("id").toString();
		String usid = session.get("login_user_id").toString();
		int res = myPageDAO.buyItemHistoryDelete(itid, usid);
		if (res > 0) {
			myPageList = null;
			setMessage("商品情報を正しく削除しました。");
		} else if (res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<MyPageDTO> getMyPageList() {
		return myPageList;
	}

	public void setMyPageList(ArrayList<MyPageDTO> myPageList) {
		this.myPageList = myPageList;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}