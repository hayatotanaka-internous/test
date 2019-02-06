package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;
public class ItemListDAO {

	private DBConnector dbConnector =new DBConnector();
	private Connection connection =dbConnector.getConnection();
	public List<ItemListDTO> getItemListDTO() throws SQLException{
		List<ItemListDTO> itemListDTOList =new ArrayList<ItemListDTO>();

		String sql ="SELECT * FROM item_info_transaction "
				+ "ORDER BY insert_date";

		try{
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()){
				ItemListDTO dto =new ItemListDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItem_Name(resultSet.getString("item_Name"));
				dto.setItem_Price(resultSet.getString("item_Price"));
				dto.setItem_Stock(resultSet.getString("item_Stock"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setUpdate_date(resultSet.getString("update_date"));
				itemListDTOList.add(dto);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return itemListDTOList;
	}
}
