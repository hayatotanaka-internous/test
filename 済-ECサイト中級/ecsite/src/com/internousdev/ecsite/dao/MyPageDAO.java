package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;
public class MyPageDAO {

	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id) throws SQLException{
		ArrayList<MyPageDTO> myPageDTO =new ArrayList<MyPageDTO>();

		String sql1 ="SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date "
				+ "FROM user_buy_item_transaction ubit "
				+ "LEFT JOIN item_info_transaction iit "
				+ "ON ubit.item_transaction_id =iit.id "
				+ "WHERE ubit.item_transaction_id =? AND ubit.user_master_id =? "
				+ "ORDER BY insert_date DESC";

		DBConnector dbConnector =new DBConnector();
		Connection connection =dbConnector.getConnection();
		try{
			PreparedStatement preparedStatement1 =connection.prepareStatement(sql1);
			preparedStatement1.setString(1, item_transaction_id);
			preparedStatement1.setString(2, user_master_id);

			ResultSet resultSet1 =preparedStatement1.executeQuery();
			while(resultSet1.next()){
				MyPageDTO dto =new MyPageDTO();
				dto.setId(resultSet1.getString("id"));
				dto.setItemName(resultSet1.getString("item_name"));
				dto.setTotalPrice(resultSet1.getString("total_price"));
				dto.setTotalCount(resultSet1.getString("total_count"));
				dto.setPayment(resultSet1.getString("pay"));
				dto.setInsert_date(resultSet1.getString("insert_date"));
				myPageDTO.add(dto);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return myPageDTO;
	}
	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id) throws SQLException{
		String sql2 ="DELETE FROM user_buy_item_transaction "
				+ "WHERE item_transaction_id=? AND user_master_id=?";
		PreparedStatement preparedStatement2;
		int result =0;
		DBConnector dbConnector =new DBConnector();
		Connection connection =dbConnector.getConnection();
		try{
			preparedStatement2 =connection.prepareStatement(sql2);
			preparedStatement2.setString(1, item_transaction_id);
			preparedStatement2.setString(2, user_master_id);
			result =preparedStatement2.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return result;
	}
}
