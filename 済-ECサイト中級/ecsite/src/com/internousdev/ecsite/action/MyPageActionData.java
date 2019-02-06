package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;

public class MyPageActionData {
	public Map<String, Object> session;
	public MyPageDAO myPageDAO;
	public ArrayList<MyPageDTO> myPageList;
	public String deleteFlg;
	public String message;

	public MyPageActionData(MyPageDAO myPageDAO, ArrayList<MyPageDTO> myPageList) {
		this.myPageDAO = myPageDAO;
		this.myPageList = myPageList;
	}
}