package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;
public class ItemListDeleteConfirmDAO {

	private ItemListDTO itemListDTOList =new ItemListDTO();
	DBConnector dbConnector =new DBConnector();
	Connection connection =dbConnector.getConnection();

	public ItemListDTO getItemListInfo(String id) {
		String sql ="SELECT * FROM item_info_transaction WHERE id=?";
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			ResultSet resultSet =preparedStatement.executeQuery();
			if(!(resultSet.getString("id").equals(null))) {
				itemListDTOList.setItemListFlg(true);
			}
			itemListDTOList.setCheckFlg(resultSet.getString("checkFlg"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return itemListDTOList;
	}
	public ItemListDTO getItemListDTO() {
		return itemListDTOList;
	}
}
