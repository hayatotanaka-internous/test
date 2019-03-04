package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	private String sql = "INSERT INTO user_buy_item_transaction"
			+ "(item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) "
			+ "VALUES(?,?,?,?,?,?)";

	public int buyItemInfo(String itemTransactionId, String totalPrice, String totalCount, String loginUserId,
			String payment) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil date = new DateUtil();
		int count = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itemTransactionId);
			ps.setString(2, totalPrice);
			ps.setString(3, totalCount);
			ps.setString(4, loginUserId);
			ps.setString(5, payment);
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
