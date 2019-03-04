package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	String sql = "SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date "
			+ "FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit "
			+ "ON ubit.item_transaction_id WHERE ubit.item_transaction_id =? AND ubit.user_master_id =? ORDER BY insert_date DESC";

	public ArrayList<MyPageDTO> getMyPageUserInfo(String itid, String usid) throws SQLException {

		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itid);
			ps.setString(2, usid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsertDate(rs.getString("insert_date"));
				myPageDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return myPageDTO;
	}

	String sql2 = "DELETE FROM user_buy_item_transaction WHERE item_transaction_id =? AND user_master_id =?";

	public int buyItemHistoryDelete(String itid, String usid) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql2);
			ps.setString(1, itid);
			ps.setString(2, usid);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}
