package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private LoginDTO loginDTO=new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword) {
		String sql="SELECT*FROM login_user_transaction where login_id=? AND login_pass=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);

			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet=preparedStatement.executeQuery();

			if(resultSet.next()) {//ここって何してるの？getStringの中身はなに？→sqlで自分が設定した値。
				//それをLoginDTOにセットしてる。じゃあresultSetの記述は?
			//LoginDTOのsetterを呼び出し、テーブルの値をDTOに格納する。
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));

				//login_idに値が入っていたらDTOのfalseをtrueに変える
				if(resultSet.getString("login_id")!=null) {
					loginDTO.setLoginFlg(true);
				}
				loginDTO.setAdminFlg(resultSet.getString("admin_flg"));

			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		//値の入ったLoginDTOをActionのloginDTOに返す。処理結果のこと。メソッド内には必ずかく。
		//基本DAOとActionクラスのやりとり。
			return loginDTO;
		}


}
