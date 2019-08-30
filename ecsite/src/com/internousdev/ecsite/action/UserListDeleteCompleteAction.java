package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserListDeleteCompleteAction extends ActionSupport{
	public Map<String,Object>session;
	private ArrayList<UserInfoDTO> userInfoDTO=new ArrayList<UserInfoDTO>();
	private String message;

	public String execute() throws SQLException{

		String result =ERROR;
		UserListDeleteCompleteDAO userDeleteDAO = new UserListDeleteCompleteDAO();

		int res=userDeleteDAO.userListDelete();

		if(res > 0) {
			userInfoDTO=null;
			setMessage("ユーザー情報を正しく削除しました。");

		}else if(res == 0) {
			setMessage("ユーザー情報の削除に失敗しました。");

		}result = SUCCESS;
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<UserInfoDTO> getUserInfoDTO() {
		return userInfoDTO;
	}

	public void setUserInfoDTO(ArrayList<UserInfoDTO> userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
