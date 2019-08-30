package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {

	public void createUser(String loginUserId, String loginUserPassword,String userName)throws SQLException{
		DBConnector dbConnector= new DBConnector();
		Connection connection=dbConnector.getConnection();
		DateUtil dateUtil=new DateUtil();
		String sql="INSERT INTO login_user_transaction(login_id,login_pass,user_name,insert_date)VALUES(?,?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateUtil.getDate());

//actionに件数など返さないときexecute。ただ実行する。
			preparedStatement.execute();

		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			connection.close();
		}
	}

	public boolean isExistLoginId(String loginUserId) throws SQLException {
		DBConnector dbConnector= new DBConnector();
		Connection connection=dbConnector.getConnection();
		boolean result= false;
		String sql="SELECT COUNT(*) AS count FROM login_user_transaction WHERE login_id=?";
		try {

			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				if(rs.getInt("count")>0) {
					result=true;
				}
			}

	}catch(Exception e) {
		e.printStackTrace();

	}
		return result;
}
}