package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {

	public boolean isExistsUser(String loginUserId) {
		boolean result = false;
		String sql1 = "SELECT COUNT(login_id) FROM login_user_transaction WHERE login_id=?";
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		try {
			PreparedStatement pr = con.prepareStatement(sql1);
			pr.setString(1, loginUserId);
			ResultSet rs = pr.executeQuery();
			if (rs.next()) {
				if (rs.getInt("COUNT") > 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int createUser(String loginUserId, String loginUserPassword, String userName) throws SQLException {
		String sql2 = "INSERT INTO login_user_transaction(login_id,login_pass, user_name,insert_date) VALUES(?,?,?,?)";
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int count = 0;
		try {
			PreparedStatement pr = con.prepareStatement(sql2);
			pr.setString(1, loginUserId);
			pr.setString(2, loginUserPassword);
			pr.setString(3, userName);
			pr.setString(4, dateUtil.getDate());
			count = pr.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return count;
	}
}
