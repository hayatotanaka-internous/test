package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;
public class BuyItemDAO {

/*	public BuyItemDTO getBuyItemInfo(String item_Name) {*/
	public BuyItemDTO getBuyItemInfo() {
		BuyItemDTO buyItemDTO =new BuyItemDTO();

		String sql ="SELECT id, item_name, item_price,item_stock FROM item_info_transaction "
				/*+ "WHERE item_name =?"*/;
		try {
			DBConnector dbConnector =new DBConnector();
			Connection connection =dbConnector.getConnection();
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
/*			preparedStatement.setString(1, item_Name);*/
			ResultSet resultSet =preparedStatement.executeQuery();
			if(resultSet.next()) {
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				buyItemDTO.setItemStock(resultSet.getString("item_stock"));
				if(Integer.parseInt(resultSet.getString("item_stock")) <1){
					String sql2 ="SELECT id, item_name, item_price,item_stock FROM item_info_transaction "
							+ "WHERE id =id+1";
					preparedStatement =connection.prepareStatement(sql2);
					buyItemDTO.setId(resultSet.getInt("id"));
					buyItemDTO.setItemName(resultSet.getString("item_name"));
					buyItemDTO.setItemPrice(resultSet.getString("item_price"));
					buyItemDTO.setItemStock(resultSet.getString("item_stock"));
				} else{

				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return buyItemDTO;
	}

}