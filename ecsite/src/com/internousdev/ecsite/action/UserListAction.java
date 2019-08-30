package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserListAction extends ActionSupport implements SessionAware{
	private UserListDAO userListDAO = new UserListDAO();
	private ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();
	public Map<String,Object>session;
	private String errorMessage;

	public String execute() throws SQLException{
		String result=ERROR;
		userInfoDTO = userListDAO.getUserInfo();
//		System.out.println(userListDAO.getUserInfo());DAOから取得できていなかった。

		if(userInfoDTO!=null) {
			result=SUCCESS;
		}
		else {
			errorMessage="ユーザー情報がありません。";
		}

		return result;
	}

	public UserListDAO getUserListDAO() {
		return userListDAO;
	}

	public void setUserListDAO(UserListDAO userListDAO) {
		this.userListDAO = userListDAO;
	}

	public ArrayList<UserInfoDTO> getUserInfoDTO() {
		return userInfoDTO;
	}

	public void setUserInfoDTO(ArrayList<UserInfoDTO> userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	}

