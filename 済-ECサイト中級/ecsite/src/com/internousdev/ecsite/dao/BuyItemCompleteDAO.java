package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.action.BuyItemAction;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;
public class BuyItemCompleteDAO {


	public BuyItemAction buyItemAction =new BuyItemAction();

	private String sql ="INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) VALUES(?,?,?,?,?,?)";

	public int buyItemInfo(String item_transaction_id ,String total_price, String total_count, String user_master_id, String pay) throws SQLException{
		DBConnector dbConnector =new DBConnector();
		Connection connection =dbConnector.getConnection();
		DateUtil dateUtil =new DateUtil();
		int count = 0;
		try{
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2,total_price);
			preparedStatement.setString(3,total_count);
			preparedStatement.setString(4,user_master_id);
			preparedStatement.setString(5,pay);
			preparedStatement.setString(6,dateUtil.getDate());

			count = preparedStatement.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return count;
	}

	private String sql2 ="UPDATE item_info_transaction SET item_stock =? WHERE id =?";

	public void updateItemStock(int itemStock, String id) throws SQLException{
			DBConnector dbConnector =new DBConnector();
			Connection connection =dbConnector.getConnection();
		try{
			PreparedStatement preparedStatement2 =connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, itemStock);
			preparedStatement2.setString(2, id);
			preparedStatement2.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			connection.close();
		}
	}
}
