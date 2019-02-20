package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	private String sql = "INSERT INTO user_buy_item_info_transaction"
			+ "(item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) "
			+ "VALUES(?,?,?,?,?,?)";

	public int buyItemInfo(String item_transaction_id, String total_price, String total_count, String login_user_id, String pay)
			throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil date = new DateUtil();
		int count = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, login_user_id);
			ps.setString(5, pay);
			ps.setString(6, date.getDate());

			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return count;
	}

	private String sql2 = "UPDATE item_info_transaction SET item_stock =? WHERE id =?";

	public void updateItemStock(int buyItemStock, String id) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		PreparedStatement ps2 = con.prepareStatement(sql2);

		try {
			ps2.setInt(1, buyItemStock);
			ps2.setString(2, id);
			ps2.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
