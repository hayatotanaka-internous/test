package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;
public class UserCreateCompleteDAO {

	public boolean isExistsUser(String loginUserId){
		boolean result = false;
		String sql2 ="SELECT COUNT(login_id) from login_user_transaction where login_id =?";
		DBConnector dbConnector =new DBConnector();
		Connection connection =dbConnector.getConnection();
		try{
			PreparedStatement preparedStatement =connection.prepareStatement(sql2);
			preparedStatement.setString(1, loginUserId);
			ResultSet resultSet =preparedStatement.executeQuery();
			if(resultSet.next()){
				if(resultSet.getInt("COUNT") >0){
					result =true;
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public int createUser(String loginUserId, String loginUserPassword, String userName) throws SQLException{
		String sql ="INSERT INTO login_user_transaction(login_id, login_pass, user_name, insert_date) VALUES(?,?,?,?)";
		DBConnector dbConnector =new DBConnector();
		Connection connection =dbConnector.getConnection();
		DateUtil dateUtil =new DateUtil();
		int count = 0;
		try{
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateUtil.getDate());
			count = preparedStatement.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return count;
	}
}