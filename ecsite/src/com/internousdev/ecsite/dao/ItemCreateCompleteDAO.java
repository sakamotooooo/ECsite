package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;


public class ItemCreateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection con=dbConnector.getConnection();
	private String sql="INSERT INTO item_info_transaction(item_name,item_price,item_stock)VALUES(?,?,?)";

	public void itemCreate(String newItemName, String newItemPrice, String newItemStock) throws SQLException{
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newItemName);
			ps.setString(2, newItemPrice);
			ps.setString(3, newItemStock);

			ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();

		}finally {
			con.close();
		}


	}
}
