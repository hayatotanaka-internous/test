package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	public BuyItemDTO getBuyItemInfo() {
		BuyItemDTO buyItemDTO =new BuyItemDTO();

		String sql ="SELECT id, item_name, item_price, item_stock FROM item_info_transaction";
		try{
			DBConnector db =new DBConnector();
			Connection con =db.getConnection();
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			if(rs.next()){
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getInt("item_price"));
				buyItemDTO.setItemStock(rs.getInt("item_stock"));
				if(rs.getInt("item_stock") <1){
					String sql2 ="SELECT id, item_name, item_stock, FROM item_info_transaction WHERE id =id+1";
					ps =con.prepareStatement(sql2);
					buyItemDTO.setId(rs.getInt("id"));
					buyItemDTO.setItemName(rs.getString("item_name"));
					buyItemDTO.setItemPrice(rs.getInt("item_price"));
					buyItemDTO.setItemStock(rs.getInt("item_stock"));
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}

}
